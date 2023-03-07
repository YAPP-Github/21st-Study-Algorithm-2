import kotlin.system.exitProcess

val sudoku = Array(9) { IntArray(9) }

fun main() = with(System.`in`.bufferedReader()) {
    repeat(9) {
        sudoku[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    DFS(0, 0)
}

fun DFS(row: Int, column: Int) {
    if(column == 9) {
        DFS(row + 1, 0)
        return
    }

    if(row == 9) {
        repeat(9) { x ->
            repeat(9) { y ->
                print("${sudoku[x][y]} ")
            }
            println()
        }

        exitProcess(0)
    }

    if(sudoku[row][column] == 0) {
        for(value in 1..9) {
            if(isSudoku(row, column, value)) {
                sudoku[row][column] = value
                DFS(row, column + 1)
            }
        }
        sudoku[row][column] = 0
        return
    }

    DFS(row, column + 1)
}

fun isSudoku(row: Int, column: Int, value: Int): Boolean {

    repeat(9) {
        if (sudoku[row][it] == value) return false
    }

    repeat(9) {
        if (sudoku[it][column] == value) return false
    }

    val curLow = (row / 3) * 3
    val curColumn = (column / 3) * 3

    for (i in curLow..curLow + 2) {
        for (j in curColumn..curColumn + 2) {
            if (sudoku[i][j] == value) return false
        }
    }

    return true
}
