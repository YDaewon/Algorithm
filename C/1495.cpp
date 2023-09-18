#include <iostream>
#include <algorithm>
using namespace std;

int dp[51][1001];
int vol[51];
int n, s, m;

int sol() {
    for (int i = 1; i <= n;i++) {
        for (int j = 0; j <= m;j++) {
            if (dp[i - 1][j]) {
                if (j + vol[i] <= m)
                    dp[i][j + vol[i]] = 1;
                if (j - vol[i] >= 0)
                    dp[i][j - vol[i]] = 1;
            }
        }
    }

    for (int i = m; i > -1;i--) {
        if (dp[n][i]) {
            cout << i;
            return 0;
        }
    }
    return 1;
}

int main() {
    cin >> n >> s >> m;
    dp[0][s] = 1;
    for (int i = 1;i <= n;i++) {
        cin >> vol[i];
    }
    if (sol()) cout << -1;
}
