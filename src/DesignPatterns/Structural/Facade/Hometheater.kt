package DesignPatterns.Structural.Facade

//simplifid interface to a complicated library or frameowkr
//cons : coupled with all the objects

// Subsystem Classes
class DVDPlayer {
    fun on() {
        println("DVD Player is on")
    }

    fun play(movie: String) {
        println("Playing movie: $movie")
    }

    fun off() {
        println("DVD Player is off")
    }
}

class Projector {
    fun on() {
        println("Projector is on")
    }

    fun setInput(input: String) {
        println("Projector set to $input")
    }

    fun off() {
        println("Projector is off")
    }
}

class SoundSystem {
    fun on() {
        println("Sound System is on")
    }

    fun setVolume(level: Int) {
        println("Sound System volume set to $level")
    }

    fun off() {
        println("Sound System is off")
    }
}

// Facade
class HomeTheaterFacade(
    private val dvdPlayer: DVDPlayer,
    private val projector: Projector,
    private val soundSystem: SoundSystem
) {
    fun watchMovie(movie: String) {
        println("Setting up home theater for movie...")
        dvdPlayer.on()
        projector.on()
        projector.setInput("DVD")
        soundSystem.on()
        soundSystem.setVolume(5)
        dvdPlayer.play(movie)
    }

    fun endMovie() {
        println("Shutting down home theater...")
        dvdPlayer.off()
        projector.off()
        soundSystem.off()
    }
}

// Client code
fun main() {
    val dvd = DVDPlayer()
    val projector = Projector()
    val sound = SoundSystem()

    val homeTheater = HomeTheaterFacade(dvd, projector, sound)

    homeTheater.watchMovie("Inception")
    println()
    homeTheater.endMovie()
}