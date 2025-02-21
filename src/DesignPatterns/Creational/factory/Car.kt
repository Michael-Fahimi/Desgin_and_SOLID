package DesignPatterns.Creational.factory


// Concrete Products
class Car : Vehicle {
    override fun drive() {
        println("Driving a car...")
    }

    override fun toString(): String {
        return "Car"
    }
}
