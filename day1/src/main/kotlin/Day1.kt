import kotlin.math.absoluteValue

fun main() {
    println(part1())
    println(part2())
}

fun part1(): Any {
    val array1: IntArray = input.map { it.split("   ")[0].toInt() }.toIntArray()
    val array2: IntArray = input.map { it.split("   ")[1].toInt() }.toIntArray()
    array1.sort()
    array2.sort()
    var acc = 0
    for (i in array1.indices) {
        acc += (array1[i] - array2[i]).absoluteValue
    }
    return acc
}

fun part2(): Any {
    val array1: IntArray = input.map { it.split("   ")[0].toInt() }.toIntArray()
    val map: Map<Int, Int> = input.map { it.split("   ")[1].toInt() }.groupingBy { it }.eachCount()
    var acc = 0
    for (i in array1.indices) {
        if (map.containsKey(array1[i])) {
            acc += array1[i] * map[array1[i]]!!
        }
    }
    return acc
}

private val input: List<String> by lazy {readLines()}

private fun readLines(): List<String> {
    return object {}.javaClass.getResource("Day1.input")!!.readText().split("\n")
}
