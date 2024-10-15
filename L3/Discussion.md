### Discussion

* 4.1 put the `add(int dollars, int cents)` into a class inside the interface like:

  ```java
  class hidden{
        private Money add(int dollars, int cents) {
          return null;
        }
      }
  ```

  But the hidden `add()` method could not see other methods in the interface.

* 4.2 

  * This problem has two cases: the cents overflow or not. Since it prohibits passing negative dollars or cents, there is no need to consider that `addOther()` or `addDC()` will produce a negative result. So, I simply test these two situations with an input and the expected result. And, for the invalid inputs, negative dollars/cents and cents greater than 100, I test them individually in the `testSimpleMoneyError()` method.

  * It is possible to categorize all the test inputs into six categories: negative dollars, negative cents, negative dollars/cents, regular dollars with cents greater than 100, regular dollars with cents overflow, and regular dollars/cents.

    

  * 