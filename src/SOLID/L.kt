package SOLID


// subtype -> sub for basetype + dont break program lol
//sparrow + ostrictch -> repalce Bird + not break the program

open class Bird {
    open fun move() = "Moving"
}

class Sparrow : Bird() {
    override fun move() = "Flying"
}

class Ostrich : Bird() {
    override fun move() = "Running" // Still valid substitution
}

fun moveBird(bird: Bird) {
    println(bird.move())
}

fun main() {
    moveBird(Sparrow())  // Works
    moveBird(Ostrich())  // Works
}