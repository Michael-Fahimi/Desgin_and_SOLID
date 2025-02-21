package DesignPatterns.Creational.Prototype

class Rectangle(var width: Int, var height: Int) : Shape {
    override fun clone(): Shape {
        return Rectangle(width, height) // Creates a new Rectangle with the same dimensions
    }

    override fun draw() {
        println(" drwaing of a reactangle")
    }

    override fun toString(): String {
        return "Rectangle(width=$width, height=$height)"
    }
}