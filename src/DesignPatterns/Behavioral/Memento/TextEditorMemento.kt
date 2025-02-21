package DesignPatterns.Behavioral.Memento

// save and restore the previous state of obj + dont need to know the imp
// Memento: Represents a snapshot of the text editor's state
class TextEditorMemento(val content: String)

// Originator: The text editor that creates and restores mementos
class TextEditor {
    private var content: String = ""

    fun type(text: String) {
        println("Typing: $text")
        content += text
    }

    fun save(): TextEditorMemento {
        println("Saving current state...")
        return TextEditorMemento(content)
    }

    fun restore(memento: TextEditorMemento) {
        content = memento.content
        println("Restored to: $content")
    }

    fun showContent() {
        println("Current Content: $content")
    }
}

// Caretaker: Manages the history of mementos (undo stack)
class History {
    private val mementos = mutableListOf<TextEditorMemento>()

    fun push(memento: TextEditorMemento) {
        mementos.add(memento)
    }

    fun pop(): TextEditorMemento? {
        return if (mementos.isNotEmpty()) mementos.removeAt(mementos.size - 1) else null
    }
}

// Example usage
fun main() {
    // Create a text editor and a history manager
    val editor = TextEditor()
    val history = History()

    // User types some text
    editor.type("Hello, ")
    editor.showContent()

    // Save the state
    history.push(editor.save())

    // User types more text
    editor.type("world!")
    editor.showContent()

    // Save the state again
    history.push(editor.save())

    // User types even more text
    editor.type(" How are you?")
    editor.showContent()

    // User decides to undo the last change
    println("\nUndoing last change...")
    val lastState = history.pop()
    if (lastState != null) {
        editor.restore(lastState)
    }
    editor.showContent()

    // User undoes again
    println("\nUndoing again...")
    val previousState = history.pop()
    if (previousState != null) {
        editor.restore(previousState)
    }
    editor.showContent()
}