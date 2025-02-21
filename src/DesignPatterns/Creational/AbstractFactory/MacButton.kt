package DesignPatterns.Creational.AbstractFactory



class MacButton : Button {
    override fun click() {
        println("Clicked a Mac button")
    }

    override fun toString(): String = "MacButton"
}

class MacWindow : Window {
    override fun open() {
        println("Opened a Mac window")
    }

    override fun toString(): String = "MacWindow"
}