#include <iostream>
#include <queue>
using namespace std;

int main(){
    priority_queue<int> coin;
    int n,m,t;
    cin>>n>>m;
    for(int i=0; i< n;i++){
        cin>>t;
        coin.push(t);
    }
    int count=0;
    while(m>0){
        int money=coin.top();
        while(m-money>=0){
            m-=money;
            count++;
        }
        coin.pop();
    }
    cout<<count;
}