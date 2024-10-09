#include <iostream>
#include <map>
typedef long long L;
#define MOD 1000000007
using namespace std;

L num;
map<L,L> m;

void input(){
    cin>>num;
    m[0]=0;m[1]=1;m[2]=1;
}

L sol(L n){
    if(m[n]) return m[n];
    L k = (n%2)?(n+1)/2:n/2;
    L t1 = sol(k);
    L t2 = sol(k-1);
    if(n%2)m[n]=(((t1*t1)%MOD)+((t2*t2)%MOD))%MOD;
    else m[n]=(t1*(2*t2+t1))%MOD;
    return m[n];
}

int main(){
    input();
    cout<<sol(num);
}