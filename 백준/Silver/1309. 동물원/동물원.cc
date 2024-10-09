#include <iostream>
#include <vector>
using namespace std;

vector<int> zz={1,1};
vector<int> zo={0,1};
vector<int> oz={0,1};

void dp(int n){
    for(int i=2;i<=n+1;i++){
        int t = i-1;
        zz.push_back((zz[t]+zo[t]+oz[t])%9901);
        oz.push_back((zz[t]+zo[t])%9901);
        zo.push_back((zz[t]+oz[t])%9901);
    }
}

int main(){
    int n;
    cin>>n;
    dp(n);
    cout<< zz[n+1];
}