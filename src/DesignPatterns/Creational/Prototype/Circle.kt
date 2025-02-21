package DesignPatterns.Creational.Prototype

class Circle(var radius : Int): Shape {
    override fun clone(): Shape {
        return Circle(radius)
    }

    override fun draw() {
     println(" this is a circle drawing ( use imagination)")

    }



}