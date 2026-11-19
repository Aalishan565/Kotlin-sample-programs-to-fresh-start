package _0_kotlin_basics

/**
 * 25LateInitKotlinNullSafety.kt
 * Demonstrates Deferred Initialization using `lateinit var` in Kotlin.
 *
 * Key Concepts:
 * 1. `lateinit`: Used for non-null `var` properties whose initialization is deferred (e.g. in dependency injection or setup methods).
 * 2. Rules: Works only with mutable properties (`var`), inside classes or top-level, and cannot be primitive types (Int, Double, Boolean, etc.).
 * 3. `isInitialized` check: Prevents `UninitializedPropertyAccessException` by checking `::propertyName.isInitialized`.
 */

class UserProfile {
    lateinit var username: String

    fun initializeUser(name: String) {
        username = name
    }

    fun printUser() {
        if (::username.isInitialized) {
            println("Initialized Username: $username")
        } else {
            println("Username has NOT been initialized yet!")
        }
    }
}

fun main() {
    println("--- Kotlin lateinit Property ---")

    val user = UserProfile()

    println("Before initialization:")
    user.printUser()

    println("\nInitializing user...")
    user.initializeUser("JohnDoe")

    println("After initialization:")
    user.printUser()
}
