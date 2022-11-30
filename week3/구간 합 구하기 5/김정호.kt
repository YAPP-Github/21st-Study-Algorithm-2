fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val arr = Array(n + 1) { IntArray(n + 1) }
    val sb = StringBuilder()

    repeat(n) { x ->
        val input = readLine().split(" ").map { it.toInt() }.toIntArray()

        repeat(n) { y ->
            arr[x + 1][y + 1]  = arr[x + 1][y] + arr[x][y + 1] + input[y] - arr[x][y]
        }
    }

    repeat(m) {
        val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
        val sum = arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1]

        sb.append(sum).append("\n")
    }

    println(sb)
}
