import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var nm = br.readLine().split(" ")
    var n = nm[0].toInt()
    var m = nm[1].toInt()
    var ans = BigInteger.ONE
    for (i in n-m+1 .. n){
        ans *= i.toBigInteger()
        //println(ans)
    }
    for (i in 1 .. m ){
        ans /= i.toBigInteger()
        //println(ans)
    }
    println(ans)
}

