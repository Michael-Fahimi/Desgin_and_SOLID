package DesignPatterns.Creational.AbstractFactory


class WinButton : Button {
    override fun click() {
        println("Clicked a Windows button")
    }

    override fun toString(): String = "WinButton"
}

class WinWindow : Window {
    override fun open() {
        println("Opened a Windows window")
    }

    override fun toString(): String = "WinWindow"
}