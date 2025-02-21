package DesignPatterns.Creational.builder


// Director (optional)
class ConstructionManager(private val builder: HouseBuilder) {
    fun construct() {
        builder.buildWalls()
        builder.buildRoof()
        builder.buildWindows()
    }
}