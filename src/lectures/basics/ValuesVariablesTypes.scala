package lectures.basics

object ValuesVariablesTypes extends App {

  println(changeMutableObjects())

  def immutableValue(): Unit = {
    val number: Int = 12
    println(number)
  }

  def changeImmutableValue(): Unit = {
    val number: Int = 12
    // number = 15 reassignment to val error
    println(number)
  }

  def immutableValueMemoryReference(): Unit = {
    // There is no way to access addresses in Scala.
    // It's governed by the Memory Management of the
    // JVM controlling or knowing the addresses makes absolutely no sense in Scala.
    // https://rosettacode.org/wiki/Category:Scala
    val x: Int = 12
    val y: Int = x
    println(x.equals(y))

    val w: Int = 13
    val z: Int = 13
    println(w.equals(z))
  }

  def changeMutableObjects(): Int = {
    var number = 12
    println(number)
    number *= 2
    //println(number)
    number
  }

  def changeParam(number: Int): Int = {
    println(number)
    // number *= 2 reassignment to val error - This is beautiful :)
    number
  }

}
