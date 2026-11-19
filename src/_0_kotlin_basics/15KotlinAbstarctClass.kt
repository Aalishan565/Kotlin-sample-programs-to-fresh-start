package _0_kotlin_basics

/**
 * 15KotlinAbstarctClass.kt
 * Demonstrates Abstract Classes and Abstract Methods in Kotlin.
 *
 * Key Concepts:
 * 1. `abstract` Class: Cannot be instantiated directly; designed to be subclassed.
 * 2. `abstract` Function: Has no implementation in the base class; MUST be overridden by non-abstract subclasses.
 * 3. Non-abstract / Open functions in abstract classes can supply default behavior.
 */

abstract class Language {
    // Abstract method (no body)
    abstract fun know()

    // Non-abstract open method (has body)
    open fun communication() {
        println("Default communication language: English")
    }
}

class KotlinLanguage : Language() {
    override fun know() {
        println("I know Kotlin programming!")
    }
}

class JavaLanguage : Language() {
    override fun know() {
        println("I know Java programming!")
    }
}

fun main() {
    println("--- Kotlin Abstract Classes ---")

    val langA: Language = KotlinLanguage()
    langA.know()
    langA.communication()

    println()
    val langB: Language = JavaLanguage()
    langB.know()
    langB.communication()
}
