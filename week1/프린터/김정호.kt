import java.util.*

class Solution {
    private var answer = 0

    fun solution(priorities: IntArray, location: Int): Int {

        val list = priorities.mapIndexed { index, value -> Pair(index, value) }
        val queue: Queue<Pair<Int, Int>> = LinkedList(list)

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            if (queue.any { it.second > current.second }) queue.add(current)
            else {
                answer++
                if (location == current.first) break
            }
        }

        return answer
    }
}
