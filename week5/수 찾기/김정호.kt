fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    val N = readLine().toInt()
    val numbers = readLine().split(" ").map { it.toLong() }.sorted()

    val M = readLine().toInt()
    val findNumbers = readLine().split(" ").map { it.toLong() }

    findNumbers.forEach {
        sb.append(
            if (isContainsTarget(numbers, it)) 1
            else 0
        ).append("\n")
    }

    println(sb)
}


fun isContainsTarget(numbers: List<Long>, target: Long): Boolean {
    var low = 0
    var high = numbers.lastIndex

    while (low <= high) {
        val middle = (low + high) / 2

        when {
            numbers[middle] == target -> return true
            numbers[middle] < target -> low = middle + 1
            else -> high = middle - 1
        }
    }

    return false
}
