package _0_kotlin_basics

/**
 * 20KotlinAnonymus.kt
 * Demonstrates Anonymous Inner Classes (Object Expressions) in Kotlin.
 *
 * Key Concepts:
 * 1. Object Expression `object : InterfaceName`: Creates an anonymous implementation of an interface or class on the fly.
 * 2. Useful for one-time callback handlers without declaring explicit class types.
 */

interface Listener {
    fun onAction()
}

fun main() {
    println("--- Anonymous Inner Class (Object Expression) ---")

    // Creating an anonymous object implementing Listener interface
    val listener: Listener = object : Listener {
        override fun onAction() {
            println("Action triggered inside anonymous object implementation!")
        }
    }

    // Executing the method on anonymous instance
    listener.onAction()
}
