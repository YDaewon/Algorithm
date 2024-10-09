#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n,m;
vector<int> num, ans;
vector<vector<int>> save;
int visit[10];

bool check(){
    for(vector<int> i : save)
        if (i==ans) return false;
    return true;
}

void sol(int d){
    if(d==m){
        for(int i : ans)
            cout << i<< " ";
        cout << "\n";
        return;
    }
    int c=0;
    for(int i= 0; i<n;i++){
        if(!visit[i]&&c!=num[i]){
            c=num[i];
            visit[i]=1;
            ans.push_back(c);
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