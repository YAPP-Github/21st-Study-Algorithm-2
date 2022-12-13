fun main() = with(System.`in`.bufferedReader()) {
    val studentMap = mutableMapOf<Int, Info>()

    val N = readLine().toInt()
    val T = readLine().toInt()
    val inputList = readLine().split(' ').map { it.toInt() }
    inputList.forEachIndexed { time, studentNum ->
        studentMap[studentNum]?.let {
            it.count++
        } ?: run {
            if (studentMap.size >= N) {
                val sortedList = studentMap.toList()
                    .sortedWith(compareBy<Pair<Int, Info>> { it.second.count }.thenBy { it.second.time })
                val eraseNum = sortedList[0].first
                studentMap.remove(eraseNum)
            }
            studentMap[studentNum] = Info(time = time, count = 1)
        }
    }

    val sortedList = studentMap.toList()
        .sortedWith(compareBy<Pair<Int, Info>> { it.first })
    sortedList.forEach {
        print("${it.first} ")
    }
}

data class Info(
    var time: Int,
    var count: Int
)