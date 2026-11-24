package _2_strings._2_medium

/**
 * _04_AnagramTest.kt
 * Checks if two strings are valid Anagrams (contain identical character counts).
 */
fun main() {
    val s1 = "shanlaai"
    val s2 = "aashanli"

    println("--- Valid Anagram Test ---")
    println("String 1: \"$s1\"")
    println("String 2: \"$s2\"")

    println("1. Using Sorting      : ${areStringsAnagramSorting(s1, s2)}")
    println("2. Using Frequency Map: ${areStringsAnagramHashMap(s1, s2)}")
}

fun areStringsAnagramSorting(input1: String, input2: String): Boolean {
    if (input1.length != input2.length) return false
    val char1 = input1.toCharArray().apply { sort() }
    val char2 = input2.toCharArray().apply { sort() }
    return char1.contentEquals(char2)
}

fun areStringsAnagramHashMap(input1: String, input2: String): Boolean {
    if (input1.length != input2.length) return false

    val frequencyMap = HashMap<Char, Int>()

    for (i in input1.indices) {
        frequencyMap[input1[i]] = frequencyMap.getOrDefault(input1[i], 0) + 1
        frequencyMap[input2[i]] = frequencyMap.getOrDefault(input2[i], 0) - 1
    }

    return frequencyMap.values.all { it == 0 }
}
