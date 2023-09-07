#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n;
    int dp[1001][3];
    dp[0][0] = 0;
    dp[0][1] = 0;
    dp[0][2] = 0;
    cin >> n;
    int rgb[3];
    for (int i = 1;i <= n;i++) {
        cin >> rgb[0] >> rgb[1] >> rgb[2];
        for (int j = 0;j < 3;j++) {
            dp[i][j] = min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + rgb[j];
        }
    }
    cout << min(dp[n][0], min(dp[n][1], dp[n][2]));
}

