var numbers = ArrayList<Long>()

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()

    readLine().split(" ").map { it.toLong() }.forEach {
        numbers.add(it)
    }

    numbers.sort()

    repeat(m) {
        val (low, max) = readLine().split(" ").map { it.toLong() }
        sb.append(upperBound(max) - lowerBound(low)).append("\n")
    }

    println(sb)
}

fun lowerBound(target: Long): Int {
    var start = 0
    var end = numbers.size

    while (start < end) {
        val middle = (start + end) / 2

        if (numbers[middle] < target) start = middle + 1
        else end = middle
    }

    return end
}

fun upperBound(target: Long): Int {
    var start = 0
    var end = numbers.size

    while (start < end) {
        val middle = (start + end) / 2

        if (numbers[middle] <= target) start = middle + 1
        else end = middle
    }

    return end
}
