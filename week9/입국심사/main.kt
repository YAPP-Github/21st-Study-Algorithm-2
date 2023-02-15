fun canFinish(m: Long, mid: Long, arr: IntArray): Boolean {
    var sum = 0L
    for (t in arr) {
        sum += mid / t
        if (sum >= m) return true
    }
    return false
}

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map(String::toLong)
    val times = IntArray(N.toInt()) {
        readLine().toInt()
    }
    var left = 1L
    var right = times.maxOf { M * it }
    var answer = 0L
    while (left <= right) {
        val mid = (left + right) / 2
        if (canFinish(M, mid, times)) {
            answer = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    print(answer)
}

// 데이터의 범위가 되게 넓은데, 조건 찾기 - parametric search 떠올려보기