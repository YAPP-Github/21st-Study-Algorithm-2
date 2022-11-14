class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val queue = ArrayList<Document>()
        priorities.forEachIndexed { index, priority ->
            queue.add(Document(index, priority))
        }
        while (queue.isNotEmpty()) {
            val document = queue.removeAt(0)
            val foundDocument = queue.find { it.priority > document.priority }
            if (foundDocument != null) {
                queue.add(document)
            } else {
                answer++
                if (document.location == location) break
            }
        }
        return answer
    }
}

data class Document(
    val location: Int,
    val priority: Int
)