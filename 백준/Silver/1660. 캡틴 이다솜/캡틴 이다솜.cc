#include <iostream>
#include <algorithm>
using namespace std;

int triangle[200];
int total[200];
int n,t;
int dp[300001];

void init(){
    triangle[0] = 0;
    total[0] = 0;
    for(int j = 0;j<=n;j++)
        dp[j] = j;
    int i = 1;
    while(1){
        triangle[i] = triangle[i-1]+i;
        total[i] = triangle[i]+total[i-1];
        if(total[i]>n) break;
        dp[total[i]] = 1;
        t=i;
        i++;
    }
}

void sol(){
    int r = 0;
    for(int i = 2; i <= t;i++){
        for(int j = total[i];j<=n;j++){
            dp[j] = min(dp[j-total[i]]+1,dp[j]);
        }
    }
}

int main(){
    cin>> n;
    init();
    sol();
    cout << dp[n];
}
   
                           