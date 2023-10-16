#include <iostream>
typedef long long L;
using namespace std;

int n;
L route[101][101];
int board[101][101];

void dp() {
    for (int y = 1; y <= n;y++) {
        for (int x = 1; x <= n;x++) {
            int m = board[y][x];
            if (m == 0) break;
            else if (route[y][x] == 0) continue;
            if (x + m <= n) {
                route[y][x + m] += route[y][x];
            }
            if (y + m <= n) {
                route[y + m][x] += route[y][x];
            }
        }
    }
}

int main() {
    int t;
    cin >> n;
    for (int i = 1;i <= n;i++) {
        for (int j = 1;j <= n;j++) {
            cin >> t;
            board[i][j] = t;
        }
    }
    route[1][1] = 1;
    dp();
    cout << route[n][n];
}


