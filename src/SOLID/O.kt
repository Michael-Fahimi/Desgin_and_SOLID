package SOLID

//OPEN closed
// open for extention + closed for modification
// here you can --> do triangle without changing the shapeor exsiting classes

abstract class Shape {
    abstract fun area(): Double
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun area() = width * height
}

class Circle(val radius: Double) : Shape() {
    override fun area() = Math.PI * radius * radius
}

// Can add new shapes without modifying existing code
fun main() {
    val shapes = listOf(Rectangle(2.0, 3.0), Circle(1.0))
    shapes.forEach { println(it.area()) }
}