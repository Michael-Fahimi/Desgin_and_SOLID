package DesignPatterns.Structural.Adapter

// you could have object or class adaptor
// Target interface


interface MediaPlayer {
    fun play(fileName: String)
}

// Adaptee (legacy system)
class LegacyAudioPlayer {
    fun playAudio(audioFile: String) {
        println("Playing audio file: $audioFile (legacy format)")
    }
}

// Adapter
class AudioAdapter(private val legacyPlayer: LegacyAudioPlayer) : MediaPlayer {
    override fun play(fileName: String) {
        legacyPlayer.playAudio(fileName)
    }

    override fun toString(): String = "AudioAdapter wrapping LegacyAudioPlayer"
}

// Client code
fun main() {
    val legacyPlayer = LegacyAudioPlayer()
    val adapter: MediaPlayer = AudioAdapter(legacyPlayer)

    println("Using adapter: $adapter")
    adapter.play("song.mp3")
}