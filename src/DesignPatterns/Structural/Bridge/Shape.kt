package DesignPatterns.Structural.Bridge

//object composition
// abstraction and implementation
// Implementor interface
interface DrawingAPI {
    fun drawCircle(x: Double, y: Double, radius: Double)
    fun drawRectangle(x: Double, y: Double, width: Double, height: Double)
}

// Concrete Implementors
class VectorDrawingAPI : DrawingAPI {
    override fun drawCircle(x: Double, y: Double, radius: Double) {
        println("Drawing vector circle at ($x, $y) with radius $radius")
    }

    override fun drawRectangle(x: Double, y: Double, width: Double, height: Double) {
        println("Drawing vector rectangle at ($x, $y) with width $width, height $height")
    }

    override fun toString(): String = "VectorDrawingAPI"
}

class RasterDrawingAPI : DrawingAPI {
    override fun drawCircle(x: Double, y: Double, radius: Double) {
        println("Drawing raster circle at ($x, $y) with radius $radius")
    }

    override fun drawRectangle(x: Double, y: Double, width: Double, height: Double) {
        println("Drawing raster rectangle at ($x, $y) with width $width, height $height")
    }

    override fun toString(): String = "RasterDrawingAPI"
}

// Abstraction
abstract class Shape(protected val drawingAPI: DrawingAPI) {
    abstract fun draw()
}

// Refined Abstractions
class Circle(private val x: Double, private val y: Double, private val radius: Double, drawingAPI: DrawingAPI) : Shape(drawingAPI) {
    override fun draw() {
        drawingAPI.drawCircle(x, y, radius)
    }

    override fun toString(): String = "Circle at ($x, $y), radius $radius with $drawingAPI"
}

class Rectangle(private val x: Double, private val y: Double, private val width: Double, private val height: Double, drawingAPI: DrawingAPI) : Shape(drawingAPI) {
    override fun draw() {
        drawingAPI.drawRectangle(x, y, width, height)
    }

    override fun toString(): String = "Rectangle at ($x, $y), width $width, height $height with $drawingAPI"
}

// Client code
fun main() {
    val vectorAPI = VectorDrawingAPI()
    val rasterAPI = RasterDrawingAPI()

    val shapes = listOf(
        Circle(1.0, 2.0, 3.0, vectorAPI),
        Rectangle(4.0, 5.0, 6.0, 7.0, rasterAPI)
    )

    shapes.forEach {
        println("Shape: $it")
        it.draw()
    }
}