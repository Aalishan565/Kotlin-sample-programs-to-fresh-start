package _0_kotlin_basics

/**
 * Animal.kt
 * Demonstrates Primary Constructors, `init` Blocks, and Secondary Constructors in Kotlin.
 *
 * Key Concepts:
 * 1. Primary Constructor: Header signature `class Animal(inputName: String)`.
 * 2. `init` Block: Executes immediately after the primary constructor.
 * 3. Secondary Constructor: Declared with `constructor(...)`, must delegate to the primary constructor using `: this(...)`.
 */
class Animal(inputName: String) {

    var name: String? = inputName

    // Init block runs right after primary constructor instantiation
    init {
        println("Animal init block executed for: $inputName")
    }

    // Secondary constructor delegating to primary constructor `: this(name)`
    constructor(age: Int, name: String) : this(name) {
        println("Secondary constructor called with age: $age and name: $name")
    }

    fun showName() {
        println("Animal Name: $name")
    }
}
