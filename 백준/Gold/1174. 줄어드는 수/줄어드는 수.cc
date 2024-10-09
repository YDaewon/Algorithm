#include <iostream>
#include <vector>
#include <queue>
#include <string>
typedef long long L;
using namespace std;

int n;
vector<L> result;

void sol(){
    queue<L> q;
    for(int i = 0; i < 10; i++){
        q.push(i);
        result.push_back(i);
    }
    while(!q.empty()){
        L t = q.front();
        q.pop();
        for(int i =0;i<10;i++){
            if(t % 10 >i){
                q.push(t*10 + i);
                result.push_back(t*10 + i);
            }
            else break;
        }
    }
}

int main(){
    cin >> n;
    sol();
    if(n>result.size()) cout << -1;
    else cout << result[n-1];
}