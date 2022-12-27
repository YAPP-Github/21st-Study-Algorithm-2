import java.io.BufferedReader

val dx = listOf(0, 1, 0, -1)
val dy = listOf(1, 0, -1, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val (R, C, N) = readLine().split(" ").map { it.toInt() }
    val plate = Array(R) { Array(C) { "" } }

    initPlate(R, C, this, plate)

    var timer = 1
    val tmp = ArrayList<Pair<Int, Int>>()

    while (timer <= N) {
        for (x in 0 until R) {
            for (y in 0 until C) {
                if (timer % 2 == 0) {
                    if (plate[x][y] == "O") {
                        tmp.add(Pair(x, y))
                    }
                    plate[x][y] = "O"
                } else {
                    tmp.forEach {
                        boom(plate, it.first, it.second)
                    }
                    tmp.clear()
                }
            }
        }
        timer++
    }

    printPlate(R, C, plate)
}

fun boom(plate: Array<Array<String>>, x: Int, y: Int) {
    plate[x][y] = "."

    repeat(4) {
        val curX = x + dx[it]
        val curY = y + dy[it]

        if (curX != -1 && curY != -1 && curX != plate.size && curY != plate[0].size) {
            plate[curX][curY] = "."
        }
    }
}

fun initPlate(R: Int, C: Int, br: BufferedReader, plate: Array<Array<String>>) {
    repeat(R) { i ->
        val input = br.readLine().split("")

        repeat(C) { j ->
            plate[i][j] = input[j + 1]
        }
    }
}

fun printPlate(R: Int, C: Int, plate: Array<Array<String>>) {
    val sb = StringBuilder()

    repeat(R) { i ->
        repeat(C) { j ->
            sb.append(plate[i][j])
        }

        sb.append("\n")
    }

    println(sb)
}
