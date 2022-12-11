import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val total = readLine().toInt()
    val priorityQueue = PriorityQueue<Student>()

    readLine().split(" ").map { it.toInt() }.forEachIndexed { time, number ->
        val find = priorityQueue.find { it.number == number }
        if (find != null) {
            priorityQueue.remove(find)
            priorityQueue.add(find.copy(rank = find.rank + 1))
        } else {
            if (priorityQueue.size < N) {
                priorityQueue.add(Student(number, time))
            } else {
                priorityQueue.poll()
                priorityQueue.add(Student(number, time))
            }
        }
    }
    print(priorityQueue.sortedBy { it.number }.joinToString(" ") { "${it.number}" })
}

data class Student(
    val number: Int,
    val time: Int,
    val rank: Int = 1,
) : Comparable<Student> {
    override fun compareTo(other: Student): Int {
        val comp1 = rank.compareTo(other.rank)
        return if (comp1 == 0) {
            time.compareTo(other.time)
        } else {
            comp1
        }
    }

}