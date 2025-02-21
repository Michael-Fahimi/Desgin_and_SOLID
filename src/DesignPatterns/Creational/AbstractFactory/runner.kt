package DesignPatterns.Creational.AbstractFactory


fun main() {
    val macFactory: GUIFactory = MacFactory()
    val winFactory: GUIFactory = WinFactory()

    val macButton = macFactory.createButton()
    val macWindow = macFactory.createWindow()
    val winButton = winFactory.createButton()
    val winWindow = winFactory.createWindow()

    println("Mac UI: $macButton, $macWindow")
    macButton.click()
    macWindow.open()

    println("Windows UI: $winButton, $winWindow")
    winButton.click()
    winWindow.open()
}