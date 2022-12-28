fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val tictactoe = readLine()
        if (tictactoe == "end") break

        val array = Array(3) { Array(3) { '.' } }

        initArray(array, tictactoe)

        println(
            if (isValid(array)) "valid"
            else "invalid"
        )
    }
}

fun initArray(array: Array<Array<Char>>, tictactoe: String) {
    var count = 0

    repeat(3) { i ->
        repeat(3) { j ->
            val ch = tictactoe[count]
            array[i][j] = ch
            count++
        }
    }
}

fun isValid(array: Array<Array<Char>>): Boolean {
    var xCount = 0
    var oCount = 0
    var xBingo = 0
    var oBingo = 0

    repeat(3) { i ->
        repeat(3) { j ->
            when (array[i][j]) {
                'X' -> xCount++
                'O' -> oCount++
            }
        }
    }

     if (xCount - oCount != 1 && xCount - oCount != 0) return false

    // 가로
    repeat(3) { i ->
        if (array[i][0] == array[i][1] && array[i][0] == array[i][2]) {
            when (array[i][0]) {
                'X' -> xBingo++
                'O' -> oBingo++
            }
        }
    }

    // 세로
    repeat(3) { i ->
        if (array[0][i] == array[1][i] && array[0][i] == array[2][i]) {
            when (array[0][i]) {
                'X' -> xBingo++
                'O' -> oBingo++
            }
        }
    }

    // 대각선
    if (array[0][0] == array[1][1] && array[0][0] == array[2][2]) {
        when (array[0][0]) {
            'X' -> xBingo++
            'O' -> oBingo++
        }
    }

    if (array[0][2] == array[1][1] && array[0][2] == array[2][0]) {
        when (array[0][2]) {
            'X' -> xBingo++
            'O' -> oBingo++
        }
    }

    if(xBingo > 0) {
        if(oBingo > 0) return false
        return xCount - oCount == 1
    }

    if(oBingo > 0) {
        return xCount - oCount == 0
    }

    if(xCount + oCount == 9) return true

    return false
}
