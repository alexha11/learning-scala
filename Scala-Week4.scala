//My Name: Ha Duong
//My Student ID: 000938415
import scala.collection.immutable.ListMap
import scala.io.Source


object Main {
  def main(args: Array[String]): Unit = {
      //Task 0:
      val nums = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
      val squares = nums.map(x => x * x)
      val evenSquares = squares.filter(x => x % 2 == 0)
      val evenSet = nums.filter(x => x % 2 == 0)
      val sumEvenSet = evenSet.foldLeft(0)(_ + _)
      val squaresMap = nums.map(num => (num, num * num)).toMap
      val squareOfEleven = squaresMap.getOrElse(11, 0)
      println(nums)
      println(squares)
      println(evenSquares)
      println(evenSet)
      println(sumEvenSet)
      println(squaresMap)
      println(squareOfEleven)
      //Task 1:
      def removeDuplicates(seq: Seq[String]): Seq[String] = {
          seq.foldLeft(Seq.empty[String]) { (newSeq, elem) =>
              if (newSeq.contains(elem)) newSeq
              else newSeq :+ elem
          }
      }
      val seq = Seq("a", "b", "m", "l", "b", "c", "a", "b", "c", "k", "h")
      val newSeq = removeDuplicates(seq)
      println(newSeq)
      //Task 2:
      def findCommonElements[A](set1: Set[A], set2: Set[A]): Set[A] = {
          set1.intersect(set2)
      }
      val set1 = Set(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
      val set2 = Set(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
      val commonElements = findCommonElements(set1, set2)
      println(commonElements)
      //Task 3:
      def removeKeys[K, V](map: Map[K, V], keysToRemove: List[K]): Map[K, V] = {
          keysToRemove.foldLeft(map) { (newMap, key) =>
              newMap - key
          }
      }
      val map = Map(1 -> "a", 2 -> "b", 3 -> "c", 4 -> "d", 5 -> "e")
      val keysToRemove = List(1, 2, 3)
      val newMap = removeKeys(map, keysToRemove)
      println(newMap)
      //Task 4:
      def countWords(inputFile: String): Map[String, Int] = {
          val source = Source.fromFile(inputFile)
          val words = source.getLines().flatMap(_.split("[\\W&&[^.]]+")).toList
          //println("testing" + words)
          val wordCounts = words.foldLeft(ListMap.empty[String, Int]) { (counts, word) =>
              counts + (word -> (counts.getOrElse(word, 0) + 1))
          }
          source.close()
          wordCounts
      }
    
      def printWordCounts(wordCounts: Map[String, Int]): Unit = {
          wordCounts.toSeq.foreach { case (word, count) =>
              println(s"$word $count")
          }
      }
      val filename = "src/main/resources/words.txt"
      val result = countWords(filename)
      //println(result)
      printWordCounts(result)
  }
}