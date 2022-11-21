import kotlinx.coroutines.flow.MutableStateFlow

class Solution {
    private val list = ArrayList<IntArray>()
    fun solution(n: Int): Array<IntArray> {
        hanoi(n, 1, 3, 2)
        return list.toTypedArray()
    }
    private fun hanoi(n: Int, start: Int, end: Int, middle: Int){
        if(n == 1){
            move(start, end)
        }else{
            hanoi(n-1,start, middle, end)
            move(start, end)
            hanoi(n-1,middle, end, start)
        }

    }
    private fun move(start: Int, end: Int){
        list.add(intArrayOf(start,end))
    }
}

/*
*
*
3개의 원반을 옮기는 과정은 다음 함수로 표현할 수 있다.

hanoi(3, ‘A’, ‘C’, ‘B’)
그리고 hanoi 함수는 두 번의 재귀와 한 번의 가장 큰 원반을 옮기는 과정이 필요하다고 했다. 즉, 전체 과정을 세 과정의 연속으로 분해가능한 것이다. 이때 각 과정은 순차적으로 이루어지는데 그 순서는 다음과 같다. 이 과정은 그림과 같이 확인하라.

1. hanoi(2, ‘A’, ‘B’, ‘C’) : start에서 3번까지
    3번 원반을 ‘C’로 옮기기 위해서는 먼저 위의 두 원반을 ‘B’로 옮겨야 한다.
2. 이후 3번 원반을 ‘C’로 옮긴다 : 4번
3. hanoi(2, ‘B’, ‘C’, ‘A’) : 5번 ~
    3번을 ‘C’로 옮긴 후 ‘B’에 있는 두 개의 원반을 ‘C’로 옮긴다. 이때 ‘A’를 경유한다.
*
*
*
*
* */
