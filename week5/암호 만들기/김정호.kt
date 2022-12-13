fun main() = with(System.`in`.bufferedReader()) {
    val (L, C) = readLine().split(" ").map { it.toInt() } // 암호의 길이, 문자 종류 수

    val alphabets = readLine().replace(" ", "").toCharArray().sorted()

    for (i in alphabets.indices) {
        recursion(alphabets, i, L, charArrayOf())
    }
}

fun recursion(alphabets: List<Char>, start: Int, limit: Int, character: CharArray) {
    val character = character + alphabets[start]

    if (character.size == limit) {
        var consonant = 0
        var vowel = 0

        for(ch in character) {
            if(isVowel(ch)) vowel++
            else consonant++
        }

        if (consonant >= 2 && vowel >= 1) println(character)
        return
    }

    for (i in start until alphabets.size) {
        if (i + 1 < alphabets.size) {
            recursion(alphabets, i + 1, limit, character)
        }
    }
}

fun isVowel(ch: Char): Boolean = charArrayOf('a', 'e', 'i', 'o', 'u').contains(ch)
