lateinit var board: Array<CharArray>
fun main() = with(System.`in`.bufferedReader()) {
    board = Array(3) {
        CharArray(3)
    }
    var tc = ""
    val sb = StringBuilder()
    while (readLine().also { tc = it } != "end") {
        var xCount = 0
        var oCount = 0
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                board[i][j] = tc[3 * i + j]
                if (board[i][j] == 'X') xCount++
                else if (board[i][j] == 'O') oCount++
            }
        }

        if (xCount + oCount == 9 && xCount - oCount == 1) { //말이 꽉 채워진 상태
            if (check('X') && check('O')) { //둘 다 빙고이면 유효하지 않음
                sb.appendLine("invalid")
            } else if (check('O')) { //O는 이 상황에서 이길 수가 없음
                sb.appendLine("invalid")
            } else {
                sb.appendLine("valid")
            }
        } else {
            if (check('X') && check('O')) { //둘 다 빙고이면 유효하지 않음
                sb.appendLine("invalid")
            } else if (check('X') && xCount - oCount == 1) { //x가 o보다 하나 많음을 만족해야함
                sb.appendLine("valid")
            } else if (check('O') && xCount == oCount) { //o가 x랑 같음을 만족해야함
                sb.appendLine("valid")
            } else { //빙고가 없음
                sb.appendLine("invalid")
            }
        }
    }
    print(sb)
}

private fun check(c: Char): Boolean {
    for (i in 0..2) {
        var cnt = 0
        for (j in 0..2) {
            if (board[i][j] == c) cnt++
        }
        if (cnt == 3) return true
    }
    for (j in 0..2) {
        var cnt = 0
        for (i in 0..2) {
            if (board[i][j] == c) cnt++
        }
        if (cnt == 3) return true
    }
    return if (board[0][0] == c && board[1][1] == c && board[2][2] == c) true
    else board[0][2] == c && board[1][1] == c && board[2][0] == c
}

