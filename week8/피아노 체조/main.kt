fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val arr = readLine().split(" ").map(String::toInt).toIntArray()
    val sub = IntArray(arr.size).apply {
        this[0] = 1
    }
    for (i in 1 until N ) {
        if (arr[i] < arr[i - 1]) {
            sub[i] = sub[i - 1] + 1
        } else {
            sub[i] = sub[i - 1]
        }
    }
    val Q = readLine().toInt()
    val sb = StringBuilder()
    repeat(Q) {
        val (x, y) = readLine().split(" ").map(String::toInt)
        sb.appendLine(sub[y-1] - sub[x-1])
    }
    print(sb)
}

//누적합 문제, sub arr에 현재까지 틀린 개수를 누적