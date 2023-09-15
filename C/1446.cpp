#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
const int INF = 100000000;

vector<pair<int, int>> graph[10001];
vector<int> dp(10001, INF);
int n, d;

void sol(int s) {
    dp[0] = 0;
    for (int i = 1; i <= d; i++) {
        if (graph[i].size() == 0) dp[i] = dp[i - 1] + 1;
        else {
            for (auto p : graph[i])
                dp[i] = min({ dp[i], dp[i - 1] + 1, dp[p.first] + p.second });
        }
    }
}

int main() {
    cin >> n >> d;
    int f, s, c;
    for (int i = 0; i < n;i++) {
        cin >> f >> s >> c;
        graph[s].emplace_back(f, c);
    }
    sol(0);
    cout << dp[d];
}