package DesignPatterns.Behavioral.State

// State Interface
interface State {
    fun handle(context: Context)
}

// Concrete States
class StateA : State {
    override fun handle(context: Context) {
        println("State A: Handling request.")
        context.state = StateB() // Transition to State B
        println("State A: Transitioned to State B.")
    }
}

class StateB : State {
    override fun handle(context: Context) {
        println("State B: Handling request.")
        context.state = StateA() // Transition to State A
        println("State B: Transitioned to State A.")
    }
}

// Context
class Context(var state: State) {
    fun request() {
        state.handle(this)
    }
}

// Example Usage
fun main() {
    val context = Context(StateA()) // Initial state is State A

    context.request() // State A handles, transitions to B
    context.request() // State B handles, transitions to A
    context.request() // State A handles, transitions to B
}