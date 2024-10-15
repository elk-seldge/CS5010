// In Vector3D
/*
 FIELDS
 ..this.x: double
 ..this.y: double
 ..this.z: double
 METHODS
 ..this.toString(): String
 ..this.Vector3D(): void
 ..this.getX(): double
 ..this.getY(): double
 ..this.getZ(): double
 ..this.getMagnitude(): double
 ..this.normalize(): Vector3D
 */
public class Vector3D {
  private double x;
  private double y;
  private double z;

  /**
   * The constructor to initialize the
   * @param x x coordinate
   * @param y y coordinate
   * @param z z coordinate
   */
  public Vector3D (double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * x getter
   * @return x value
   */
  public double getX() {
    return this.x;
  }

  /**
   * y getter
   * @return y value
   */
  public double getY() {
    return this.y;
  }

  /**
   * z getter
   * @return z value
   */
  public double getZ() {
    return this.z;
  }

  /**
   * Calculate the magnitude of the 3D vector
   * @return magnitude in double form
   */
  public double getMagnitude() {
    return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
  }

  /**
   * This method returns a normalized 3D vector, and also check for vector
   * could not be normalized, or will be cast to zero after normalized
   * @return normalized 3D vector
   */
  public Vector3D normalize() {
    if (this.x + this.y + this.z != 0) {
      double mag = getMagnitude();
      double newX = this.x / mag;
      double newY = this.y / mag;
      double newZ = this.z / mag;
      if (this.x != 0 && newX == 0) {
        throw new IllegalArgumentException("x is too small causing normalization to fail");
      } else if (this.y != 0 && newY == 0) {
        throw new IllegalArgumentException("y is too small causing normalization to fail");
      } else if (this.z != 0 && newZ == 0) {
        throw new IllegalArgumentException("z is too small causing normalization to fail");
      } else {
        return new Vector3D(newX, newY, newZ);
      }
    } else {
      throw new IllegalArgumentException("Zero vector cannot be normalized.");
    }
  }

  /**
   * Convert the 3D vector to (x, y, z) form string
   * @return 3D vector string
   */
  @Override
  public String toString() {
    return String.format("(%.20f , %.20f, %.20f)", this.x, this.y, this.z);
  }
}
