fun lower(
    arr: List<Int>,
    target: Int,
): Int {
    var start = 0
    var end = arr.size
    while (start < end) {
        val mid = (start + end) / 2
        if (target <= arr[mid]) {
            end = mid
        } else {
            start = mid + 1
        }
    }
    return start
}

fun upper(
    arr: List<Int>,
    target: Int,
): Int {
    var start = 0
    var end = arr.size
    while (start < end) {
        val mid = (start + end) / 2
        if (target >= arr[mid]) {
            start = mid + 1;
        } else {
            end = mid;
        }
    }
    return start
}


fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map(String::toInt)
    val dots = readLine().split(" ").map(String::toInt).toList().sorted()
    val sb = StringBuilder()
    repeat(M) {
        val (start, end) = readLine().split(" ").map(String::toInt)
        val startIndex = lower(dots, start)
        var lastIndex = upper(dots, end)
        sb.appendLine(lastIndex - startIndex)
    }
    print(sb)
}
