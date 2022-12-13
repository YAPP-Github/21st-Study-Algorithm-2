val sb: StringBuilder = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val (L, C) = readLine().split(" ").map { it.toInt() }
    val str = readLine().split(" ")
        .flatMap { it.toList() }
        .sorted()
        .joinToString("")
    dfs("", str, -1, 0, 0 , L)
    print(sb)
}

// 순회에 들어갔을때, 전역변수는 공통이고 매개변수에 필요한 정보를 제공해야 한다.
fun dfs(current: String, original: String, index: Int, jaeum: Int, moeum: Int, L: Int) {
//  1. 체크인 - 정렬로 인해 생략 가능
//  2. 목적지인가? - 길이가 + 자음,모음 개수
    if (current.length == L) {
        if (jaeum >= 2 && moeum >= 1) sb.appendLine(current)
    } else {
//      3. 연결된 곳을 순회 - 나보다 높은 알파벳
        (index + 1 until original.length).forEach { index ->
            if (isJaeum(original[index])) {
                dfs(current + original[index], original, index, jaeum + 1, moeum, L)
            } else {
                dfs(current + original[index], original, index, jaeum, moeum + 1, L)
            }
        }
    }
}

fun isJaeum(c: Char): Boolean {
    return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u'
}

// 정렬하면 한번의 dfs 호출로 가능하지만, 정렬하지 않는다면 각 인덱스에서 호출해야한다.