import kotlin.math.pow

class Solution {
    fun solution(numbers: LongArray): LongArray {
        return numbers.map { f(it) }.toLongArray()
    }

    fun f(x: Long): Long {
        return if (x % 2 == 0L) {
            x + 1
        } else {
            StringBuilder(x.toString(2)).apply {
                if (contains('0')) {
                    val index = indexOfLast { it == '0' }
                    setCharAt(index, '1')
                    setCharAt(index + 1, '0')
                } else {
                    setCharAt(0, '0')
                    insert(0, '1')
                }
            }.toString().toLong(2)
        }
    }
}


fun toBinary(x: Int, len: Int): String {
    val result = StringBuilder()
    for (i in len - 1 downTo 0) {
        val mask = 1 shl i
        result.append(if (x and mask != 0) 1 else 0)
    }
    return result.toString()
}


// 1. 완전탐색 : x를 증가시키면서 xor하고 1을 셈. 시간초과
// 2. DP 배열 크기를 벗어남 X
// 3. String 연산
