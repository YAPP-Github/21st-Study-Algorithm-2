import kotlin.math.min

const val INF = 10000000 //INF + INF 케이스에서 오버플로우 발생할 수 있음 적당한 크기로 설정
lateinit var g: Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map(String::toInt)
    g = Array(n+1){ i ->
        IntArray(n+1){ j ->
            if(i == j) 0
            else INF
        }
    }
    repeat(m){
        val (s, e) = readLine().split(" ").map(String::toInt)
        g[s][e] = 1
        g[e][s] = 1
    }

    (1 .. n).forEach { k -> //거쳐가는 노드
        (1 .. n).forEach { i -> //출발 노드
            (1 .. n).forEach { j-> //도착 노드
                g[i][j] = min(g[i][j],g[i][k]+g[k][j])
            }
        }
    }
    var result: OptimalLocation = OptimalLocation(0,0, Int.MAX_VALUE)
    (1 .. n ).forEach { i ->
        (1 .. n).forEach { j ->
            var temp = 0
            (1 .. n).forEach { k ->
                temp += min(g[k][i] * 2, g[k][j] * 2)
            }
            if(result.minTime > temp){
                result = OptimalLocation(i,j,temp)
            }else if(result.minTime == temp){
                if(result.a > i){
                    result = OptimalLocation(i,j,temp)
                }else if(result.a == i){
                    if(result.b > j){
                        result = OptimalLocation(i,j,temp)
                    }
                }
            }
        }
    }
    print(result.toString())
}

data class OptimalLocation(
    val a: Int,
    val b: Int,
    val minTime: Int
){
    override fun toString(): String {
        return "$a $b $minTime"
    }
}

// 다익스트라가 한 정점에 대해 모든 정점까지의 최단거리를 구한다면
// 플로이드 와샬은 모든 정점에 대해 모든 정점까지의 최단거리를 구함
// 모든 정점까지의 최단 거리를 구했다면, 접근성이 가장 좋은 건물 X를 찾아야 한다.
// ex) 4번 건물에 대한 접근성 - (1,4), (2,4) (3,4) (5, 4)