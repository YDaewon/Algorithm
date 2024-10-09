import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.round


fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    var fifteen = round(n * 0.15).toInt()
    var sum = 0
    var ground = Array(n) { br.readLine().toInt() }.sorted()
    for (i: Int in fifteen until n - fifteen) {
         sum += ground[i]
    }
    print(round(sum.toDouble() / (n - (2 * fifteen))).toInt())
}