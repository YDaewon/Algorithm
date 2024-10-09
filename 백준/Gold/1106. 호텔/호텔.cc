#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, c, dp[100001]; // idx: 비용, val: 고객 
vector<pair<int,int>> town;

void search(){
    for(int i =1;i<=100000;i++){
        for(int j=0;j<n;j++){
            if(i-town[j].first >=0){
                dp[i]=max(dp[i],dp[i-town[j].first]+town[j].second);
            }
        }
    }
}

int main(){
    cin >>c>>n;
    for(int i=0;i<n;i++){
        int cost,val;
        cin>>cost>>val;
        town.push_back({cost,val}); 
    }
    search();
    for(int i=1;i<=100000;i++){
        if(dp[i]>=c){
            cout<<i;
            break;
        }
    }
}
            
                          