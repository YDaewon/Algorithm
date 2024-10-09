#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int main(){
    int n;
    cin >> n;
    vector<int> dp(n+1);
    int root_i;
    for(int i= 0; i <=n; i++){
        dp[i] = i;
        root_i = sqrt(i);
        for (int j=1; j<=root_i; j++){
            dp[i] = min(dp[i], dp[i-j*j] + 1);
        }
    }
    cout << dp[n] << endl;
}