#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n,m,tr,answer;
vector<int> uni;
vector<int> truth;
vector<vector<int>> party;

int find(int t){
    if(uni[t]==t)return t;
    return uni[t]=find(uni[t]);
}

void merge(int x, int y){
    x=find(x);
    y=find(y);
    if(x==y)return;
    uni[y]=x;
}

void input(){
    cin>>n>>m>>tr;
    uni.resize(n+1);
    party.resize(m);
    int num,temp;
    for(int i =0;i<=n;i++){
        uni[i]=i;
    }
    truth.resize(tr);
    for(int i=0;i<tr;i++){
        cin>>truth[i];
    }
    for(int i = 0;i<m;i++){
        cin>>num;
        for(int j=0;j<num;j++){
            cin>>temp;
            party[i].push_back(temp);
        }
        sort(party[i].begin(),party[i].end());
    }
}

int main(){
    input();
    answer=m;
    for(int i = 0;i<m;i++){
        int base=party[i][0];
        for(int j:party[i])
            merge(base,j);
    }
    for(int i = 0;i<m;i++){
        bool flag = true;
        for(int j : party[i]){
            if(!flag) break;
            for(int k : truth){
                if(find(j)==find(k)){
                    flag=false;
                    break;
                }
            }
        }
        if(!flag) answer--;
    }
    cout << answer;
}