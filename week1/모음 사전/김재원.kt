class `모음사전_김재원` {
    val dict = mutableListOf<String>()
    fun solution(word: String): Int {
        var answer = 0
        val list  = arrayOf("A","E","I","O","U")
        repeat(6){
            permutaion(list, Array(it){""},0,it)
        }

        return dict.sorted().indexOf(word)
    }

    fun permutaion(arr : Array<String>, output : Array<String>, depth : Int, r : Int){
        if(depth == r){
            dict.add(output.joinToString(""))
            return
        }
        for (i in arr.indices){
            output[depth] = arr[i]
            permutaion(arr,output,depth+1, r)
        }
    }
}