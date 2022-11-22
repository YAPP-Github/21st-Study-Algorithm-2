class Solution {
    fun solution(elements: IntArray): Int {
        val set = mutableSetOf<Int>()

        val doubleElements = elements + elements

        for (i in elements.indices) {
            for (j in elements.indices) {
                set.add(doubleElements.slice(j..j + i).sum())
            }
        }

        return set.size
    }
}
