class Solution {
    fun solution(elements: IntArray): Int {
        val set = mutableSetOf<Int>()
        val size = elements.size

        for(i in elements.indices){
            for(j in elements.indices){
                var sum = 0
                for(k in j until j+i){
                    sum += elements[k % size]
                }
                set.add(sum)
            }
        }
        return set.size
    }
}

//완전탐색 문제로 예상
//모든 경우의 수에 대한 합을 구해서, set에 넣어 중복을 제거