#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n, k;
vector<int> num;
int dp[50001];
int sol() {
    int idx = 1;
    while (1) {
        for (int i = 0; i < idx;i++) {
            dp[idx] = min(dp[idx], dp[idx - i] + dp[i]);
        }
        if (dp[idx] > k) break;
        idx++;
    }
    return idx;
}

int main() {
    cin >> n;
    int t;
    dp[0] = 0;
    for (int i = 0;i < n;i++) {
        cin >> t;
        num.push_back(t);
        dp[t] = 1;
    }
    cin >> k;
    for (int i = 0; i <= t * k;i++) dp[i] = i;
    for (int i : num) dp[i] = 1;
    int result = sol();
    if (result % 2)
        cout << "jjaksoon win at " << result;
    else
        cout << "holsoon win at " << result;
}


