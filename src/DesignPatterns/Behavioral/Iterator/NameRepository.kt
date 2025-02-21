package DesignPatterns.Behavioral.Iterator


// Iterator interface
interface Iterator {
    fun hasNext(): Boolean
    fun next(): String?
}

// Concrete Iterator
class NameIterator(private val names: Array<String>) : Iterator {
    private var index = 0

    override fun hasNext(): Boolean {
        return index < names.size
    }

    override fun next(): String? {
        return if (hasNext()) names[index++] else null
    }
}

// Aggregate interface
interface Container {
    fun getIterator(): Iterator
}

// Concrete Aggregate
class NameRepository : Container {
    private val names = arrayOf("Alice", "Bob", "Charlie", "Diana")

    override fun getIterator(): Iterator {
        return NameIterator(names)
    }
}

// Client code
fun main() {
    val repository = NameRepository()
    val iterator = repository.getIterator()

    println("Iterating through names:")
    while (iterator.hasNext()) {
        val name = iterator.next()
        println("Name: $name")
    }
}