package lectures.basics

object Functions extends App {

  def sumIntegers(x: Int, y: Int): Int =
    x + y

  def concatStrings(x: String, y: String): String =
    x + " " + y

  def repeatString(str: String, n: Int): String =
    if (n == 1) str
    else concatStrings(str, repeatString(str, n - 1))

  // Side effect function returns Unit () - Similar to None in Python
  def sideEffectFunction(str: String): Unit = println(str)

  // OMG, Scala accepts method overloading :)
  def sideEffectFunction(str: Int): Unit = println(str)

  def greeting(name: String, age: Int): String =
    s"Hi, my name is $name and I am $age years old."

  def factorialCalc(number: Int): BigInt =
    if (number <= 1) 1
    else number * factorialCalc(number - 1)

  def fibonacciCalc(number: Int): BigInt =
    if (number <= 2) 1
    else fibonacciCalc(number - 1) + fibonacciCalc(number - 2)

  def isPrime(number: Int): Boolean = {
    def isPrimeUntil(divisor: Int): Boolean =
      if (divisor <= 1) true
      else number % divisor != 0 && isPrimeUntil(divisor - 1)

    isPrimeUntil(number / 2)
  }

  sideEffectFunction(sumIntegers(2, 5))
  sideEffectFunction(concatStrings("First", "Last"))
  sideEffectFunction(repeatString("Test", 5))
  sideEffectFunction(greeting("Test", 52))
  println(factorialCalc(53))
  println(fibonacciCalc(8))
  println(isPrime(5))

}
