#include <iostream>
#include <vector>
#include <math.h>
typedef long long L;
using namespace std;

vector<L> p;
L s,e;
int visit[10000001];

void prime(){
    for(int i = 2; i<= sqrt(e);i++){
        if(visit[i]==0){
            p.push_back(i);
            for(int j = 2*i;j<=sqrt(e);j+=i) visit[j]=1;
        }
    }
}

int main(){
    cin>>s>>e;
    prime();
    int cnt=0;
    for(L i:p){
        L temp = i;
        while(temp<=e/i){
            temp*=i;
            if(temp>=s)cnt++;
        }
    }
    cout<<cnt;
}