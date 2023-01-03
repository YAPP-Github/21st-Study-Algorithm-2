fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val N = readLine().toInt()

    val musics = IntArray(N + 1)
    val sum = IntArray(N + 1)
    val input = readLine().split(" ").map { it.toInt() }

    for (i in 1..N) {
        musics[i] = input[i - 1]
        if (musics[i] < musics[i - 1]) {
            sum[i] = sum[i - 1] + 1
        } else {
            sum[i] = sum[i - 1]
        }
    }

    val Q = readLine().toInt()

    /*
        musics : 0, 1, 2, 3, 3, 4, 1, 10, 8, 1
        sum    : 0, 0, 0, 0, 0, 0, 1, 1,  2, 3
     */

    repeat(Q) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        sb.append(sum[y] - sum[x]).append("\n")
    }

    println(sb)
}
