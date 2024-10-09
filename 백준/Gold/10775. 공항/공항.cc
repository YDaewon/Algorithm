#include <iostream>
using namespace std;

int g,p;
int d[100001];

int find(int a){
    if(a==d[a]) return a;
    else return d[a]=find(d[a]);
}

void uni(int a, int b){
    a=find(a);
    b=find(b);
    if(a>b) d[a]=b;
    else d[b]=a;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin>>g>>p;
    int t, cnt = 0;
    for(int i = 0; i<=g;i++) d[i]=i;
    while(p--){
        cin>>t;
        t=find(t);
        if(t==0) break;
        uni(t,t-1);
        cnt++;
    }
    cout << cnt;
}
    