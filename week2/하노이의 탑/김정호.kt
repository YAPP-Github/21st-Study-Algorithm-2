class Solution {
    fun solution(n: Int): Array<IntArray> {
        val answer = mutableListOf<IntArray>()

        // num : 원판의 개수
        // start : 시작 기둥 번호
        // end : 도착 기둥 번호
        // mid : 거치는 기둥 번호

        fun hanoi(num: Int, start: Int, end: Int, mid: Int) {
            if (num == 1) {
                answer.add(intArrayOf(start, end))
                return
            }

            hanoi(num - 1, start, mid, end)
            answer.add(intArrayOf(start, end))
            hanoi(num - 1, mid, end, start)
        }

        hanoi(n, 1, 3, 2)

        return answer.toTypedArray()
    }
}
