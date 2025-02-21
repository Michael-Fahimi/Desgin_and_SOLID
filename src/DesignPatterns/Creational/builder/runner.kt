package DesignPatterns.Creational.builder


fun main() {
    val woodBuilder = WoodHouseBuilder()
    val manager = ConstructionManager(woodBuilder)

    manager.construct()
    val house = woodBuilder.getHouse()
    println("Built: $house")
}