#include <iostream>
#include <vector>
using namespace std;

vector<int> node[51];
int visit[51];
int n,k,root=0;
int leaf=0;

void dfs(int num){
    if(visit[num]==1){
        return;
    }
    visit[num]=1;
    bool temp = true;
    for(int i : node[num]){
            if(visit[i]==0){
                dfs(i);
                temp = false;
            }
    }
    if(temp) leaf++;
}

int main(){
    cin>>n;
    int t;
    for(int i =0;i<n;i++){
        cin>>t;
        if(t==-1)root=i;
        else node[t].push_back(i);
    }
    cin>>k;
    visit[k] = 1;
    dfs(root);
    cout<<leaf;
}