#include <iostream>
typedef long long L;
using namespace std;

L a,b;
L dp[55];

L sol(L n){
    L ans = n & 1;
    L i = 54;
    while(i>0){
        if(n&(1LL<<i)){
            ans+=dp[i-1]+n-(1LL<<i)+1;
            n-= 1LL<<i;
        }
        i--;
    }
    return ans;
}

int main(){
    cin>> a >> b;
    dp[0]=1;
    for(int i= 1;i<55;i++) dp[i]=2*dp[i-1]+(1LL<<i);
    cout << sol(b)-sol(a-1);
}
        
