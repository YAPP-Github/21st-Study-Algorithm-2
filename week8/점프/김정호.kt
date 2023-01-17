lateinit var array: Array<IntArray>
lateinit var visited: Array<LongArray>

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    array = Array(n) { intArrayOf() }
    visited = Array(n) { LongArray(n) { -1L } }

    repeat(n) {
        array[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    println(DFS(0, 0))
}

fun DFS(x: Int, y: Int): Long {
    if (x == array.lastIndex && y == array.lastIndex) {
        return 1
    }

    if (visited[x][y] == -1L) {
        visited[x][y] = 0
        val nextX = x + array[x][y]
        val nextY = y + array[x][y]

        if (nextX < array.size) visited[x][y] += DFS(nextX, y)
        if (nextY < array.size) visited[x][y] += DFS(x, nextY)
    }

    return visited[x][y]
}


/*
4
1 1 1 0
2 0 1 0
0 0 1 0
0 0 1 0

    arr[1][2] 부분이 겹치는 지점

    - arr[2][2]
    - arr[3][2]
      중복 방문 -> 시간 초과
 */
