import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toLong() }
    println(BFS(n, m))
}

fun BFS(start: Long, end: Long): Int {
    val queue = LinkedList<Long>()
    var level = 1

    queue.add(start)

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()

            val sum = curr * 2
            val plusOne = curr * 10 + 1

            if (sum < end) queue.add(sum)
            if (plusOne < end) queue.add(plusOne)
            if (sum == end || plusOne == end) return level + 1
        }
        level++
    }

    return -1
}
