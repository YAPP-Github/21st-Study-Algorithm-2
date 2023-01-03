import java.util.*

/*
* Queue를 ArrayList로 구현했을 때 시간 초과가 나는 것을 조심하자 ... 다신 ArrayList 안쓰겠습니다 .......
* 3차원 배열 bfs 문제
* */

val dx = arrayOf(-1, 0, 1, 0, 0, 0)
val dy = arrayOf(0, -1, 0, 1, 0, 0)
val dz = arrayOf(0, 0, 0, 0, -1, 1)
lateinit var arr: Array<Array<IntArray>>
val queue: Queue<Node> = LinkedList()
fun main() = with(System.`in`.bufferedReader()) {
    val (M, N, H) = readLine().split(" ").map(String::toInt)
    arr = Array(H) { i ->
        Array(N) { j ->
            readLine().split(" ").mapIndexed { k, element ->
                if (element == "1") queue.add(Node(i, j, k))
                element.toInt()
            }.toIntArray()
        }
    }
    print(bfs(H, N, M))
}

fun bfs(H: Int, N: Int, M: Int): Int {
    while (queue.isNotEmpty()) {
        val (curZ, curY, curX) = queue.poll()
        (0..5).forEach {
            val nextZ = curZ + dz[it]
            val nextY = curY + dy[it]
            val nextX = curX + dx[it]
            if (nextZ in 0 until H
                && nextY in 0 until N
                && nextX in 0 until M
                && arr[nextZ][nextY][nextX] == 0
            ) {
                queue.add(Node(nextZ, nextY, nextX))
                arr[nextZ][nextY][nextX] = arr[curZ][curY][curX] + 1
            }
        }
    }
    val result = check(H, N, M)
    return when(result){
        1 -> 0
        -1 -> -1
        else -> result-1
    }
}

data class Node(
    val z: Int,
    val y: Int,
    val x: Int,
)

fun check(H: Int, N: Int, M: Int): Int {
    var res = Int.MIN_VALUE
    (0 until H).forEach { i ->
        (0 until N).forEach { j ->
            (0 until M).forEach { k ->
                if (arr[i][j][k] == 0) return -1
                res = res.coerceAtLeast(arr[i][j][k])
            }
        }
    }
    return res
}
