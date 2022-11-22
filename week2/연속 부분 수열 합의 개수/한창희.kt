class Solution {
    fun solution(elements: IntArray): Int {
        var answer: Int = 0

        val countMap = mutableMapOf<Int, Int>()
        val tempArray = elements + elements.sliceArray(0..elements.size - 2)

        for (inx in 0 until elements.size) {
            var tempSum = 0
            for (cnt in 0..elements.size - 1) {
                tempSum += tempArray[inx + cnt]
                countMap[tempSum] = 1
            }
        }

        answer = countMap.size
        return answer
    }
}