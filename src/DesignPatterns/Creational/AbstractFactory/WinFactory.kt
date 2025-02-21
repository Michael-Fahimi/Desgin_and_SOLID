package DesignPatterns.Creational.AbstractFactory


// WinFactory.kt

class WinFactory : GUIFactory {
    override fun createButton(): Button = WinButton()
    override fun createWindow(): Window = WinWindow()
}