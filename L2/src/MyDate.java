// MyDate
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
public class MyDate {
  private int year;
  private int month;
  private int day;

  public MyDate(int day,int month,int year) throws IllegalArgumentException{
    if (year > 0 && month > 0 && month < 13 && day > 0 && day < 32){
      if (isLeapYear(year)){ // leap year
        if (month == 2 && day <= 29){
          this.day = day;
          this.month = month;
          this.year = year;
        } else if (isBigMonth(month)) { // 1 3 5 7 8 10 12
          this.day = day;
          this.month = month;
          this.year = year;
        } else if (isSmallMonth(month) && day <= 30) { // 1 3 5 7 8 10 12
          this.day = day;
          this.month = month;
          this.year = year;
        }
      } else {
        if (month == 2 && day <= 28){ // normal year
          this.day = day;
          this.month = month;
          this.year = year;
        } else if (isBigMonth(month)) { // 1 3 5 7 8 10 12
          this.day = day;
          this.month = month;
          this.year = year;
        } else if (isSmallMonth(month) && day <= 30) { // 1 3 5 7 8 10 12
          this.day = day;
          this.month = month;
          this.year = year;
        }
      }
    } else {
        throw new IllegalArgumentException("Year or month or day is invalid");
      }
    }


  public void advance(int days){
    if (days == 0){
      System.out.println("Advancing/Retreating is done.\n");
    }
    else {
      if (isLeapYear(this.year)){ // leap year
        System.out.println("It's a leap year");
        if (Math.abs(days) >= 366){ // advancing/retreating the date for more than a year
          if (days > 0){ // advancing
            this.year += 1;
            System.out.println("Advance 1 leap year");
            advance(days-366);
          } else { // retreating
            this.year += 1;
            System.out.println("Retreat a leap year");
            advance(days + 366);
          }
        } else if (Math.abs(days) >= 29) { // advancing/retreating for more than two months
          if (isBigMonth(this.month)){
            if (days >0){
              this.month += 1;
              System.out.println("Advance a big month");
              advance(days-31);
            } else {
              this.month += 1;
              System.out.println("Retreat a big month");
              advance(days+31);
            }
          } else if (isSmallMonth(this.month)) {
            if (days >0){
              this.month += 1;
              System.out.println("Advance a big month");
              advance(days-30);
            } else {
              this.month += 1;
              System.out.println("Retreat a small month");
              advance(days+30);
            }
          } else {
            if (days >0){
              this.month += 1;
              System.out.println("Advance 29 days");
              advance(days-29);
            } else {
              this.month += 1;
              System.out.println("Retreat 29 days");
              advance(days+29);
            }
          }
        } else { // advancing/retreating for less than one month
          if (days > 0){
            // advancing
            if (this.month == 2) { // Feb
              if (this.day + days > 29) {
                this.month += 1;
                System.out.println("Advance across two months");
                this.day = days - (29 - this.day);
                advance(0);
              } else {
                this.day += days;
                System.out.println("Advance within leap Feb");
                advance(0);
              }
            } else if (this.month < 12 && isBigMonth(this.month)) { // big months
              if (this.day + days > 31) {
                this.month += 1;
                System.out.println("Advance across two months");
                this.day = days - (31 - this.day);
                advance(0);
              } else {
                System.out.println("Advance within a big month");
                this.day += days;
                advance(0);
              }
            } else if (this.month < 12 && isSmallMonth(this.month)) {
              if (this.day + days > 30) {
                this.month += 1;
                System.out.println("Advance across two months");
                this.day = days - (30 - this.day);
                advance(0);
              } else {
                System.out.println("Advance across within a small month");
                this.day += days;
                advance(0);
              }
            } else if (this.month == 12) {
              if (this.day + days > 31) {
                this.year += 1;
                this.month = 1;
                System.out.println("Advance across two years");
                this.day = days - (30 - this.day);
                advance(0);
              } else {
                System.out.println("Advance within Dec");
                this.day += days;
                advance(0);
              }
            }

          } else {
            //retreating
            if (this.year < 1){
              System.out.println("Set retreat baseline to A.D. 0001");
              this.year = 1;
              this.month = 1;
              this.day = 1;
              advance(0);
            }
            if (this.month == 1) {
              if (this.day - days > 0) {
                System.out.println("Retreat within Jan");
                this.day += days;
                advance(0);
              } else {
                this.year += 1;
                this.month = 12;
                System.out.println("Retreat across two years");
                this.day = 31 - (days - this.day);
                advance(0);
              }
            } else if (this.month == 3) {
              if (this.day - days > 0) {
                this.day += days;
                System.out.println("Retreat within Mar");
                advance(0);
              } else {
                this.month += 1;
                System.out.println("Retreat to Feb");
                this.day = 29 - (days - this.day);
                advance(0);
              }
            } else if (isBigMonth(this.month-1)) {
              if (this.day - days > 0) {
                this.day += days;
                System.out.println("Retreat within a Big month");
                advance(0);
              } else {
                this.month += 1;
                System.out.println("Retreat across two months");
                this.day = 31 - (days - this.day);
                advance(0);
              }
            } else if (isSmallMonth(this.month-1)) {
              if (this.day - days > 0) {
                this.day += days;
                System.out.println("Retreat within a small month");
                advance(0);
              } else {
                this.month += 1;
                System.out.println("Retreat across two months");
                this.day = 30 - (days - this.day);
                advance(0);
              }
            }
          }
        } // end of leap year
      } else { // normal year
        System.out.println("It's a normal year");
        if (Math.abs(days) >= 365){ // advancing/retreating the date for more than a year
          if (days > 0){ // advancing
            this.year += 1;
            System.out.println("Advance 1 normal year");
            advance(days-365);
          } else { // retreating
            this.year += 1;
            System.out.println("Retreat 1 leap year");
            advance(days + 365);
          }
        } else if (Math.abs(days) >= 28) { // advancing/retreating for > 1 month
          if (isBigMonth(this.month)){
            if (days >0){
              this.month += 1;
              System.out.println("Advance 1 big month");
              advance(days-31);
            } else {
              this.month += 1;
              System.out.println("Retreat 1 big month");
              advance(days+31);
            }
          } else if (isSmallMonth(this.month)) {
            if (days >0){
              this.month += 1;
              System.out.println("Advance 1 small month");
              advance(days-30);
            } else {
              this.month += 1;
              System.out.println("Retreat 1 small month");
              advance(days+30);
            }
          } else {
            if (days >0){
              this.month += 1;
              System.out.println("Advance 1 Feb");
              advance(days-28);
            } else {
              this.month += 1;
              System.out.println("Retreat 1 Feb");
              advance(days+28);
            }
          }
        } else { // advancing/retreating for less than one month
          if (days > 0){
            // advancing
            if (this.month == 2) { // Feb
              if (this.day + days > 28) {
                this.month += 1;
                System.out.println("Advance across two months from Feb");
                this.day = days - (28 - this.day);
                advance(0);
              } else {
                this.day += days;
                System.out.println("Advance within Feb");
                advance(0);
              }
            } else if (this.month < 12 && isBigMonth(this.month)) { // big months
              if (this.day + days > 31) {
                this.month += 1;
                System.out.println("Advance across two months from big months");
                this.day = days - (31 - this.day);
                advance(0);
              } else {
                this.day += days;
                System.out.println("Advance across within big months");
                advance(0);
              }
            } else if (this.month < 12 && isSmallMonth(this.month)) {
              if (this.day + days > 30) {
                this.month += 1;
                System.out.println("Advance across two months from small months");
                this.day = days - (30 - this.day);
                advance(0);
              } else {
                //System.out.println(this.toString());
                this.day += days;
                System.out.println("N: Advance within small months");
                //System.out.println(this.toString());
                advance(0);
              }
            } else if (this.month == 12) {
              if (this.day + days > 31) {
                this.year += 1;
                this.month = 1;
                System.out.println("Advance across two years");
                this.day = days - (30 - this.day);
                advance(0);
              } else {
                System.out.println("Advance within Dec");
                this.day += days;
                advance(0);
              }
            }

          } else {
            //retreating
            if (this.year < 1){
              System.out.println("Set retreat baseline to A.D. 0001");
              this.year = 1;
              this.month = 1;
              this.day = 1;
            }
            if (this.month == 1) {
              if (this.day - days > 0) {
                System.out.println("Retreat within Jan");
                this.day += days;
                advance(0);
              } else {
                this.year += 1;
                this.month = 12;
                System.out.println("Retreat across two years from Jan");
                this.day = 31 - (days - this.day);
              }
            } else if (this.month == 3) {
              if (this.day - days > 0) {
                this.day += days;
                System.out.println("Retreat within a Big month");
                advance(0);
              } else {
                this.month += 1;
                System.out.println("Retreat From Mar to Feb");
                this.day = 28 - (days - this.day);
              }
            } else if (isBigMonth(this.month-1)) {
              if (this.day - days > 0) {
                this.day += days;
                System.out.println("Retreat within a Big month");
                advance(0);
              } else {
                this.month += 1;
                System.out.println("Retreat across Big months");
                this.day = 31 - (days - this.day);
              }
            } else if (isSmallMonth(this.month-1)) {
              if (this.day - days > 0) {
                this.day += days;
                System.out.println("Retreat within a small month");
                advance(0);
              } else {
                this.month += 1;
                System.out.println("Retreat across small months");
                this.day = 30 - (days - this.day);
              }
            }
          }
        }
      }
    }
  }

  private boolean isBigMonth(int month){
    return month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12;
  }

  private boolean isSmallMonth(int month){
    return month == 4 || month == 6 || month == 9 || month == 11;
  }

  public String toString(){
    return String.format("%s-%s-%s", this.year, this.month, this.day);
  }


  private boolean isLeapYear(int year){
    return year % 4 == 0 && (year % 100 != 0 || ((year % 100 == 0) && (year % 400 == 0)));
  }
}