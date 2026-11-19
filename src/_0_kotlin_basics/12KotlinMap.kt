package _0_kotlin_basics

/**
 * 12KotlinMap.kt
 * Demonstrates immutable `Map`, `hashMapOf`, and `HashMap` key-value collections in Kotlin.
 *
 * Key Concepts:
 * 1. Immutable Map (`mapOf`): Read-only map containing key-to-value pairs (`key to value`).
 * 2. Mutable Map (`hashMapOf` / `HashMap`): Allows inserting, updating, and deleting key-value entries.
 * 3. Indexing operator `map[key] = value`: Convenient Kotlin syntax for setting/getting values in a map.
 * 4. Iteration with destructuring: `forEach { (key, value) -> ... }`.
 */
fun main() {
    println("--- 1. Immutable Map (mapOf) ---")
    val myMap = mapOf(1 to "A", 4 to "B", 3 to "C")
    println("myMap contents: $myMap")
    for (key in myMap.keys) {
        println("Element at key $key = ${myMap[key]}")
    }

    println("\n--- 2. Mutable HashMap (hashMapOf) ---")
    val hashMap = hashMapOf(1 to "A", 4 to "B", 3 to "C")
    hashMap[5] = "D" // Adding dynamic key-value entry using indexing operator
    println("Iterating hashMap entries with destructuring:")
    hashMap.forEach { (key, value) ->
        println("Element at key $key is -> $value")
    }

    println("\n--- 3. Direct Java HashMap Instance ---")
    val hashMap2 = HashMap<Int, String>()
    hashMap2[1] = "Hello"
    hashMap2[2] = "World"
    println("hashMap2 contents: $hashMap2")
}
