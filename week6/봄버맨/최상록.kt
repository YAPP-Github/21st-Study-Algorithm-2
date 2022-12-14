import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (R, C, N) = readLine().split(" ").map(String::toInt)
    val map = Array(R) {
        readLine().toCharArray()
    }
    val initialBombs = ArrayList<IntArray>()
    map.forEachIndexed { x: Int, chars: CharArray ->
        chars.forEachIndexed { y, c ->
            if (c == 'O') initialBombs.add(intArrayOf(x, y))
        }
    }
    bfs(map, initialBombs, R, C, N)
    map.forEach {
        println(it.joinToString(""))
    }
}

val dx = intArrayOf(-1, 0, 1, 0)
val dy = intArrayOf(0, -1, 0, 1)
fun bfs(map: Array<CharArray>, initialBombs: ArrayList<IntArray>, R: Int, C: Int, N: Int) {
    var timer = 1
    val cache = ArrayList<IntArray>()
    while (timer <= N) {
        if (timer % 2 == 0) {
            map.forEachIndexed { x, charArray ->
                charArray.forEachIndexed { y, c ->
                    if (c == 'O') cache.add(intArrayOf(x, y))
                    else map[x][y] = 'O'
                }
            }
        } else {
            cache.forEach { cur ->
                (0..3).forEach { dir ->
                    val nX = cur[0] + dx[dir]
                    val nY = cur[1] + dy[dir]
                    map[cur[0]][cur[1]] = '.'
                    if (nX in 0 until R && nY in 0 until C) {
                        map[nX][nY] = '.'
                    }
                }
            }
            cache.clear()
        }
        timer++
    }
}