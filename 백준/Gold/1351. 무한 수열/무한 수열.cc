#include <iostream>
#include <map>
typedef long long L;
using namespace std;

map<L,L> num;
L n,p,q;

L sol(L t){
    if(t==0) return 1;
    else{
        if(num.find(t) != num.end()) return num[t];
        L temp = sol(t/p)+sol(t/q);
        num[t] = temp;
        return num[t];
    }
}

int main(){
    cin>>n>>p>>q;
    num[0]=1;
    cout<<sol(n);
}