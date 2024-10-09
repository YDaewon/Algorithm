#include <iostream>
#include <vector>
using namespace std;

vector<int> tree;

void sol(int s,int e){
    if(s>=e)return;
    if(s==e-1){
        cout<<tree[s]<<"\n";
        return;
    }
    int idx=s+1;
    while(idx<e){
        if(tree[s]<tree[idx]) break;
        idx++;
    }
    sol(s+1,idx);
    sol(idx,e);
    cout<<tree[s]<<"\n";
}

void input(){
    int num=1;
    while(cin>>num){
        tree.push_back(num);
    }
}

int main(){
    input();
    sol(0,tree.size());
}