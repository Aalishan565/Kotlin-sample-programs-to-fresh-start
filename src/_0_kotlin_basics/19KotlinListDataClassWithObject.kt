package _0_kotlin_basics

/**
 * 19KotlinListDataClassWithObject.kt
 * Demonstrates combining `data class` collections with Kotlin `object` (Singleton Pattern).
 *
 * Key Concepts:
 * 1. `object` declaration: Defines a thread-safe Singleton instance in Kotlin.
 * 2. Storing objects: Managing collections of data classes inside a Singleton object.
 */

data class Developer(val language: String, val experienceYears: String)

object SoftwareDeveloper {
    val developerList = arrayListOf<Developer>()

    fun showData() {
        println("Developer Roster:")
        for (dev in developerList) {
            println(" -> Language: ${dev.language}, Experience: ${dev.experienceYears} year(s)")
        }
    }
}

fun main() {
    println("--- Data Class & Singleton Object ---")

    SoftwareDeveloper.developerList.add(Developer("Java", "5"))
    SoftwareDeveloper.developerList.add(Developer("Android", "3"))
    SoftwareDeveloper.developerList.add(Developer("Kotlin", "4"))

    SoftwareDeveloper.showData()
}
