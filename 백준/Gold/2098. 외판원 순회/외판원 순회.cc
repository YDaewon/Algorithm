#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;
const int MAX = 987654321;;
int n;
int city[20][20];
int dp[65537][20];


void input() {
    cin >> n;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            cin >> city[i][j];
        }
    }
}


int sol(int now, int vst) {
    if (vst == (1 << n) - 1) {
        if (city[now][0] != 0)
            return city[now][0];
        else return MAX;
    }
    if (dp[vst][now] != -1) return dp[vst][now];
    dp[vst][now] = MAX;
    for (int i = 0; i < n; i++) {
        if ((vst & (1 << i)) == 0 && city[now][i] > 0) {
            int next = vst | (1 << i);
            int t = sol(i, next) + city[now][i];
            dp[vst][now] = min(dp[vst][now], t);
        }
    }
    return dp[vst][now];

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);cout.tie(0);
    input();
    memset(dp, -1, sizeof(dp));
    cout << sol(0,1);
}