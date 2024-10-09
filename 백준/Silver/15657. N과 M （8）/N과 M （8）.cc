#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n,m;
vector<int> num, ans;

void sol(int d, int idx){
    if(d==m){
        for(int i : ans)
            cout << i<< " ";
        cout << "\n";
        return;
    }
    for(int i= idx; i<n;i++){
        ans.push_back(num[i]);
        sol(d+1, i);
        ans.pop_back();            
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
    sol(0,0);
}