#include <iostream>
#include <stack>
#include <algorithm>
using namespace std;

int head_x[4] = { 0,0,-1,1 };
int head_y[4] = { -1,1,0,0 };
int visit[101][101];
int board[101][101];
int n, m, k;
int result = 0;

void dfs(int y, int x) {
    int cnt = 0;
    stack<pair<int, int>> s;
    s.push({ y,x });
    while (!s.empty()) {
        int ty = s.top().first;
        int tx = s.top().second;
        s.pop();
        for (int i = 0;i < 4;i++) {
            int py = ty + head_y[i];
            int px = tx + head_x[i];
            if (py < 1 || py>n || px<1 || px>m) continue;
            if (visit[py][px] == 0 && board[py][px] == 1) {
                visit[py][px] = 1;
                s.push({ py,px });
            }
        }
        cnt++;
    }
    result = max(result, cnt);
}

int main() {
    int x, y;
    cin >> n >> m >> k;
    for (int i = 0;i < k;i++) {
        cin >> y >> x;
        board[y][x] = 1;
    }
    for (int i = 1; i <= n;i++) {
        for (int j = 1; j <= m;j++) {
            if (visit[i][j] == 0 && board[i][j] == 1) {
                visit[i][j] = 1;
                dfs(i, j);
            }
        }
    }
    cout << result;
}