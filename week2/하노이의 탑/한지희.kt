package programmers.yapp.twentyone.week2

class Solution {
    lateinit var answer: MutableList<IntArray>

    fun solution(n: Int): Array<IntArray> {
        answer = mutableListOf()
        hanoi(n, 1, 3, 2)
        return answer.toTypedArray()
    }

    private fun hanoi(n: Int, start: Int, destination: Int, temp: Int) {
        if (n == 1) {
            answer.add(intArrayOf(start, destination))
            return
        }

        hanoi(n - 1, start = start, destination = temp, temp = destination)
        answer.add(intArrayOf(start, destination))
        hanoi(n - 1, start = temp, destination = destination, temp = start)
    }
}