package DesignPatterns.Structural.Flyweight

// uses less ram -> by share common part of state between objects

// Flyweight
class TreeType(private val name: String, private val color: String) {
    fun draw(x: Int, y: Int) {
        println("Drawing $name tree with color $color at ($x, $y)")
    }
}

// Flyweight Factory
object TreeFactory {
    private val treeTypes = mutableMapOf<String, TreeType>()

    fun getTreeType(name: String, color: String): TreeType {
        val key = "$name-$color"
        return treeTypes.getOrPut(key) { TreeType(name, color) }
    }

    fun getTreeTypeCount(): Int = treeTypes.size  // for us
}

// Client code with extrinsic state
class Tree(private val x: Int, private val y: Int, private val type: TreeType) {
    fun draw() {
        type.draw(x, y)
    }
}

fun main() {
    // Create a forest with shared tree types
    val forest = mutableListOf<Tree>()

    // Add trees (reusing TreeType flyweights)
    forest.add(Tree(1, 1, TreeFactory.getTreeType("Oak", "Green")))
    forest.add(Tree(2, 3, TreeFactory.getTreeType("Oak", "Green"))) // Reuses same Oak-Green
    forest.add(Tree(5, 7, TreeFactory.getTreeType("Pine", "Dark Green")))

    // Draw all trees
    forest.forEach { it.draw() }

    // Show how many unique tree types were created
    println("\nUnique tree types created: ${TreeFactory.getTreeTypeCount()}")
}

