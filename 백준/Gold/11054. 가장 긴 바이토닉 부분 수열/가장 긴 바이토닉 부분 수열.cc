#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n,ans=0;
    int arr[1001],up_dp[1001],down_dp[1001];
    cin>>n;
    for(int i=1;i<=n;i++) cin>>arr[i];
    for(int i=1;i<=n;i++){
        int t=0;
        for(int j=1;j<i;j++){
            if(arr[i]>arr[j]) t=max(t,up_dp[j]);
        }
        up_dp[i]=t+1;
    }
    for(int i=n;i>=1;i--){
        int t=0;
        for(int j=n;j>i;j--){
            if(arr[i]>arr[j]) t=max(t,down_dp[j]);
        }
        down_dp[i]=t+1;
    }
    for(int i=1;i<=n;i++) ans=max(ans,up_dp[i]+down_dp[i]);
    cout << ans-1;
}