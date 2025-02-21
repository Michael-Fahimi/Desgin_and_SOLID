package DesignPatterns.Creational.builder


// Concrete Builder
class WoodHouseBuilder : HouseBuilder {
    private val house = House()

    override fun buildWalls() {
        house.walls = "wooden walls"
    }

    override fun buildRoof() {
        house.roof = "wooden roof"
    }

    override fun buildWindows() {
        house.windows = "glass windows"
    }

    override fun getHouse(): House {
        return house
    }
}