package DesignPatterns.Creational.factory



// MotorcycleFactory.kt

class MotorcycleFactory : VehicleFactory() {
    override fun createVehicle(): Vehicle {
        return Motorcycle()
    }
}