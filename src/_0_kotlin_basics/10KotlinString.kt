package _0_kotlin_basics

/**
 * 10KotlinString.kt
 * Demonstrates String equality comparisons and string building in Kotlin.
 *
 * Key Concepts:
 * 1. Structural Equality (`==`): Checks if the content/values of two strings are equal (equivalent to Java `.equals()`).
 * 2. Referential Equality (`===`): Checks if two references point to the exact same object memory location.
 * 3. `buildString`: Kotlin standard library function providing a `StringBuilder` builder scope.
 */
fun main() {
    println("--- 1. String Equality (Literal Constants) ---")
    val str1 = "Hello, World!"
    val str2 = "Hello, World!"

    // Comparing values (structural equality)
    println("str1 == str2 (Structural): ${str1 == str2}") // true

    // Comparing references (referential equality - string pool reuse)
    println("str1 === str2 (Referential): ${str1 === str2}") // true

    println("\n--- 2. String Equality with Dynamically Built Strings ---")
    val strBuffer1 = buildString { append("string value") }
    val strBuffer2 = buildString { append("string value") }

    // Comparing values
    println("strBuffer1 == strBuffer2 (Structural): ${strBuffer1 == strBuffer2}") // true

    // Comparing references (different instances on heap)
    println("strBuffer1 === strBuffer2 (Referential): ${strBuffer1 === strBuffer2}") // false
}
