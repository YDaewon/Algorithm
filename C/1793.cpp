#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

string dp[251];

string big_sum(string a, string b) {
    string sum = "";
    int a_idx = a.size() - 1;
    int b_idx = b.size() - 1;
    int temp = 0;
    while (a_idx >= 0 || b_idx >= 0 || temp) {
        if (a_idx >= 0)
            temp += a[a_idx--] - '0';
        if (b_idx >= 0)
            temp += b[b_idx--] - '0';
        sum.push_back(temp % 10 + '0');
        temp /= 10;
    }
    reverse(sum.begin(), sum.end());
    return sum;
}

void DP() {
    for (int i = 4; i <= 250; i++) {
        dp[i] = big_sum(dp[i - 1], big_sum(dp[i - 2], dp[i - 2]));
        //cout << "DP[" << i << "] = " << dp[i] << endl;
    }
}

int main() {
    int n;
    dp[0] = '1';
    dp[1] = '1';
    dp[2] = '3';
    dp[3] = '5';
    DP();
    while (cin >> n)
        cout << dp[n] << endl;
}
