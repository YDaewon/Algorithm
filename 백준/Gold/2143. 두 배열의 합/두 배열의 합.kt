import java.io.BufferedReader
import java.io.InputStreamReader

var head_y =  arrayOf(0, 0, -1, 1, -1, 1, -1, 1)
var head_x =  arrayOf(1, -1, 0, 0, -1, 1, 1, -1)

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var T = br.readLine().toLong()
    var n = br.readLine().toInt()
    var A = br.readLine().split(" ").map{it.toLong()}
    var m = br.readLine().toInt()
    var B = br.readLine().split(" ").map{it.toLong()}
    var A_sub_sum = ArrayList<Long>()
    var B_sub_sum = ArrayList<Long>()
    for (i: Int in 0 until n) {
        var suma:Long = A[i]
        A_sub_sum.add(suma)
        for (j: Int in i+1 until n) {
            suma += A[j]
            A_sub_sum.add(suma)
        }
    }
    for (i: Int in 0 until m) {
        var sumb:Long = B[i]
        B_sub_sum.add(sumb)
        for (j: Int in i+1 until m) {
            sumb += B[j]
            B_sub_sum.add(sumb)
        }
    }
    A_sub_sum.sort()
    B_sub_sum.sort()
    var ans:Long = 0
    var ap = 0
    var bp = B_sub_sum.size-1

    while(ap <A_sub_sum.size && bp > -1){
        var at:Long = A_sub_sum[ap]
        var bt:Long = B_sub_sum[bp]
        var temp:Long = at + bt
        if(temp == T){
            var ac:Long = 0
            var bc:Long = 0
            while(ap < A_sub_sum.size && at == A_sub_sum[ap]){
                ap++
                ac++
            }
            while(bp > -1 && bt == B_sub_sum[bp]){
                bp--
                bc++
            }
            ans += ac * bc
        }
        if(temp > T)
            bp--
        else if(temp < T)
            ap++
    }
    print(ans)
}

