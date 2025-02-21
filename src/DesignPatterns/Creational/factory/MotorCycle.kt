package DesignPatterns.Creational.factory



class Motorcycle : Vehicle {
    override fun drive() {
        println("Riding a motorcycle...")
    }

    override fun toString(): String {
        return "Motorcycle"
    }
}