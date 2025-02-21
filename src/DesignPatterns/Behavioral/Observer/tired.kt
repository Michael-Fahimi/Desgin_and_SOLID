package DesignPatterns.Behavioral.Observer

// Subject (Observable)
interface Subject {
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}

// Concrete Subject
class WeatherStation : Subject {
    private val observers = mutableListOf<Observer>()
    private var temperature: Int = 0

    fun setTemperature(temperature: Int) {
        this.temperature = temperature
        notifyObservers()
    }

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.forEach { it.update(temperature) }
    }
}

// Observer Interface
interface Observer {
    fun update(temperature: Int)
}

// Concrete Observer 1
class TemperatureDisplay : Observer {
    private var currentTemperature: Int = 0

    override fun update(temperature: Int) {
        currentTemperature = temperature
        println("Temperature Display: Current temperature is $currentTemperature degrees.")
    }
}

// Concrete Observer 2
class TemperatureLogger : Observer {
    override fun update(temperature: Int) {
        println("Temperature Logger: Temperature logged: $temperature degrees.")
        // In a real application, you might log to a file or database.
    }
}

// Example Usage
fun main() {
    val weatherStation = WeatherStation()

    val display = TemperatureDisplay()
    val logger = TemperatureLogger()

    weatherStation.registerObserver(display)
    weatherStation.registerObserver(logger)

    weatherStation.setTemperature(25)
    weatherStation.setTemperature(28)

    weatherStation.removeObserver(display)

    weatherStation.setTemperature(30) // only the logger will receive the update.
}