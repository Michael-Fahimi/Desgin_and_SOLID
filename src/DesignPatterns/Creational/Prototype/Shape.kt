package DesignPatterns.Creational.Prototype

interface Shape {

    fun clone(): Shape
    fun draw()
}