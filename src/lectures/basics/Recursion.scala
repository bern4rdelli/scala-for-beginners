package lectures.basics

import scala.annotation.tailrec

object Recursion extends App {

  def repeatString(str: String, n: Int): String =
    if (n == 1) str
    else str + " " + repeatString(str, n - 1)

  def repeatStringWithTailRecursion(str: String, n: Int): String = {
    @tailrec
    def recursionHelper(accumulator: String, until: Int): String =
      if (until <= 1) accumulator
      else recursionHelper(accumulator + str, until - 1)

    recursionHelper(str, n)
  }

  // println(repeatString("a", 20000))  Exception in thread "main" java.lang.StackOverflowError
  println(repeatStringWithTailRecursion("a", 13))

  def isPrime(number: BigInt): Boolean = {
    @tailrec
    def isPrimeUntil(divisor: BigInt): Boolean =
      if (divisor <= 1) true
      else number % divisor != 0 && isPrimeUntil(divisor - 1)

    isPrimeUntil(number / 2)
  }

  // println(isPrime(257434517))

  def fibonacciCalc(number: Int): BigInt =
    if (number <= 2) 1
    else fibonacciCalc(number - 1) + fibonacciCalc(number - 2)

  def fibonacciCalcTailRecursion(number: Int): Int = {
    @tailrec
    def fibonacciCalcTailrec(until: Int, last: Int, nextToLast: Int): Int = {
      println(until, last, nextToLast)
      if (until >= number) last
      else fibonacciCalcTailrec(until + 1, last + nextToLast, last)
    }

    if (number <= 2) 1
    else fibonacciCalcTailrec(2, 1, 1)
  }

  // println(fibonacciCalc(20000))  Exception in thread "main" java.lang.StackOverflowError
  println(fibonacciCalcTailRecursion(8))

  def isPrimeTailRecursion(number: Int): Boolean = {
    @tailrec
    def isPrimeHelper(divisor: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (divisor <= 1) true
      else isPrimeHelper(divisor - 1, number % 2 != 0)
    }

    isPrimeHelper(number / 2, isStillPrime = true)
  }

  println(isPrimeTailRecursion(2003))
  println(isPrimeTailRecursion(13))
  println(isPrimeTailRecursion(10000))

}
