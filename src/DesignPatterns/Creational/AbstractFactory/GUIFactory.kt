package DesignPatterns.Creational.AbstractFactory


// GUIFactory.kt

interface GUIFactory {
    fun createButton(): Button
    fun createWindow(): Window
}