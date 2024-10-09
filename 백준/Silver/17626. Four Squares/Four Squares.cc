#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int dp[50001]={0,1};
    int n;
    cin>>n;
    for(int i=2;i<=n;i++){
        int temp=9999999;
        for(int j=1;j*j<=i;j++){
            int t=i-(j*j);
            temp=min(dp[t],temp);
        }
        dp[i]=temp+1;
    }
    cout << dp[n];
}