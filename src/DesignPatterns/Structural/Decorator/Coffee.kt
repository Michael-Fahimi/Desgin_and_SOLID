package DesignPatterns.Structural.Decorator

// aggregation and copmposition
// you got a class you want to add behaviours
//works with refrence of the object instead of itself like inheritance
// (the same reults can be achived with inheritqnaace )

// Component interface
interface Coffee {
    fun getCost(): Double
    fun getDescription(): String
}

// Concrete Component
class SimpleCoffee : Coffee {
    override fun getCost(): Double = 2.0
    override fun getDescription(): String = "Simple Coffee"
}

// Decorator abstract class
abstract class CoffeeDecorator(private val coffee: Coffee) : Coffee {
    override fun getCost(): Double = coffee.getCost()
    override fun getDescription(): String = coffee.getDescription()
}

// Concrete Decorators
class MilkDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun getCost(): Double = super.getCost() + 0.5
    override fun getDescription(): String = super.getDescription() + ", Milk"
}

class SugarDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun getCost(): Double = super.getCost() + 0.2
    override fun getDescription(): String = super.getDescription() + ", Sugar"
}

// Client code
fun main() {
    // Base coffee
    var coffee: Coffee = SimpleCoffee()
    println("Order: ${coffee.getDescription()}")
    println("Cost: $${coffee.getCost()}")

    // Add milk
    coffee = MilkDecorator(coffee)
    println("\nOrder: ${coffee.getDescription()}")
    println("Cost: $${coffee.getCost()}")

    // Add sugar
    coffee = SugarDecorator(coffee)
    println("\nOrder: ${coffee.getDescription()}")
    println("Cost: $${coffee.getCost()}")
}