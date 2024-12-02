fun List<Int>.isSafe(): Boolean {
    val ascending = this[0] <= this[1]
    for (i in 0..this.size - 2) {
        val diff = if (ascending) {
            this[i + 1] - this[i]
        } else {
            this[i] - this[i + 1]
        }
        if (diff < 1 || diff > 3) {
            return false
        }
    }
    return true
}

fun List<Int>.isSafeWithDampener(): Boolean {
    return this.isSafe()
            || this.filterIndexed{ index, _ -> index != 0 }.isSafe()
            || this.filterIndexed{ index, _ -> index != 1 }.isSafe()
            || this.size > 2 && this.filterIndexed{ index, _ -> index != 2 }.isSafe()
            || this.size > 3 && this.filterIndexed{ index, _ -> index != 3 }.isSafe()
            || this.size > 4 && this.filterIndexed{ index, _ -> index != 4 }.isSafe()
            || this.size > 5 && this.filterIndexed{ index, _ -> index != 5 }.isSafe()
            || this.size > 6 && this.filterIndexed{ index, _ -> index != 6 }.isSafe()
            || this.size > 7 && this.filterIndexed{ index, _ -> index != 7 }.isSafe()
}

fun main(args: Array<String>) {
    val start = System.currentTimeMillis()
    println(part1())
    println(part2())
    println("Finished in: ${System.currentTimeMillis() - start}ms")
}

fun part1(): Any {
    return input.map { line -> line.split(" ").map { it.toInt() }.isSafe() }.count { it }
}

fun part2(): Any {
    return input.map { line -> line.split(" ").map { it.toInt() }.isSafeWithDampener() }.count { it }
}

private val input: List<String> by lazy {readLines()}

private fun readLines(): List<String> {
    return object {}.javaClass.getResource("Day2.input")!!.readText().split("\n")
}