package DesignPatterns.Behavioral.Visitor

// elements : obj -> operation to be done on
// visitor  : obj -> define ops to do on elements
//double dispatch
// method overloading and polymorphism



// Element Interface
interface Element {
    fun accept(visitor: Visitor)
}

// Concrete Elements
class ConcreteElementA(val valueA: String): Element {
    override fun accept(visitor: Visitor) {
        visitor.visitConcreteElementA(this)
    }
}

class ConcreteElementB(val valueB: Int): Element {
    override fun accept(visitor: Visitor) {
        visitor.visitConcreteElementB(this)
    }
}

// Visitor Interface
interface Visitor {
    fun visitConcreteElementA(element: ConcreteElementA)
    fun visitConcreteElementB(element: ConcreteElementB)
}

// Concrete Visitors
class ConcreteVisitor1: Visitor {
    override fun visitConcreteElementA(element: ConcreteElementA) {
        println("ConcreteVisitor1: Visiting ConcreteElementA with value: ${element.valueA}")
    }

    override fun visitConcreteElementB(element: ConcreteElementB) {
        println("ConcreteVisitor1: Visiting ConcreteElementB with value: ${element.valueB}")
    }
}

class ConcreteVisitor2: Visitor {
    override fun visitConcreteElementA(element: ConcreteElementA) {
        println("ConcreteVisitor2: Visiting ConcreteElementA with value: ${element.valueA.uppercase()}")
    }

    override fun visitConcreteElementB(element: ConcreteElementB) {
        println("ConcreteVisitor2: Visiting ConcreteElementB with value: ${element.valueB * 2}")
    }
}

// Example Usage
fun main() {
    val elements = listOf(
        ConcreteElementA("Hello"),
        ConcreteElementB(10)
    )

    val visitor1 = ConcreteVisitor1()
    val visitor2 = ConcreteVisitor2()

    for (element in elements) {
        element.accept(visitor1)
    }

    println("\n--- Next Visitor ---\n")

    for (element in elements) {
        element.accept(visitor2)
    }
}