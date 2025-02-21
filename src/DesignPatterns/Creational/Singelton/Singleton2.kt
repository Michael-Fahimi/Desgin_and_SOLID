package DesignPatterns.Creational.Singelton

//private cons
// intiaziation + static for kotlin companion object
// in order to make it thread safe we do lazy intiaztion
class Singleton2 private constructor() {


    companion object {

        init {
            println("intiialzaiotn and createtion of instance.")
        }


    fun dedsec() {
        println("all weight is lightweight")
    }
}}





fun main() {
    val obj1 = Singleton2
    val obj2 = Singleton2

    println("Are they the same instance? ${obj1 === obj2}") // true
    obj1.dedsec()
}