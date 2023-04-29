// My Name: Ha Duong
// My Student ID: 000938415

object Main {
  def main(args: Array[String]): Unit = {
    //Task 1
    def recursiveAverage[T](lst: List[T])(implicit numeric: Numeric[T]): Double = {
      def helper(lst: List[T], sum: Double, count: Int): (Double, Int) = lst match {
        case Nil => (sum, count)
        case head :: tail => helper(tail, sum + numeric.toDouble(head), count + 1)
      }
  
      val (sum, count) = helper(lst, 0.0, 0)
      if (count == 0) 0.0 else sum / count
    }
  
    val intList = List(11, 22, 33, 34, 54)
    val floatList = List(9.0f, 6.0f, 4.0f, 4.0f, 5.0f)
  
    val intAvg = recursiveAverage(intList)
    val floatAvg = recursiveAverage(floatList)
  
    println(s"Int average: $intAvg")
    println(s"Float average: $floatAvg")
    
    //Task 2
    abstract class Animal {
      def makeSound(): String
    }
  
    class Bird extends Animal {
      override def makeSound(): String = "Wap Wap"
    }
  
    class Mammal extends Animal {
      override def makeSound(): String = "Cao cao"
    }
  
    def makeAllSounds(animals: List[Animal]): List[String] = {
      animals.map(_.makeSound())
    }
  
    val birds: List[Animal] = List(new Bird(), new Bird(), new Bird())
    val mammals: List[Animal] = List(new Mammal(), new Mammal())
  
    val birdSounds: List[String] = makeAllSounds(birds)
    println(birdSounds)
  
    val mammalSounds: List[String] = makeAllSounds(mammals)
    println(mammalSounds)
  
    //Task 3
  
    trait Sortable[T] {
      def sort(list: List[T]): List[T]
    }
    implicit object IntSortable extends Sortable[Int] {
      override def sort(list: List[Int]): List[Int] = list.sorted
    }
  
    implicit object DoubleSortable extends Sortable[Double] {
      override def sort(list: List[Double]): List[Double] = list.sorted
    }
  
    implicit object StringSortable extends Sortable[String] {
      override def sort(list: List[String]): List[String] = list.sorted
    }
  
    def sortList[T: Ordering : Sortable](list: List[T]): List[T] = {
      val sortable = implicitly[Sortable[T]]
      sortable.sort(list)
    }
    
    val doubleList = List(3.14, 1.03, 2.71, 0.02, 2.01, 1.56)
    val sortedDoubleList = sortList(doubleList)
    println(sortedDoubleList) // should print List(0.0, 1.0, 1.5, 2.0, 2.71, 3.14)
  
    val stringList = List("cat", "dog", "house", "table")
    val sortedStringList = sortList(stringList)
    println(sortedStringList) // should print List("apple", "banana", "orange", "pear")
  
    //Task 4
    def isPalindrome(str: String): Boolean = {
      str match {
        case "" | null => true
        case s if s.length == 1 => true
        case s if s.head == s.last => isPalindrome(s.tail.init)
        case _ => false
      }
    }
    
    println(isPalindrome("rotator"))
    println(isPalindrome("scala"))
    println(isPalindrome("Alex"))
  
  }
}