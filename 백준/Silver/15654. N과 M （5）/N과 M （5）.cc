#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n,m;
vector<int> num, ans;
int visit[10000];

void sol(int d){
    if(d==m){
        for(int i : ans)
            cout << i<< " ";
        cout << "\n";
        return;
    }
    for(int i= 0; i<n;i++){
        if(!visit[i]){
            visit[i]=1;
            ans.push_back(num[i]);
            sol(d+1);
            ans.pop_back();
            visit[i]=0;
        }
    }
}

int main(){
    cin>> n>>m;
    int t;
    for(int i=0;i<n;i++){
        cin>>t;
        num.push_back(t);
    }
    sort(num.begin(),num.end());
    sol(0);
}