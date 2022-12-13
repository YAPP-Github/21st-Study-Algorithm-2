fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()

    val inputList = readLine().split(' ').map { it.toInt() }
    val sortedList = inputList.sorted()

    val M = readLine().toInt()
    val checkList = readLine().split(' ').map { it.toInt() }
    checkList.forEach {
        println(if (binarySearch(it, sortedList)) 1 else 0)
    }
}

fun binarySearch(find: Int, list: List<Int>): Boolean {
    var start = 0
    var end = list.size - 1
    while (start <= end) {
        val mid = (start + end) / 2
        if (list[mid] == find) return true
        else if (list[mid] < find) start = mid + 1
        else end = mid - 1
    }
    return false
}