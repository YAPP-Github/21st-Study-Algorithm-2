class Solution {
    val dictionary = "AEIOU"
    var count = 0
    var answer = 0

    fun solution(word: String): Int {
        dfs("", word)
        return answer
    }

    fun dfs(word: String, target: String) {
        if (target == word) {
            answer = count
            return
        }
        if (word.length >= 5) return
        dictionary.forEach {
            count++
            dfs(word + it, target)
        }
    }
}