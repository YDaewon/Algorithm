#include <iostream>
#include <algorithm>
using namespace std;

int n;
vector<int> max_dp(3);
vector<int> min_dp(3);

void sol(){
    cin>>n;
    int a,b,c;
    vector<int> t;
    for(int i = 1;i<=n;i++){
        cin>>a>>b>>c;
        t=max_dp;
        max_dp[0]=max(t[0],t[1])+a;
        max_dp[1]=max({t[0],t[1],t[2]})+b;
        max_dp[2]=max(t[1],t[2])+c;
        
        t=min_dp;
        min_dp[0]=min(t[0],t[1])+a;
        min_dp[1]=min({t[0],t[1],t[2]})+b;
        min_dp[2]=min(t[1],t[2])+c;
    }
    cout<<max({max_dp[0],max_dp[1],max_dp[2]}) << " " << min({min_dp[0],min_dp[1],min_dp[2]});
}

int main(){
   sol();
}

        
        
                       
                       
        