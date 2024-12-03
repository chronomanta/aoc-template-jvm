import java.util.regex.Pattern

val pattern: Pattern = Pattern.compile("mul\\(\\d+,\\d+\\)")

fun main(argv: Array<String>) {
    println(part1())
    println(part2())
}

fun String.sumMuls(): Int {
    val matcher = pattern.matcher(this)
    var sum = 0
    while (matcher.find()) {
        val (x, y) = matcher.group(0).drop(4).dropLast(1).split(",").map { it.toInt() }
        sum += x * y
    }
    return sum
}

fun part1(): Any {
    return input.sumMuls()
}

fun part2(): Any {
    val dontOnStart = input.startsWith("don't()")
    val sections: List<String> = input.split("don't()")
    var sum = if (dontOnStart) 0 else sections[0].sumMuls()
    for (i in 1 until sections.size) {
        val section = sections[i]
        val index = section.indexOf("do()")
        sum += if (index != -1)
            section.drop(index + 4).sumMuls()
        else
            0
    }
    return sum
}

private val input: String by lazy {readInput()}

private fun readInput(): String {
    return object {}.javaClass.getResource("Day3.input")!!.readText()
}
