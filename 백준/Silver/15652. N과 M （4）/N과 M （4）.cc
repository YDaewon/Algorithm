#include <iostream>
#include <vector>
using namespace std;

int n,m;
vector<int> num;

void sol(int d, int t){
    if(d==m){
        for(int i : num)
            cout << i<< " ";
        cout << "\n";
        return;
    }
    for(int i= t; i<=n;i++){
        num.push_back(i);
        sol(d+1,i);
        num.pop_back();
    }
}

int main(){
    cin>> n>>m;
    sol(0,1);
}