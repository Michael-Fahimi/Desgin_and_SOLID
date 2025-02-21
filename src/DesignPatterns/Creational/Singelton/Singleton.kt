package DesignPatterns.Creational.Singelton


// intialze the object
// in kotlin the object declaration create singleton automatically + thread safe
object Singleton {

    init {
        println("initalzation")
    }

    fun function1(){
        println("this is my fucntion in singleton practice ")
    }}


    fun main(){

        val instance1 = Singleton
        val instance2 = Singleton

        println("Are they the same instance? ${instance1 === instance2}")
        instance1.function1()
    }


