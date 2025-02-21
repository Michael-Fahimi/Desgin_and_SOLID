package SOLID


// interface segregation
// dont force the client to depend on the interfaces they dont use

interface Printer {
    fun print(document: String)
}

interface Scanner {
    fun scan(document: String)
}

class SimplePrinter : Printer {
    override fun print(document: String) = println("Printing: $document")
}

class MultiFunctionDevice : Printer, Scanner {
    override fun print(document: String) = println("Printing: $document")
    override fun scan(document: String) = println("Scanning: $document")
}

fun main() {
    val printer = SimplePrinter()
    printer.print("Doc") // No forced scan method
}