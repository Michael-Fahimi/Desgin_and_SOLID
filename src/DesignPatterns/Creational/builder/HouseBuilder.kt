package DesignPatterns.Creational.builder


// Builder interface
interface HouseBuilder {
    fun buildWalls()
    fun buildRoof()
    fun buildWindows()
    fun getHouse(): House
}
