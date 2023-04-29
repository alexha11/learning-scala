// My Name: Ha Duong
// My Student ID: 000938415

object Main {
  def main(args: Array[String]): Unit = {
        //Task 1
        def lookingForPrimes(numbers: List[Int]): List[Either[String, Int]] = {
            def isPrime(n: Int): Boolean = {
                if (n <= 1) false
                else if (n == 2) true
                else !(2 until n).exists(x => n % x == 0)
            }
    
            numbers.map(n => if (isPrime(n)) Right(n) else Left(s"$n is not a prime number"))
        }
    
        val numbers = List(3, 6, 45, 43, 52, 61, 73, 89, 96, 105)
        val result = lookingForPrimes(numbers)
        result.foreach(result => result match {
            case Left(errorMessage) => println(errorMessage)
            case Right(prime) => println(prime)
        })
        /*
        3
        6 is not a prime number
        45 is not a prime number
        43
        52 is not a prime number
        61
        73
        89
        96 is not a prime number
        105 is not a prime number
        */
        //Task 2
        case class Student(name: String, age: Int, grade: Option[Int])
    
        val students = List(
            Student("student A", 20, Some(80)),
            Student("student B", 21, None),
            Student("student C", 19, Some(90))
        )
    
        val filteredGrades = students.flatMap(_.grade.filter(_ => true))
    
        def average(grades: List[Int]): Option[Double] = {
            if (grades.isEmpty) None
            else Some(grades.sum.toDouble / grades.length)
        }
    
        val avgGrade = average(filteredGrades)
        println(avgGrade) // Some(85.0)
        //Task 3
        // Define the function that returns an Either value
        def divideAandB(a: Int, b: Int): Either[String, Double] = {
            if (b == 0) Left("Cannot divide by zero")
            else Right(a.toDouble / b.toDouble)
        }
    
        val pairs = List((2, 2), (3, 0), (16, 4), (3, 1), (12, 6))
    
        val results = pairs.map(pair => divideAandB(pair._1, pair._2))
    
        val (rightValues, leftValues) = results.partition(_.isRight)
    
        val sumRight = rightValues.foldLeft(0.0)((s, either) => s + either.getOrElse(0.0))
    
        println("Results: " + results) //Results: List(Right(1.0), Left(Cannot divide by zero), Right(4.0), Right(3.0), Right(2.0))
        println("Right values: " + rightValues) //Right values: List(Right(1.0), Right(4.0), Right(3.0), Right(2.0))
        println("Left values: " + leftValues) // Left values: List(Left(Cannot divide by zero))
        println("Sum of right values: " + sumRight) // Sum of right values: 10.0
    
        //Task 4
        def concatOption(strings: List[String]): Option[String] = {
            if (strings.exists(_.toLowerCase.contains("error"))) None
            else Some(strings.mkString(""))
        }
    
        val testCase1 = List("Alex", "do", "a", "test", "with", "no")
        val testCase2 = List("I", "am", "done", "error", "here")
        val result1 = concatOption(testCase1)
        val result2 = concatOption(testCase2)
    
        result1 match {
            case Some(concatenatedString) => println(concatenatedString)
            case None => println("Error: the list contains a string with the word 'error'")
        } // Alexdoatestwithno
        result2 match {
            case Some(concatenatedString) => println(concatenatedString)
            case None => println("Error: the list contains a string with the word 'error'")
        } //Error: the list contains a string with the word 'error'
    
    
  }
}