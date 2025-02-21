package DesignPatterns.Creational.factory





// Concrete Creators
class CarFactory : VehicleFactory() {
    override fun createVehicle(): Vehicle {
        return Car()
    }
}