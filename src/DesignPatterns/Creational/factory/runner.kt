package DesignPatterns.Creational.factory

// encapsulate the object creation
// interface for object creation -> subclasses -> concrete class to instantiate
//loose coupling


// use : unknown object at runtime
//      felexabilty for future --> centralize the creation logic







// Client code
fun main() {
    val carFactory: VehicleFactory = CarFactory()
    val motorcycleFactory: VehicleFactory = MotorcycleFactory()

    val car = carFactory.createVehicle()
    val motorcycle = motorcycleFactory.createVehicle()

    println("Created: $car")
    car.drive()
    println("Created: $motorcycle")
    motorcycle.drive()

    // Using the testDrive method
    carFactory.testDrive()
    motorcycleFactory.testDrive()
}


