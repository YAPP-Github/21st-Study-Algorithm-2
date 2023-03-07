import kotlin.system.exitProcess

val zeros = ArrayList<IntArray>()
lateinit var board: Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    board = Array(9) { x ->
        readLine().split(" ").mapIndexed { y, value ->
            if (value == "0") zeros.add(intArrayOf(x, y))
            value.toInt()
        }.toIntArray()
    }
    dfs(0)
}

fun dfs(index: Int) {
    //도달한 경우
    if (index == zeros.size) {
        StringBuilder().apply {
            board.forEach { line ->
                line.forEach {
                    append("$it ")
                }
                appendLine()
            }
        }.also {
            print(it.toString())
        }
        exitProcess(0)
    }

    //도달하지 않은 경우
    val cur = zeros[index] //미리 구해놨던 zero 위치
    (1..9).forEach { // 해당 위치에 1~9까지 넣어서 체크
        if (check(cur[0], cur[1], it)) {
            board[cur[0]][cur[1]] = it //성립한다면 그 값을 저장
            dfs(index+1) //새로운 탐색
            board[cur[0]][cur[1]] = 0 //만족하지 않는다면 다시 원상복귀
        }
    }
}

fun check(col: Int, row: Int, target: Int): Boolean { // 0 위치에 어떤 값을 넣었을 때 성립하는가?
    //선형 체크
    (0 until 9).forEach {
        if (board[col][it] == target) {
            return false
        }
        if (board[it][row] == target) {
            return false
        }
    }
    //원형 체크
    val sectionX = col / 3 * 3
    val sectionY = row / 3 * 3
    (sectionX..sectionX + 2).forEach { x ->
        (sectionY..sectionY + 2).forEach { y ->
            if (board[x][y] == target) {
                return false
            }
        }
    }
    return true
}

