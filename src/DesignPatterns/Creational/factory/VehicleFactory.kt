package DesignPatterns.Creational.factory



// Creator abstract class
abstract class VehicleFactory {
    // Factory method
    abstract fun createVehicle(): Vehicle

    // Optional method using the created object
    fun testDrive() {
        val vehicle = createVehicle()
        println("Testing $vehicle")
        vehicle.drive()
    }
}
