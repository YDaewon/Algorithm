#include <iostream>
#include <algorithm>
using namespace std;

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);
   int dp[1001][3];
   dp[0][0] = 0;
   dp[0][1] = 0;
   dp[0][2] = 0;
   int n;
   cin >> n;
   int rgb[1001][3];
   int ans = 5000000;
   for(int i = 1;i<=n;i++)
        cin >> rgb[i][0] >> rgb[i][1] >> rgb[i][2];
    for(int i = 0; i < 3;i++){ // rgb색
        for(int j = 0; j < 3; j++){
            if(i == j) dp[1][j] = rgb[1][j];
            else dp[1][j] = 9999999;
        }
        for(int j = 2; j <= n; j++){
            for(int k = 0; k < 3; k++){
                dp[j][k] = min(dp[j-1][(k+1)%3], dp[j-1][(k+2) % 3]) + rgb[j][k];
            }
        }

        for (int j = 0; j < 3; j++){
            if(i == j) continue;
            ans = min(ans, dp[n][j]);
        }
        
    }
    cout <<ans;
}