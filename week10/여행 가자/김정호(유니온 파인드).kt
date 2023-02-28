lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()

    parent = IntArray(n) { it }

    repeat(n) { a ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { b, value ->
            if (value == 1) union(a, b)
        }
    }

    val plans = readLine().split(" ").map { it.toInt() - 1 }

    plans.forEach {
        if (find(it) != find(plans[0])) {
            println("NO")
            return@with
        }
    }

    println("YES")
}

fun union(a: Int, b: Int) {
    val findA = find(a)
    val findB = find(b)

    parent[findB] = findA
}

fun find(targetIndex: Int): Int {
    if (parent[targetIndex] == targetIndex) return targetIndex
    parent[targetIndex] = find(parent[targetIndex])
    return parent[targetIndex]
}
