package DesignPatterns.Behavioral.Command


// Receiver
class Light {
    fun turnOn() {
        println("Light is ON")
    }

    fun turnOff() {
        println("Light is OFF")
    }
}

// Command interface
interface Command {
    fun execute()
}

// Concrete Commands
class TurnOnCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOn()
    }
}

class TurnOffCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOff()
    }
}

// Invoker
class RemoteControl {
    private var command: Command? = null

    fun setCommand(command: Command) {
        this.command = command
    }

    fun pressButton() {
        command?.execute()
    }
}

// Client code
fun main() {
    val light = Light()
    val turnOn = TurnOnCommand(light)
    val turnOff = TurnOffCommand(light)

    val remote = RemoteControl()

    // Turn on the light
    remote.setCommand(turnOn)
    remote.pressButton()

    // Turn off the light
    remote.setCommand(turnOff)
    remote.pressButton()
}