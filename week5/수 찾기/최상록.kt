fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val arr = readLine().split(" ").map { it.toLong() }.toLongArray().sortedArray()
    val M = readLine().toInt()
    val sb = StringBuilder()
    readLine().split(" ").map { it.toLong() }.forEach { b ->
        if (binarySearch(arr, b)) {
            sb.appendLine("1")
        } else {
            sb.appendLine("0")
        }
    }
    print(sb)
}

fun binarySearch(arr: LongArray, target: Long): Boolean {
    var s = 0
    var e = arr.size - 1
    while (s <= e) {
        val mid = (s + e) / 2
        val midValue = arr[mid]
        when {
            midValue == target -> {
                return true
            }

            midValue < target -> {
                s = mid + 1
            }

            midValue > target -> {
                e = mid - 1
            }
        }
    }
    return false
}

// 순차탐색으로 한다면 O(n^2 x m), 따라서 이분탐색으로 O(nlogn x m)으로 줄여야함
// 범위 Long
