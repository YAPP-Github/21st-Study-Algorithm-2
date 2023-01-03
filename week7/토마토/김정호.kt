import java.util.*

lateinit var g: Array<Array<IntArray>>
lateinit var queue: Queue<Triple<Int, Int, Int>>

val dx = intArrayOf(-1, 1, 0, 0, 0, 0)
val dy = intArrayOf(0, 0, -1, 1, 0, 0)
val dz = intArrayOf(0, 0, 0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n, h) = readLine().split(" ").map { it.toInt() }

    g = Array(h) { Array(n) { IntArray(m) } }
    queue = LinkedList()

    var noRipe = 0

    repeat(h) { i ->
        repeat(n) { j ->
            val s = readLine().split(" ").map { it.toInt() }
            repeat(m) { k ->
                when (s[k]) {
                    1 -> queue.add(Triple(i, j, k))
                    0 -> noRipe++
                }
                g[i][j][k] = s[k]
            }
        }
    }

    if (noRipe == 0) {
        println(0)
        return@with
    }

    val res = bfs(n, m, h, noRipe)
    println(res)
}

private fun bfs(n: Int, m: Int, h: Int, tomato: Int): Int {
    var cnt = 0
    var ripeTomato = 0

    while (queue.isNotEmpty()) {
        val size = queue.size

        for (a in 0 until size) {
            val node = queue.poll()
            val x = node.second
            val y = node.third
            val z = node.first

            for (i in 0 until 6) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                val nz = z + dz[i]

                if (nx in 0 until n && ny in 0 until m && nz in 0 until h) {
                    if (g[nz][nx][ny] == 0) {
                        g[nz][nx][ny] = 1
                        queue.add(Triple(nz, nx, ny))
                        ripeTomato++
                    }
                }
                if (ripeTomato == tomato) {
                    cnt++
                    return cnt
                }
            }
        }
        cnt++
    }
    return -1
}
