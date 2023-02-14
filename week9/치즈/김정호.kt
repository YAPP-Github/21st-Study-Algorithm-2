import java.util.*

/**
 * 1. 0으로 된 부분 탐색
 * 2. 0의 상하좌우 부분을 모두 0으로 만들기
 * 3. 모두 방문처리 하되, 1인 경우 Queue 에 넣지 않음
 * 모두 1인 경우 테스트, 첫 숫자가 1인 경우 테스트 필요
 */

lateinit var array: Array<CharArray>

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    array = Array(n) { CharArray(m) }

    repeat(n) {
        array[it] = readLine().replace(" ", "").toCharArray()
    }

    var time = 0
    var remember = 0

    while (true) {
        val result = BFS()
        if (result == 0) break
        time++
        remember = result
    }

    println(time)
    println(remember)
}

fun BFS(): Int {
    val visited = Array(array.size) { BooleanArray(array[0].size) }

    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(0 to 0)
    visited[0][0] = true

    var count = 0

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()

            for (i in 0 until 4) {
                val x = curr.first + dx[i]
                val y = curr.second + dy[i]

                if (x !in array.indices || y !in array[0].indices) continue
                if (visited[x][y]) continue

                if (array[x][y] == '1') {
                    array[x][y] = '0'
                    visited[x][y] = true
                    count++
                    continue
                }

                queue.add(x to y)
                visited[x][y] = true
            }
        }
    }

    return count
}
