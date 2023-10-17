#include <iostream>
#include <vector>
#include <stack>
using namespace std;
int head_y[4] = { -1,1,0,0 };
int head_x[4] = { 0,0,-1,1 };
int row, col;
vector<vector<int>> board;
vector<vector<int>> visit;
int max_cnt = 0;
int paint = 0;

void dfs(int y, int x) {
    int cnt = 0;
    stack<pair<int, int>> s;
    s.push({ y,x });
    while (!s.empty()) {
        int ty = s.top().first;
        int tx = s.top().second;
        s.pop();
        for (int i = 0; i < 4; i++) {
            int py = ty + head_y[i];
            int px = tx + head_x[i];
            if (px < 0 || px >= row || py < 0 || py >= col) continue;
            if (visit[py][px] == 0 && board[py][px] == 1) {
                visit[py][px] = 1;
                s.push({ py,px });
            }
        }
        cnt++;
    }
    if (max_cnt < cnt) max_cnt = cnt;
}

int main() {
    int t;
    cin >> col >> row;
    for (int i = 0; i < col;i++) {
        vector<int> temp1;
        vector<int> temp2;
        for (int j = 0; j < row;j++) {
            cin >> t;
            temp1.push_back(t);
            temp2.push_back(0);
        }
        board.push_back(temp1);
        visit.push_back(temp2);
    }
    for (int i = 0; i < col;i++) {
        for (int j = 0; j < row;j++) {
            if (visit[i][j] == 0 && board[i][j] == 1) {
                visit[i][j] = 1;
                dfs(i, j);
                paint++;
            }
        }
    }
    cout << paint << endl;
    cout << max_cnt << endl;
}