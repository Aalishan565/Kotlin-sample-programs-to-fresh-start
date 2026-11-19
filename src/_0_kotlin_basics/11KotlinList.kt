package _0_kotlin_basics

/**
 * 11KotlinList.kt
 * Demonstrates immutable and mutable Lists (`List`, `MutableList`, `ArrayList`) in Kotlin.
 *
 * Key Concepts:
 * 1. Read-only `List` (`listOf`): Immutable interface; elements cannot be added or modified after creation.
 * 2. `MutableList` (`mutableListOf`): Allows adding, updating, and removing elements dynamically.
 * 3. `ArrayList` (`arrayListOf` / `java.util.ArrayList`): Java interoperable dynamically-resizing array list implementation.
 */
fun main() {
    println("--- 1. Read-Only (Immutable) Lists ---")
    val intList: List<Int> = listOf(1, 2, 3)
    val stringList: List<String> = listOf("A", "B", "C")
    val anyList: List<Any> = listOf(1, 2, 3, "A", "B", "C")

    println("intList: $intList")
    println("stringList: $stringList")
    println("anyList: $anyList")

    println("Iterating stringList:")
    for (element in stringList) {
        println("Item: $element")
    }

    println("\n--- 2. Mutable Lists (mutableListOf) ---")
    val mutableList = mutableListOf("Ajay", "Vijay", "Prakash", "Vijay")
    println("Initial mutableList: $mutableList")

    mutableList.add("Amit")
    mutableList.add("Rahul")
    mutableList.remove("Vijay") // Removes first occurrence of "Vijay"
    println("Updated mutableList after add & remove: $mutableList")

    println("\n--- 3. ArrayList (arrayListOf) ---")
    val arrayList = arrayListOf("Ajay", "Vijay", "Prakash")
    arrayList.add("Suresh")
    for (name in arrayList) {
        println("ArrayList item: $name")
    }

    val listInputData: ArrayList<String> = ArrayList()
    println("Empty ArrayList initial size: ${listInputData.size}")
    listInputData.add("Data Entry 1")
    println("ArrayList size after adding 1 item: ${listInputData.size}")
}
