#include <iostream>
using namespace std;
int dp[20];

int main(){
    dp[0]=0;
    dp[1]=1;
    dp[2]=2;
    dp[3]=4;
    for(int i=4;i<=11;i++){
        dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
    }
    int n,t;
    cin >> t;
    while(t--){
        cin>>n;
        cout<<dp[n]<<endl;
    }
}        
    