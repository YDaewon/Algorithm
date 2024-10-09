import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.*
import java.lang.Math.abs


var n = 0
var m = 0
var b = 0
var max_value = 0
var min_value = 0


fun check(value : Int, ground : Array<Array<Int>>) : Boolean {
    for(i: Int in 0 until n){
        for(j: Int in 0 until m){
            if(ground[i][j] != value) return false
        }
    }
    return true
}

// 블록 빼는게 2초
// 블록 넣는게 1초

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var nmb = br.readLine().split(" ")
    n = nmb[0].toInt()
    m = nmb[1].toInt()
    b = nmb[2].toInt()
    min_value = 257
    var ground =  Array(n) { Array(m) { 0 } }
    for(i: Int in 0 until n){
        var temp = br.readLine().split(" ")
        for(j: Int in  0 until m){
            ground[i][j] = temp[j].toInt()
            max_value = max(max_value, ground[i][j])
            min_value = min(min_value, ground[i][j])
        }
    }
    var ans_time = Int.MAX_VALUE
    var ans_h = 0
    for (g: Int in min_value .. max_value step(1)){
        var temp_b = b
        var time = 0
        for(i: Int in 0 until n){
            for(j: Int in 0 until m) {
                if(ground[i][j] == g) continue
                if (ground[i][j] > g) {
                    time += abs(ground[i][j] - g) * 2
                    temp_b += abs(ground[i][j] - g)
                }
                else {
                    time += abs(ground[i][j] - g)
                    temp_b -= abs(ground[i][j] - g)
                }
            }
        }
        //println("index: " + g +", time: " + time)
        if(temp_b >= 0){
            if(ans_time >= time){
                ans_time = time
                ans_h = g
            }
        }
    }
    print(ans_time.toString() + " " + ans_h.toString())
}