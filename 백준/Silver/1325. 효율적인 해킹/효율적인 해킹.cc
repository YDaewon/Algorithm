#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
vector<vector<int>> com(10001);
bool v[10001];

int bfs(int x){
    int count = 0;
    queue<int> q;    
    fill_n(v,10001,true);
    v[x] = false;
    q.push(x);
    while(!q.empty()){
        int t = q.front();
        q.pop();
        for(int i : com[t]){
            if(v[i]){
                v[i] = false;
                q.push(i);
                count++;
            }
        }
    }
    return count;
}

int main(){
    int n,m,a,b;
    cin >> n >>m;
    for(int i=1;i<=m;i++){
        cin >>a>>b;
        com[b].push_back(a);
    }
    int result =0;
    int r[10001];
    for(int i=1;i<=n;i++){
        int t = bfs(i);
        r[i] = t;
        if(result < t){
           result = t;
        }                   
    }
    for(int i=1;i<=n;i++){
        if(r[i] == result)
            cout << i << " ";
    }
}