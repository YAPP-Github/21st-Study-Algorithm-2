class Solution {
    private var answer = 0
    private var isStop = false

    fun solution(word: String): Int {
        DFS(word, "")
        return answer
    }

    private fun DFS(word: String, alphabet: String) {
        if (alphabet == word) {
            isStop = true
            return
        }

        if (alphabet.length >= 5) return

        "AEIOU".forEach {
            if (!isStop) {
                answer++
                DFS(word, alphabet + it)
            }
        }
    }
}
