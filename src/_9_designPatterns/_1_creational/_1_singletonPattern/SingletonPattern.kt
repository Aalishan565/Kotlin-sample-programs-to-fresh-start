package _9_designPatterns._1_creational._1_singletonPattern

/**
 * SingletonPattern.kt
 * Ensures a class has only one instance and provides a global point of access to it.
 *
 * Beginner Explanation:
 * - In Java, you must write double-checked locking with `volatile` and `synchronized` blocks.
 * - In Kotlin, `object` is built into the language! Kotlin creates a thread-safe, lazily-initialized Singleton automatically.
 */
fun main() {
    println("--- Kotlin Singleton Pattern ---")

    // 1. Idiomatic Kotlin Singleton (using `object`)
    val s1 = KotlinSingleton
    val s2 = KotlinSingleton

    s1.showMessage()
    println("s1 === s2 (Same memory instance?): ${s1 === s2}")

    // 2. Classical Thread-Safe Double-Checked Locking Singleton
    println("\n--- Classical Java-style Singleton in Kotlin ---")
    val c1 = ClassicalSingleton.getInstance()
    val c2 = ClassicalSingleton.getInstance()
    println("c1 === c2 (Same memory instance?): ${c1 === c2}")
}

// 1. Idiomatic Kotlin Singleton
object KotlinSingleton {
    init {
        println("KotlinSingleton object initialized lazily and thread-safely!")
    }

    fun showMessage() {
        println("Hello from KotlinSingleton instance!")
    }
}

// 2. Classical Double-Checked Locking Singleton
class ClassicalSingleton private constructor() {
    init {
        println("New instance created of ClassicalSingleton")
    }

    companion object {
        @Volatile
        private var instance: ClassicalSingleton? = null

        fun getInstance(): ClassicalSingleton {
            return instance ?: synchronized(this) {
                instance ?: ClassicalSingleton().also { instance = it }
            }
        }
    }
}
