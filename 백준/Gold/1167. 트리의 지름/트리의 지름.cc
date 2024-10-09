#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <algorithm>
using namespace std;

int n,maxidx=0, result=0;
vector<vector<pair<int,int>>> tree;

void dfs(int num){
    vector<int> visit(n+1);
    visit[num]=1;
    stack<pair<int,int>> s;
    s.push({num,0});
    while(!s.empty()){
        int d = s.top().first;
        int v = s.top().second;
        s.pop();
        for(auto i : tree[d]){
            if(visit[i.first]==0){
                s.push({i.first,i.second+v});
                visit[i.first]=1;
            }
        }
        if(v>result){
            result=v;
            maxidx=d;
        }
    }
}

void Input(){
    int num,dst,val;
    cin>>n;
    tree.resize(n+1);
    for(int i = 0;i<n;i++){
        cin>>num;
        vector<pair<int,int>> temp;
        while(1){
            cin>>dst;
            if(dst==-1) break;
            cin>>val;
            temp.push_back({dst,val});
        }
        tree[num]=temp;
    }
}

int main(){
    Input();
    dfs(1);
    dfs(maxidx);
    cout << result;
}