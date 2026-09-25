package com.example.myapplication

data class Persona(val name: String, val age: Int, val entreteniments: List<String>)

fun botDeSeguretat(persona: Persona) {
    val nomCorrecte = "El teu nom"

    if (persona.name != nomCorrecte) {
        println("Error: aquest no és el teu compte. Accés denegat.")
        return
    } else {
        println("Nom verificat correctament. Accés concedit.")
    }

    when (persona.age) {
        in 0..13 -> println("Ets massa petit/a. Accés denegat.")
        in 14..17 -> println("Necessites permís parental per continuar.")
        else -> println("Ets major d'edat. Accés concedit.")
    }

    println("Els teus entreteniments (de la A a la L):")
    persona.entreteniments
        .sorted()
        .filter { it[0].uppercaseChar() in 'A'..'L' }
        .forEach { println(it) }
}

fun main() {
    val jo = Persona(
        name = "El teu nom",
        age = 20,
        entreteniments = listOf("Lectura", "Futbol", "Cinema", "Bàsquet", "Videojocs")
    )
    botDeSeguretat(jo)
}