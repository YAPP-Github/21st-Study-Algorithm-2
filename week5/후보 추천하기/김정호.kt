import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    val N = readLine().toInt()
    val M = readLine().toInt()

    val students = readLine().split(" ").map { it.toInt() }
    val hs = LinkedHashMap<Int, Int>()

    for(stu in students) {
        putInPictureFrame(hs, stu, N)
    }

    for(key in hs.keys.sorted()) {
        sb.append(key).append(" ")
    }

    println(sb)
}

fun putInPictureFrame(hs: LinkedHashMap<Int, Int>, target: Int, size: Int) {
    // 사진틀 내부에 해당 학생이 있는지?
    // 해당 학생이 있다면 단순 카운트 증가
    // 해당 학생이 없을 때 꽉차있다면 기존 사진틀에서 가장 추천 수가 작은 학생 삭제 후 추가

    if(hs.containsKey(target)) {
        hs[target] = hs.getOrDefault(target, 0) + 1
    } else {
        if(hs.size == size) {
            var min = Int.MAX_VALUE
            var removeKey = 0

            for(key in hs.keys) {
                if(hs[key]!! < min) {
                    min = hs[key]!!
                    removeKey = key
                }
            }

            hs.remove(removeKey)
        }

        hs[target] = hs.getOrDefault(target, 0) + 1
    }
}
