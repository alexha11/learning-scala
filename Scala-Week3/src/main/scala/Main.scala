// My Name: Ha Duong
// My Student Number : 000938415

object Main {
    def main(args: Array[String]): Unit = {
        //Task 1:
        def oddToEven(x: Int): Int = {
            if(x % 2 == 0) x
            else x + 1
        }
        def operateOnList(li: List[Int], f: Int => Int): List[Int] = {
            li.map(f);
        }
        
        val myList = List(1, 2, 3, 4, 5)
        val result = operateOnList(myList, oddToEven)
        println(result)          // List(2, 2, 4, 4, 6)
        
        //Task 2:
        def greaterLength(s: String): Boolean = {
            if(s.length > 6) true
            else false
        }
        def concat(s: String): String = {
            s + s.length
        }
        def filterAndMap(listString: List[String], greaterLength: String => Boolean, concat:String => String): List[String] = {
            listString.filter(greaterLength).map(concat)
        }
        val listString = List("Hellodd", "Worlden", "I", "am", "Ha")
        val result2 = filterAndMap(listString, greaterLength, concat)
        println(result2)        // List(Hellodd7, Worlden7)
        
        //Task 3:
        def stringToLength(s: String): String = {
            s.length.toString
        }
        def doubleList(x: Int) = {
            x * 2
        }
        def listTransfromation[A, B](list: List[A], f: A => B): List[B] = {
            list.map(f)
        }
    
        val listString2 = List("Hellodd", "Worlden", "I", "am", "Ha")
        val result3 = listTransfromation(listString2, stringToLength)
        println(result3) // List(7, 7, 1, 2, 2)
        
        val listInt = List(1, 2, 3, 4, 5)
        val result4 = listTransfromation(listInt, doubleList)
        println(result4)        // List(2, 4, 6, 8, 10)
        
        //Task 4:
        def multiply(x: Int)(y: Int)(z: Int): Int = {
            x * y * z
        }
        def multiplyByThree = multiply(_: Int)(3)(_: Int)
        def main2(args: Array[String]): Unit = {
            println(multiply(2)(3)(4)) // 24
            println(multiplyByThree(2, 4)) // 24
        }
        main2(args)
        println(multiplyByThree(23, 3)) // 207
        println(multiplyByThree(2, 6)) // 36
        println(multiplyByThree(2, 7)) // 42
        println(multiply(2)(3)(4)) // 24
        println(multiply(2)(3)(5)) // 30
        println(multiply(2)(4)(5)) // 40
    }
}