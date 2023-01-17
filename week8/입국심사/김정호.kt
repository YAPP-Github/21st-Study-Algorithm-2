val checkpoints = ArrayList<Long>()

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toLong() }

    repeat(n.toInt()) {
        checkpoints.add(readLine().toLong())
    }

    checkpoints.sort()

    println(binarySearch(m) + 1)
}

fun binarySearch(peopleCount: Long): Long {
    var start = 1L
    var end = checkpoints.last() * peopleCount

    while (start <= end) {
        val middle = (start + end) / 2
        val count = checkpoints.sumOf { middle / it }

        if (count < peopleCount) start = middle + 1
        else end = middle - 1
    }

    return end
}

