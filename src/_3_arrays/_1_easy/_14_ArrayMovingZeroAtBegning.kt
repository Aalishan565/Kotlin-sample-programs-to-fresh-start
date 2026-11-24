package _3_arrays._1_easy

fun main() {
    val inputArray = arrayOf(1, 0, 1, 0, 0, 1, 0, 1, 0)
    moveAllZerosToBeginning(inputArray).forEach {
        println(it)
    }
}

private fun moveAllZerosToBeginning(inputArray: Array<Int>): Array<Int> {
    var j = inputArray.size - 1
    for (i in inputArray.size - 1 downTo 0) {
        if (inputArray[i] != 0 && inputArray[j] == 0) {
            val temp = inputArray[j]
            inputArray[j] = inputArray[i]
            inputArray[i] = temp
        }
        if (inputArray[j] != 0) {
            j--
        }
    }
    return inputArray
}
