
fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    repeat(T) {
        val str = readLine()
        var s = 0
        var e = str.lastIndex
        if (str.isPalindrome(s, e)) {
            println(0)
        } else {
            while (s <= e) {
                if (str[s] == str[e]) {
                    s++
                    e--
                    continue
                } else {
                    val left = str.isPalindrome(s + 1, e)
                    val right = str.isPalindrome(s, e - 1)
                    if(!left && !right){
                        println(2)
                        break
                    }else{
                        println(1)
                        break
                    }
                }
            }
        }
    }
}

fun String.isPalindrome(start: Int, end: Int): Boolean {
    var s = start
    var e = end
    while(s <= e){
        if(this[s] != this[e]) return false
        s++
        e--
    }
    return true
}