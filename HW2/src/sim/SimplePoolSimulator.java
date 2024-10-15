// SimplePoolSimulator
/*
FIELDS
 ..this.dollars    : int
 ..this.cents    : int
 METHODS
 ..this.toString(): String
 ..this.add(Money other): Money
 ..this.add(int dollars, int cents): Money
 ..this.getDecimalValue(): double
 METHODS OF FIELDS
 ..this.center.distToOrigin(): double
 ..this.center.getX() : double
 ..this.center.getY() : double
 */
package sim;

import java.util.Objects;

public class SimplePoolSimulator implements PoolSimulator{

  private int width;
  private int height;

  private String type;

  private int ballRadius = Integer.MIN_VALUE;
  private double ballX = Double.NEGATIVE_INFINITY;

  private double ballY = Double.NEGATIVE_INFINITY;

  private  int ballSpd = 0;

  private  double ball_dx = 0;

  private double ball_dy = 0;

  /**
   * Constructor check for invalid inputs and initialize the elements if no exceptions were found
   * @param width width of the pool
   * @param height height of the pool
   * @param type type of simulation, can only be "simple" or "friction"
   * @throws IllegalArgumentException throws exception with corresponding error message
   */
  public SimplePoolSimulator(int width, int height, String type) throws IllegalArgumentException{
    // Gravity set to 9.81 N, friction coefficient set to 0.1, simple means to decrease the speed
    // by 5 after each collision
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("width or height cannot be negative");
    } else if (!type.equals("simple") && !type.equals("friction")) {
      throw new IllegalArgumentException("type mut be simple or friction");
    } else {
      this.width = width;
      this.height = height;
      this.type = type;
    }

  }

  /**
   * This method set the ball into the pool with given parameters and check for invalid inputs
   * @param x x position of the ball, x + radius should larger than 0 smaller than width, initially set to negative infinity means not set up yet
   * @param y y position of the ball, y + radius should larger than 0 smaller than height, initially set to negative infinity means not set up yet
   * @param radius radius of the ball, initially set to MIN_VALUE means not set up yet
   * @param speed initial speed of the ball, set to 0 before set up
   * @param dx initial x-direction speed unit vector of the ball, set to 0 before set up
   * @param dy initial x-direction speed unit vector of the ball, set to 0 before set up
   * @throws IllegalArgumentException throws exception when user trying to put the ball outside
   * the table
   */
  @Override
  public void start(int x, int y, int radius, int speed, double dx, double dy) throws IllegalArgumentException {
    this.getStatus(); // call getStatus() before start
    if (x + radius < 0 || x + radius > width || y + radius < 0 || y + radius > height){
      throw new IllegalArgumentException("cannot start from outside of the table");
    } else {
      this.ballX = x;
      this.ballY = y;
      this.ballRadius = radius;
      this.ballSpd = speed;
      this.ball_dx = dx;
      this.ball_dy = dy;
      this.getStatus(); // call getStatus() after start
    }
  }

  /**
   * looping advance the ball until the speed becomes zero
   */
  @Override
  public void advance() {
    double vx, vy, tx, ty; // velocity x,y components, time for x/y travel
    final double a = 0.981; // acceleration, constant
    double sx = (this.ball_dx>0) ? this.width - (this.ballX + this.ballRadius) :
            this.ballX + this.ballRadius; // get the initial travel x distance
    double sy = (this.ball_dy>0) ? this.height - (this.ballY + this.ballRadius) :
            this.ballY + this.ballRadius; // get the initial travel y distance

    if (Objects.equals(this.type, "simple")){
      // simple sim, decrease the speed by 5 each collision
      if (this.ballSpd != 0){
        vx = this.ballSpd * this.ball_dx; // initial x/y velocity components
        vy = this.ballSpd * this.ball_dy;
        while (vx != 0 || vy != 0) {
          tx = sx / Math.abs(vx); // initial x/y travel time
          ty = sy / Math.abs(vy);
          // y collide first
          if (Math.abs(vy) - 5 > 0){ // vy is not going to become zero after this collision
            vy = (vy > 0) ? -(Math.abs(vy) - 5) : (Math.abs(vy) - 5); // subtract 5 for
            // different y move directions
            this.ballY = (vy > 0) ? this.height-this.ballRadius : this.ballRadius; // set new
            // ball Y coordinate
            sy =  this.height - this.ballRadius; // set new y travel distance
            this.getStatus(); // call getStatus() after the collides with y-top/bottom
          } else {
            this.ballY = (vy > 0) ? this.height-this.ballRadius : this.ballRadius; // set new
            // ball Y coordinate
            sy = 0; // set y travel distance to zero
            vy = 0; // set y velocity components to zero
            this.getStatus(); // call getStatus() after the collision with y-top/bottom
          }
          if (Math.abs(vx) - 5 > 0) { // vx is not going to become zero after this collision
            vx = (vx > 0) ? -(Math.abs(vx) - 5) : (Math.abs(vx) - 5); // subtract 5 for
            // different x move directions
            this.ballX = (vx > 0) ? this.width-this.ballRadius : this.ballRadius;
            sx = this.width - this.ballRadius;
            this.getStatus(); // call getStatus() after the collision with left/right
          } else {
            this.ballX = (vx > 0) ? this.width-this.ballRadius : this.ballRadius;
            vx = 0;
            this.getStatus(); // call getStatus() after the collision with left/right
          }
          if (vx ==0 && vy == 0){ // if both velocity components are zero, set speed to 0, so the
            // next getStatus() returns correct result.
            this.ballSpd = 0;
            this.ball_dx = 0;
            this.ball_dy = 0;
          }
        }
      } else {
        this.getStatus(); // When stopped call getStatus()
      }
    } else {
      // friction sim, decrease the speed by acceleration produced by friction, no more
      // speed decrease by collision
      // v_0 = 1/2 a t; t = 2 * v_0 / a
      if (this.ballSpd != 0) {
        vx = this.ballSpd * this.ball_dx;
        vy = this.ballSpd * this.ball_dy;
        // time cost for vx and vy completely stopped
        while (Math.abs(vx) > 0 || Math.abs(vy) >0) {
          double tempX = 2 * vx / a;
          double tempY = 2 * vy / a;

          // problem is x = v0t + 1/2 a t^2
          // formula follows t = (-b +/- sqrt(b^2 - 4ac )) / 2a
          // consider the negative acceleration a, change both to:
          // x = v0t - 1/2at^2 => 1/2at^2 - v0t + x = 0; so (a = 1/2 * var a, b = v0, c = x);
          // the final formula is t = (-v0 +/- sqrt(v0^2 - 2ac )) / a
          // time cost for x disposition
          tx = ((-vx + Math.sqrt(Math.pow(vx, 2) - 2 * a * sx)) / a > 0) ?
                  (-vx + Math.sqrt(Math.pow(vx, 2) - 2 * a * sx)) / a :
                  (-vx - Math.sqrt(Math.pow(vx, 2) - 2 * a * sx)) / a;
          // time cost for y disposition
          ty = ((-vy + Math.sqrt(Math.pow(vy, 2) - 2 * a * sy)) / a > 0) ?
                  (-vy + Math.sqrt(Math.pow(vy, 2) - 2 * a * sy)) / a :
                  (-vy - Math.sqrt(Math.pow(vy, 2) - 2 * a * sy)) / a;

          if (tx > ty) {
            // x collide first
            if (tx > tempX) {
              // ball will not stop before this collision
              vx = (Math.abs(vx) > 0.5 * a * tx) ? -(Math.abs(vx) - 0.5 * a * tx) : 0;
              this.ballX = this.width - this.ballRadius;
              sx = (this.width - this.ballRadius > (Math.pow(vx, 2) / (2 * a))) ?
                      (Math.pow(vx, 2) / (2 * a)) :
                      this.width - this.ballRadius; // set sx depends on if the nex x collision could happen
              this.getStatus();
            } else { // stop before next collision
              if (vx>0){
                this.ballX += Math.pow(vx, 2) / 2 / a;
                vx = 0;
              } else {
                this.ballX -= Math.pow(vx, 2) / 2 / a;
                vx = 0;
              }


            }
            if (ty > tempY){
              vy = (Math.abs(vy) > 0.5 * a * ty) ? -(Math.abs(vy) - 0.5 * a * ty) : 0;
              this.ballY = this.height - this.ballRadius;
              sy = (this.height - this.ballRadius > (Math.pow(vy, 2) / (2 * a))) ? (Math.pow(vy, 2) / (2 * a)) :
                      this.height - this.ballRadius; // set sx depends on if the nex x collision could happen
              this.getStatus();
            } else {
              if (vy>0){
                this.ballY += Math.pow(vy, 2) / 2 / a;
                vy = 0;
              } else {
                this.ballY -= Math.pow(vy, 2) / 2 / a;
                vy = 0;
              }
            }

            if (vx ==0 && vy == 0){ // if both velocity components are zero, set speed to 0, so the
              // next getStatus() returns correct result.
              this.ballSpd = 0;
              this.ball_dx = 0;
              this.ball_dy = 0;
            }
          } else {
            if (ty > tempY){
              vy = (Math.abs(vy) > 0.5 * a * ty) ? -(Math.abs(vy) - 0.5 * a * ty) : 0;
              this.ballY = this.height - this.ballRadius;
              sy = (this.height - this.ballRadius > (Math.pow(vy, 2) / (2 * a))) ? (Math.pow(vy, 2) / (2 * a)) :
                      this.height - this.ballRadius; // set sx depends on if the nex x collision could happen
              this.getStatus();
            } else {
              if (vy>0){
                this.ballY += Math.pow(vy, 2) / 2 / a;
                vy = 0;
              } else {
                this.ballY -= Math.pow(vy, 2) / 2 / a;
                vy = 0;
              }
            }
            if (tx > tempX) {
              // ball will not stop before this collision
              vx = (Math.abs(vx) > 0.5 * a * tx) ? -(Math.abs(vx) - 0.5 * a * tx) : 0;
              this.ballX = this.width - this.ballRadius;
              sx = (this.width - this.ballRadius > (Math.pow(vx, 2) / (2 * a))) ?
                      (Math.pow(vx, 2) / (2 * a)) :
                      this.width - this.ballRadius; // set sx depends on if the nex x collision could happen
              this.getStatus();
            } else { // stop before next collision
              if (vx>0){
                this.ballX += Math.pow(vx, 2) / 2 / a;
                vx = 0;
              } else {
                this.ballX -= Math.pow(vx, 2) / 2 / a;
                vx = 0;
              }
          }
            if (vx == 0 && vy == 0){ // if both velocity components are zero, set speed to 0,
              // so the
              // next getStatus() returns correct result.
              this.ballSpd = 0;
              this.ball_dx = 0;
              this.ball_dy = 0;
            }
        }
        }
      } else {
        this.getStatus();
      }
    }

  }

  /**
   * width getter
   * @return width of this pool
   */
  @Override
  public int getTableWidth() {
    return this.width;
  }

  /**
   * height getter of this pool
   * @return height of this pool
   */
  @Override
  public int getTableHeight() {
    return this.height;
  }

  /**
   * ball X position getter
   * @return the X position of the ball in this pool
   */
  @Override
  public double getBallPositionX() {
    return this.ballX;
  }

  /**
   * ball Y position getter
   * @return the Y position of the ball in this pool
   */
  @Override
  public double getBallPositionY() {
    return this.ballY;
  }

  /**
   * ball radius getter
   * @return the radius of the ball in this pool
   */
  @Override
  public double getBallRadius() {
    return this.ballSpd;
  }
  /**
   * ball X velocity getter
   * @return return X direction speed of the ball in this pool
   */
  @Override
  public double getBallVelocityX() {
    return this.ballSpd * this.ball_dx;
  }

  /**
   * ball Y velocity getter
   * @return return Y direction speed of the ball in this pool
   */
  @Override
  public double getBallVelocityY() {
    return this.ballSpd * this.ball_dy;
  }

  /**
   * Get the current status of the ball on this pool
   * @return return the status in one of: "Ball not set up", "Simulation started", "Ball hit bottom edge",
   * "Ball hit top edge", "Ball hit left edge", "Ball hit right edge", "Ball is stationary"
   */
  @Override
  public String getStatus() {
    if (this.ballSpd == 0 ){
      return "Status: Ball is stationary";
    } else if (this.ballX - this.ballRadius == 0) {
      return "Status: Ball hit left edge";
    } else if (this.ballY - this.ballRadius == 0) {
      return "Status: Ball hit top edge";
    } else if (this.ballX + this.ballRadius == this.width) {
      return "Status: Ball hit right edge";
    } else if (this.ballY + this.ballRadius == this.height) {
      return "Status: Ball hit bottom edge";
    } else if (this.ballRadius == Integer.MIN_VALUE) {
      return "Status: Ball not set up";
    } else {
      return "Status: Simulation started";
    }

  }
}
