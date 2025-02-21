package DesignPatterns.Behavioral.TemplateMethod

//  skelet of algo -> superclass + specific steps written in subclass + not change the structure

// Abstract Class (Template)
abstract class Game {



    // Template Method (defines the algorithm's skeleton)
    fun play() {
        initializeGame()
        startGame()
        endGame()
        printWinner()
    }

    // Abstract methods (to be implemented by subclasses)
    abstract fun initializeGame()
    abstract fun startGame()
    abstract fun endGame()
    abstract fun printWinner()


//      to be studied more
//    // Hook (optional, provides a default implementation that subclasses can override)
//    open fun beforeInitialize() {
//        // Optional hook method, subclasses can override.
//        println("Performing default pre-initialization tasks.")
//    }
//
//    open fun afterEndGame(){
//        println("Performing default post-game tasks.")
//    }
}




// Concrete Class 1 (Chess)
class Chess : Game() {
    override fun initializeGame() {
        println("Chess: Initializing the chessboard.")
    }

    override fun startGame() {
        println("Chess: Starting the chess game.")
    }

    override fun endGame() {
        println("Chess: Ending the chess game.")
    }

    override fun printWinner() {
        println("Chess: Checking for checkmate and declaring the winner.")
    }
//    override fun beforeInitialize(){
//        println("chess specific pre-initialization")
//    }
//
//    override fun afterEndGame(){
//        println("chess specific post-game tasks")
//    }
}

// Concrete Class 2 (Monopoly)
class Monopoly : Game() {
    override fun initializeGame() {
        println("Monopoly: Setting up the board and distributing money.")
    }

    override fun startGame() {
        println("Monopoly: Rolling the dice and starting the game.")
    }

    override fun endGame() {
        println("Monopoly: Ending the monopoly game.")
    }

    override fun printWinner() {
        println("Monopoly: Calculating net worth and declaring the richest player the winner.")
    }
}

// Example Usage
fun main() {
    val chessGame = Chess()
    chessGame.play()

    println("\n--- Next Game ---\n")

    val monopolyGame = Monopoly()
    monopolyGame.play()
}