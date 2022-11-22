package programmers.yapp.twentyone.week2

fun main() {
    print(SubsequenceSumCounter().solution(intArrayOf(7, 9, 1, 1, 4)))
}

class SubsequenceSumCounter {
    fun solution(elements: IntArray): Int {
        val sequenceSumSet = mutableSetOf<Int>()

        for (cycle in 1..elements.size) {

            for (i in elements.indices) {
                var sum = 0
                for (j in i until i + cycle) {
                    var index = j
                    if (j >= elements.size) index -= elements.size
                    sum += elements[index]
                }
                sequenceSumSet.add(sum)
            }
        }

        return sequenceSumSet.size
    }
}

class BestSolution {
    fun solution(elements: IntArray): Int {
        val doubling = elements + elements
        val result = HashSet<Int>()
        for (i in 1..elements.size) {
            result.addAll((elements.indices).map {
                doubling.slice(it until it + i).sum()
            })
        }
        return result.size
    }
}
