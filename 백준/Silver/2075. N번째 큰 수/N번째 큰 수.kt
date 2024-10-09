import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    val pq =PriorityQueue<Int>()
    for (i in 0 until n){
        val temp = br.readLine().split(" ")
        for (j in 0 until n){
            pq.add(temp[j].toInt())
            if(pq.size > n){
                pq.remove()
            }
        }
    }
    println(pq.peek())
}

