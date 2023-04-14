// My Name: Ha Duong
// My Student Number : 000938415

object Main {
    
    def main(args: Array[String]): Unit = {
        //Task 1:
        // The function will keep adding a by one until b is equal to 0.
        // The result will be the sum of a and b.
        def addition(a: Int, b: Int): Int = {
            if (b == 0) {
                a
            }
            else addition(a + 1, b - 1)
        }
        println("Addition: 2 + 3 = " + addition(2, 3))
        println("Addition: 3 + 4 = " + addition(3, 4))
        println("Addition: 5 + 6 = " + addition(5, 6))
        //Task 2:
        // a + (-b) = a - b
        def subtraction(a: Int, b: Int): Int = {
            addition(a, -b)
        }
        println("Subtraction: 9 - 3 = " + subtraction(9, 3))
        println("Subtraction: 10 - 5 = " + subtraction(10, 5))
        //Task 3:
        // a * b = a + a + a + ... + a (b times)
        def multiplication(a: Int, b: Int): Int = {
            if (b == 0 || a == 0) {
                0
            }
            else if (b < 0) {
                multiplication(-a, -b)
            }
            else addition(a, multiplication(a, b - 1))
        }
        println("Multiplication: 23 * 4 = " + multiplication(23, 4))
        println("Multiplication: 9 * 6 = " + multiplication(9, 6))
        //Task 4:
        // a / b = a - b - b - b - ... - b (until a < b)
        // a / b = 1 + (a - b) / b
        def division(firstNum: Int, secondNum: Int): Int = {
            if (secondNum == 0) {
                println("Error: The second number must not be zero")
                return 0;
            }
            else if (firstNum == 0) {
                0
            }
            else if (firstNum < 0 && secondNum < 0) {
                division(-firstNum, -secondNum)
            }
            else if (firstNum < 0 || secondNum < 0) {
                -division(Math.abs(firstNum), Math.abs(secondNum))
            }
            else if (firstNum < secondNum) {
                0
            }
            else {
                1 + division(subtraction(firstNum, secondNum), secondNum)
            }
        }
        println("Division: 10 / 2 = " + division(10, 2))
        println("Division: 13 / 3 = " + division(13, 3))
        println("Division: -4 / 3 = " + division(-4, 3))
        //Task 5:
        // 5! = 5 * 4 * 3 * 2 * 1
        
        def factorial (num : Int) : Int = {
            if (num == 0) {
                1
            }
            else {
                multiplication(num, factorial(num - 1))
            }
        }
        println("Factorial 5: " + factorial(5))
        println("Factorial 3: " + factorial(3))
        //Task 6:
        def isPrime (num : Int) : Boolean = {
            if (num <= 1 ) {
                false
            }
            else if (num == 2) {
                true
            }
            else {
                val sqrtNum = Math.sqrt(num).toInt
                def isDivisibleBy(n: Int): Boolean = num % n == 0
                def isPrimeTest(t: Int): Boolean = {
                    if (t > sqrtNum) {
                        true
                    }
                    else if (isDivisibleBy(t)) {
                        false
                    }
                    else {
                        isPrimeTest(t + 1)
                    }
                }
                isPrimeTest(2)
            }
        }
        println("Is Prime 13 : " + isPrime(13))
        println("Is Prime 15 : " + isPrime(15))
        
        //Task 7:
        /*
        Recursion typically uses more memory than iteration because each recursive call adds a new stack frame
        to the call stack, whereas the loop variables can be reused in each iteration.
        For example in this line of code:
        
        sum = 1
        for (i <- 1 to n) {
          sum = sum * i
        }
        
        The loop variable i is reused in each iteration, whereas in the following recursive function
        def factorial(n: Int): Int = {
          if (n == 0) 1
          else n * factorial(n - 1)
        }
        The new stack frame (n) for each recursive call is added to the call stack.
        But in some cases using tail-recursive functions or some specific conditions recursion can be more efficient than iteration.
        */
        // Task 8:
        /* Local scope: The scope of a variable is limited to the block of code in which it is defined such as a loop, a function.
        Local scope can not be accessed outside of the block of code and will be destroyed when the block of code is finished.
        For example:
        def localFunction: Unit = {
            val x = 4
            println(a)
        }
        localFunction() // print 4
        println(a) // Error: a is not defined
        
        Global scope: The scope of a variable is the entire program. Global scope can be accessed anywhere in the program.
        For example:
        val x = 12
        def globalFunction: Unit = {
            println(x)
        }
        globalFunction() // print 12
        println(x) // print 12 no error
        
        */
    }
}