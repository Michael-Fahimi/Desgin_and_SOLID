package DesignPatterns.Creational.Proxy

// Image.kt

// Subject interface
interface Image {
    fun display()
}

// Real Subject
class RealImage(private val fileName: String) : Image {
    init {
        loadFromDisk() // Simulate expensive operation
    }

    private fun loadFromDisk() {
        println("Loading $fileName from disk...")
    }

    override fun display() {
        println("Displaying $fileName")
    }
}

// Proxy
class ProxyImage(private val fileName: String) : Image {
    private var realImage: RealImage? = null

    override fun display() {
        if (realImage == null) {
            realImage = RealImage(fileName) // Lazy loading
        }
        realImage!!.display()
    }
}

// Client code
fun main() {
    val image: Image = ProxyImage("photo.jpg")

    // Image isn’t loaded yet
    println("Image created, but not loaded yet.")

    // Load and display on first call
    image.display()

    // Display again (uses cached instance)
    image.display()
}