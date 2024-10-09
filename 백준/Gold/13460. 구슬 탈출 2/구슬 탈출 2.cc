#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <queue>
#include <bitset>

struct ball {
    int y;
    int x;
    int cnt;
    int cost;
};

using namespace std;
const int MAX = 999999;
int n, m, ans = -1;
int board[11][11];
int dy[4] = { -1,1,0,0 };
int dx[4] = { 0,0,-1,1 };
bool r_flag, b_flag;
queue<ball> red;
queue<ball> blue;

void input() {
    cin >> n >> m;
    char t;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++){
            cin >> t;
            if (t == '#') board[i][j] = -1;
            else if (t == 'B') {
                blue.push({ i,j, 0 });
            }
            else if (t == 'R') {
                red.push({ i,j, 0 });
            }
            else if (t == 'O') board[i][j] = 1;
        }
    }
}

ball go(int d, ball b) {
    int y = b.y;
    int x = b.x;
    int cost = 0;
    while (board[y][x] != -1) {
        y += dy[d];
        x += dx[d];
        cost++;
        if (board[y][x] == 1) {
            b.x = x;
            b.y = y;
            b.cost = cost;
            b.cnt += 1;
            return b;
        }
    }
    b.x = x - dx[d];
    b.y = y - dy[d];
    b.cost = cost;
    b.cnt += 1;
    return b;
}

void sol() {
     while (red.front().cnt < 10 || blue.front().cnt < 10) {
         ball Rcur = red.front();
         ball Bcur = blue.front();
         //cout << "Rcur: " << Rcur.y << ", " << Rcur.x << ", " << Rcur.cnt << endl;
         //cout << "Bcur: " << Bcur.y << ", " << Bcur.x << ", " << Bcur.cnt << endl;
         red.pop();
         blue.pop();
         for (int i = 0; i < 4; i++){
             ball Rnxt = go(i, Rcur);
             ball Bnxt = go(i, Bcur);
             if (board[Bnxt.y][Bnxt.x] == 1) {
                 continue;
             }

             if (board[Rnxt.y][Rnxt.x] == 1) {
                 ans = Rnxt.cnt;
                 return;
             }

             if (Rnxt.x == Bnxt.x && Rnxt.y == Bnxt.y) {
                 if (Rnxt.cost < Bnxt.cost) {
                     Bnxt.x -= dx[i];
                     Bnxt.y -= dy[i];
                 }
                 else {
                     Rnxt.x -= dx[i];
                     Rnxt.y -= dy[i];
                 }
             }
             red.push(Rnxt);
             blue.push(Bnxt);
         }
     }
     return;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);cout.tie(0);
    input();
    sol();
    cout << ans;
}