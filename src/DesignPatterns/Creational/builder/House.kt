package DesignPatterns.Creational.builder

// Product
class House {
    var walls: String? = null
    var roof: String? = null
    var windows: String? = null

    override fun toString(): String {
        return "House(walls=$walls, roof=$roof, windows=$windows)"
    }
}
