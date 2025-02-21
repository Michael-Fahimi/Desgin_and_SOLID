package DesignPatterns.Structural.Composite


// Component interface
interface Graphic {
    fun draw()
}

// Leaf
class Dot(private val x: Int, private val y: Int) : Graphic {
    override fun draw() {
        println("Drawing dot at ($x, $y)")
    }

    override fun toString(): String = "Dot($x, $y)"
}

// Composite
class CompoundGraphic : Graphic {
    private val children: MutableList<Graphic> = mutableListOf()

    fun add(graphic: Graphic) {
        children.add(graphic)
    }

    fun remove(graphic: Graphic) {
        children.remove(graphic)
    }

    override fun draw() {
        println("Drawing compound graphic with children:")
        children.forEach { it.draw() }
    }

    override fun toString(): String = "CompoundGraphic(children=$children)"
}

// Client code
fun main() {
    // Individual leaf objects
    val dot1 = Dot(1, 2)
    val dot2 = Dot(3, 4)

    // Composite object
    val group = CompoundGraphic()
    group.add(dot1)
    group.add(dot2)

    // Nested composite
    val biggerGroup = CompoundGraphic()
    biggerGroup.add(group)
    biggerGroup.add(Dot(5, 6))

    // Draw individual leaf
    println("Drawing a single dot:")
    dot1.draw()

    // Draw composite
    println("\nDrawing a group:")
    group.draw()

    // Draw nested composite
    println("\nDrawing a bigger group:")
    biggerGroup.draw()
}