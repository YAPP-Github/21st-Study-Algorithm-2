fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val s = readLine()
        sb.append(isPalindrome(0, s.lastIndex, 0, s)).append("\n")
    }

    println(sb)
}

fun isPalindrome(left: Int, right: Int, delete: Int, s: String): Int {
    var left = left
    var right = right

    while (left <= right) {
        if (s[left] != s[right]) {
            if(delete == 0) {
                if(isPalindrome(left + 1, right, 1, s) == 0 || isPalindrome(left, right - 1, 1, s) == 0 ) return 1
                return 2
            } else {
                return 2
            }
        } else {
            left++
            right--
        }
    }

    return 0
}
