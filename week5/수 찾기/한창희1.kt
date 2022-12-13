fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()

    val set = mutableSetOf<Int>()
    val inputList = readLine().split(' ').map { it.toInt() }
    inputList.forEach {
        set.add(it)
    }

    val M = readLine().toInt()
    val checkList = readLine().split(' ').map { it.toInt() }
    checkList.forEach {
        println(if (set.contains(it)) 1 else 0)
    }
}