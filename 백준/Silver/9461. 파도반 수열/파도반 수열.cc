#include <iostream>
using namespace std;

long long num[101]={0,1,1,1,2,2};

int main(){
    for(int i = 6;i<=100;i++){
        num[i]=num[i-1]+num[i-5];
    }
    int T,n;
    cin>>T;
    while(T--){
        cin>>n;
        cout<<num[n]<<endl;
    }
}