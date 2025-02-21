package DesignPatterns.Creational.AbstractFactory


// MacFactory.kt

class MacFactory : GUIFactory {
    override fun createButton(): Button = MacButton()
    override fun createWindow(): Window = MacWindow()
}