#include <iostream>
using namespace std;
const int mod=1000000000;
int n;
int dp[10][101][1024];

void sol(){
    for(int i=1;i<=9;i++)
        dp[i][1][1<<i]=1;
    for(int len=2;len<=n;len++){
        for(int num=0;num<=9;num++){
            for(int bit=0;bit<1024;bit++){
                if(num==0) dp[num][len][bit|1<<num]+= dp[num+1][len-1][bit]%mod;
                else if(num==9) dp[num][len][bit|1<<num]+=dp[num-1][len-1][bit]%mod;
                else{
                    dp[num][len][bit|1<<num]+= ((dp[num+1][len-1][bit]%mod)+(dp[num-1][len-1][bit]%mod))%mod;
                }
            }
        }
    }
}

int main(){
    cin>>n;
    sol();
    int ans=0;
    for(int i=0;i<10;i++){
        ans+=dp[i][n][1023]%mod,
        ans%=mod;
    }
    cout << ans;
}
        