#include <iostream>
#include <queue>
using namespace std;

int main(){
    priority_queue<int,vector<int>,greater<int>> pq;
    int n,t;
    cin>>n;
    for(int i = 0;i<n;i++){
        cin>>t;
        pq.push(t);
    }
    int result =0;
    int time[1001];
    for(int i=0;i<n;i++){
        time[i]=pq.top();
        if(i!=0)time[i]+=time[i-1];
        pq.pop();
        result+=time[i];
    }
    cout<<result;
}