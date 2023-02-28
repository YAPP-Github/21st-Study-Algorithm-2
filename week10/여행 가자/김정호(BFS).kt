import java.util.*

lateinit var array: Array<IntArray>
lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    val m = readLine().toInt()

    array = Array(n) { intArrayOf() }
    visited = BooleanArray(n)

    repeat(n) {
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            if(i == 1) {
                array[it] += intArrayOf(index)
            }
        }
    }

    val plans = readLine().split(" ").map { it.toInt() - 1 }

    BFS(plans[0])

    plans.forEach {
        if (!visited[it]) {
            println("NO")
            return@with
        }
    }

    println("YES")
}

fun BFS(start: Int) {
    val queue = LinkedList<Int>()

    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val curr = queue.poll()

        for(i in array[curr]) {
            if(!visited[i]) {
                queue.add(i)
                visited[i] = true
            }
        }
    }
}
