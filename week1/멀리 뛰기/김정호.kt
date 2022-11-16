class Solution {
    private val d = LongArray(2001)
    private var answer: Long = 0

    fun solution(n: Int): Long {
        return topDown(n)
    }

    private fun topDown(n: Int): Long {
        if (n <= 3) return n.toLong()

        if (d[n] != 0L) return d[n]

        d[n] = (topDown(n - 1) + topDown(n - 2)) % 123_456_7

        return d[n]
    }

    private fun bottomUp(n: Int): Long {
        d[0] = 1
        d[1] = 1

        for (i in 2..n) {
            d[i] = (d[i - 2] + d[i - 1]) % 123_456_7
        }

        return d[n]
    }

    private fun exhaustiveSearch(x: Int, n: Int) {
        when {
            x == n -> {
                answer++
                return
            }
            x > n -> {
                return
            }
        }

        exhaustiveSearch(x + 1, n)
        exhaustiveSearch(x + 2, n)
    }
}
