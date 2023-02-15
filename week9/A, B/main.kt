var result = 0
var flag = false
fun main() = with(System.`in`.bufferedReader()) {
    val (A, B) = readLine().split(" ").map(String::toInt)
    recur(A.toLong(), B.toLong(), 0)
    if (flag) {
        print(result + 1)
    } else {
        print(-1)
    }

}

fun recur(A: Long, B: Long, count: Int) {
    if (A > B) {
        return
    } else if (A == B) {
        result = count
        flag = true
        return
    }
    recur(A * 2, B, count + 1)
    recur(A * 10 + 1, B, count + 1)
}