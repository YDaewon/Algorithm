#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int n;
vector<vector<int>> tree;
vector<int> visit;

void input(){
    cin>>n;
    tree.resize(n+1);
    visit.resize(n+1);
    int f,s;
    for(int i = 1;i<n;i++){
        cin>>f>>s;
        tree[f].push_back(s);
        tree[s].push_back(f);
    }
}

void dfs(){
    stack<int> s;
    for(int i : tree[1]){
        s.push(i);
        visit[i]=1;
    }
    visit[1]=1;
    while(!s.empty()){
        int child=s.top();
        s.pop();
        for(int i : tree[child]){
            if(!visit[i]){
                s.push(i);
                visit[i]=child;
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);cout.tie(0);
    input();
    dfs();
    for(int i = 2;i<=n;i++){
        cout << visit[i]<<"\n";
    }
}