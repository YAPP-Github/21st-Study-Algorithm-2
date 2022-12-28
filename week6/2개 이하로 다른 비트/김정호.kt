class Solution {
    fun solution(numbers: LongArray): LongArray {
        return numbers.map { getAnswer(it) }.toLongArray()
    }

    private fun getAnswer(n: Long): Long {
        if (n % 2 == 0L) {
            return n + 1
        }
        else {
            var binary = n.toString(2)
            val answer: String

            if (binary.contains('0')) {
                val index = binary.indexOfLast { it == '0' }

                answer = binary.toCharArray().apply {
                    this[index] = '1'
                    this[index + 1] = '0'
                }.joinToString("")
            } else {
                binary += 1

                answer = binary.toCharArray().apply {
                    this[1] = '0'
                }.joinToString("")
            }

            return answer.toLong(2)
        }
    }
}
