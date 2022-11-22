class Solution {
    val answerList = mutableListOf<IntArray>()

    fun solution(n: Int): Array<IntArray> {
        var answer = arrayOf<IntArray>()

        hanoi(n, 1, 3, 2)

        answer = answerList.toTypedArray()
        return answer
    }

    fun hanoi(remain: Int, start: Int, end: Int, sub: Int) {
        if (remain == 1) {
            answerList.add(intArrayOf(start, end))
            return
        }
        hanoi(remain - 1, start, sub, end)
        answerList.add(intArrayOf(start, end))
        hanoi(remain - 1, sub, end, start)
    }
}