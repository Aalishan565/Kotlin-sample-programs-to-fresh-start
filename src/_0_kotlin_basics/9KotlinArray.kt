package _0_kotlin_basics

/**
 * 9KotlinArray.kt
 * Demonstrates Array creation, typed arrays, heterogeneous arrays, and iteration techniques in Kotlin.
 *
 * Key Concepts:
 * 1. Type Inference with `arrayOf()`: Infers element types based on parameters.
 * 2. Explicit Generic Arrays `arrayOf<T>()`: Specifies array element type explicitly.
 * 3. Heterogeneous Arrays `arrayOf<Any>()`: Holds elements of different data types (requires `<Any>` explicitly in Kotlin 2.0+ due to reified type parameters).
 * 4. `arrayOfNulls<T>(size)`: Creates a fixed-size array filled with `null` values.
 * 5. Iteration: Loop directly over elements or use `.withIndex()` to access both index and value.
 */
fun main() {
    println("--- 1. Inferred Int Array ---")
    val myArray1 = arrayOf(1, 10, 4, 6, 15)
    for (item in myArray1) {
        print("$item ")
    }
    println()

    println("\n--- 2. Explicitly Typed Int Array ---")
    val myArray2 = arrayOf<Int>(1, 10, 4, 6, 15)
    println("First element of myArray2: ${myArray2[0]}")

    println("\n--- 3. Explicitly Typed String Array ---")
    val myArray3 = arrayOf<String>("A", "B", "C", "D", "E")
    println("String array joined: ${myArray3.joinToString(", ")}")

    println("\n--- 4. Array of Heterogeneous Objects (arrayOf<Any>) ---")
    val myArray4 = arrayOf<Any>(1, 10, 4, "A", "B")
    for (a in myArray4) {
        println("Element: $a (Type: ${a::class.simpleName})")
    }

    println("\n--- 5. Empty Array Declaration with Size (arrayOfNulls) ---")
    val myArray5 = arrayOfNulls<Int>(5)
    myArray5[0] = 100
    myArray5[1] = 200
    for ((index, value) in myArray5.withIndex()) {
        println("Index $index -> Value: $value")
    }

    println("\n--- 6. Iterating with Index and Value ---")
    for ((index, value) in myArray4.withIndex()) {
        println("Index: $index, Value: $value")
    }
}
