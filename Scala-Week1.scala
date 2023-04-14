// My Name: Ha Duong
// My Student Number : 000938415

object Main {
  def main(args: Array[String]): Unit = {
    //Task 1
    var mutableVariable = "Hello World" // mutableVariable can be reassigned to a new value
    val immutableVariable = "Hi World"  // immutableVariable cannot be reassigned to a new value
    //If you reassign a value to a val variable (immutableVariable), you will get a compile error
    immutableVariable = "Error"
    //Task 2
    val isPrime = true // infers Boolean type
    val height = 188.5 // infers Double type
    val numberChairs = 50 // infers Int type
    val language = "Scala Programming" // infers String type
    //Task 3
    val firstCharacter: Char = 'H'
    val secondCharacter: Char = 'a'
    val lastName: String = s"$firstCharacter$secondCharacter"
    println(lastName);
    //Task 4
    val age: Int = 19
    val introduction = s"I am learning Scala at the age of $age years."
    println(introduction)
    //Task 5
    //In Scala, an expression is a combine of values, variables, operators, and method calls that returns a result. Expression can be assigned to a variable, function,...
    // Example : val x = 5 + 234 * 231

    //Task 6
    val value = 13
    val ans = if (value > 0) {
      1
    } else if (value == 0) {
      0
    } else {
      -1
    }
    println(ans);
    //Task 7
    val firstName = "Duong"

    val fullName: String = {
      val sep: String = " "
      firstName + sep + lastName
    }
    println(fullName)
    //Task 8

    def sumOfTwoNumbers(x: Int, y: Int): String = {
      val sum = x + y
      s"The sum of $x and $y is: $sum"
    }
    println(sumOfTwoNumbers(9, 7))
  }
}