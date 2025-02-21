package DesignPatterns.Behavioral.ChainOfResponsibility

// chain of processes that can go farther or jsut drop

// Handler interface
//common of all
abstract class Logger(private val level: Int) {
    companion object {
        const val INFO = 1
        const val WARNING = 2
        const val ERROR = 3
    }

    private var nextLogger: Logger? = null


    // fo chain

    fun setNext(logger: Logger): Logger {
        nextLogger = logger
        return logger
    }


    // req handeling logic
    fun logMessage(level: Int, message: String) {
        if (this.level <= level) {
            write(message)
        }
        nextLogger?.logMessage(level, message)
    }

    abstract fun write(message: String)
}

// Concrete Handlers
class ConsoleLogger(level: Int) : Logger(level) {
    override fun write(message: String) {
        println("Console Logger: $message")
    }
}

class FileLogger(level: Int) : Logger(level) {
    override fun write(message: String) {
        println("File Logger: $message (saved to file)")
    }
}

class EmailLogger(level: Int) : Logger(level) {
    override fun write(message: String) {
        println("Email Logger: $message (sent via email)")
    }
}

// Client code
fun main() {
    // Set up the chain: Console -> File -> Email
    val consoleLogger = ConsoleLogger(Logger.INFO)
    val fileLogger = FileLogger(Logger.WARNING)
    val emailLogger = EmailLogger(Logger.ERROR)

    consoleLogger.setNext(fileLogger).setNext(emailLogger)

    // Test the chain with different levels
    println("Logging INFO:")
    consoleLogger.logMessage(Logger.INFO, "This is an info message")

    println("\nLogging WARNING:")
    consoleLogger.logMessage(Logger.WARNING, "This is a warning message")

    println("\nLogging ERROR:")
    consoleLogger.logMessage(Logger.ERROR, "This is an error message")
}