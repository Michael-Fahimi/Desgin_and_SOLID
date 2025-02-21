package SOLID

// Instead of one class handling both logging and formatting
class Logger {
    fun log(message: String) {
        println(message)
    }
}

class MessageFormatter {
    fun format(message: String): String {
        return "INFO: $message"
    }
}

fun main() {
    val logger = Logger()
    val formatter = MessageFormatter()
    logger.log(formatter.format("User logged in"))
}