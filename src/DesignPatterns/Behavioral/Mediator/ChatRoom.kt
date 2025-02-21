package DesignPatterns.Behavioral.Mediator


// Mediator interface
interface ChatMediator {
    fun sendMessage(message: String, user: User)
}

// Concrete Mediator
class ConcreteChatMediator : ChatMediator {
    private val users = mutableListOf<User>()

    fun addUser(user: User) {
        users.add(user)
    }

    override fun sendMessage(message: String, sender: User) {
        users.forEach { user ->
            if (user != sender) { // Don’t send to the sender
                user.receiveMessage(message)
            }
        }
    }
}

// Colleague
class User(private val name: String, private val mediator: ChatMediator) {
    fun send(message: String) {
        println("$name sends: $message")
        mediator.sendMessage(message, this)
    }

    fun receiveMessage(message: String) {
        println("$name received: $message")
    }
}

// Client code
fun main() {
    val mediator = ConcreteChatMediator()

    val alice = User("Alice", mediator)
    val bob = User("Bob", mediator)
    val charlie = User("Charlie", mediator)

    mediator.addUser(alice)
    mediator.addUser(bob)
    mediator.addUser(charlie)

    alice.send("Hi everyone!")
    bob.send("Hello there!")
}