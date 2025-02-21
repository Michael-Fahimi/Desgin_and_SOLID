package DesignPatterns.Creational.Prototype


//copy the object rather than recreate it from scratch
// uses : when object creation is expensive + variation of object creation needed
// right now shallow copy if time do deep copy
// Client code
fun main() {


    // Create initial prototypes
    val circlePrototype = Circle(5)
    val rectanglePrototype = Rectangle(10, 20)

    // Clone the prototypes to create new objects
    val circleCopy = circlePrototype.clone()
    val rectangleCopy = rectanglePrototype.clone()

    // Modify the clones (optional)
    (circleCopy as Circle).radius = 7
    (rectangleCopy as Rectangle).width = 15

    // Demonstrate usage
    println("Original Circle: $circlePrototype")
    circlePrototype.draw()
    println("Cloned Circle: $circleCopy")
    circleCopy.draw()

    println("Original Rectangle: $rectanglePrototype")
    rectanglePrototype.draw()
    println("Cloned Rectangle: $rectangleCopy")
    rectangleCopy.draw()

    println("Are circle and circle copy the same ? ${circlePrototype === circleCopy}")
    println("Are rectangle and rectanglecopy  the same? ${rectanglePrototype === rectangleCopy}")
}