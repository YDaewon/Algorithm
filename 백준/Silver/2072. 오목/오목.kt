import java.io.BufferedReader
import java.io.InputStreamReader

var head_y =  arrayOf(0, 0, -1, 1, -1, 1, -1, 1)
var head_x =  arrayOf(1, -1, 0, 0, -1, 1, 1, -1)

fun bfs (y : Int, x : Int, color: Int, bo : Array<Array<Int>>) : Boolean{
    var cnt = Array(4, { 1 })
    for (d in 0..7) {
        var a = y + head_y[d]
        var b = x + head_x[d]
        while (a >= 0 && a < 20 && b >= 0 && b < 20 && bo[a][b] === color) {
            cnt[d / 2]++
            a += head_y[d]
            b += head_x[d]
        }
    }
    for (i in 0..3) {
        if(cnt[i] == 5) return true
    }
    return false
}


fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    var board = Array(100, { Pair(0,0) } )
    var mapp = Array(25, { Array (25, {0} )} )
    for (i: Int in 0 until n) {
        var t = br.readLine().split(" ")
        board[i] = Pair(t[0].toInt(), t[1].toInt())
    }
    for (i: Int in 0 until n) {
        var color = 2
        if (i % 2 == 0) color = 1
        mapp[board[i].first][board[i].second] = color
        if(bfs(board[i].first, board[i].second, color, mapp)) {
            print(i + 1)
            return
        }
    }
    print(-1)
}

