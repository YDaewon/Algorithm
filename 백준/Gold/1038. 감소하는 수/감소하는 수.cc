#include <iostream>
#include <vector>
#include <queue>
typedef long long L;
using namespace std;

vector<L> arr;

void sol(int num){
    queue<L> q;
    for(int i = 0; i <10;i++){
        q.push(i);
        arr.push_back(i);
    }
    while(!q.empty()){
        L n = q.front();
        int t = n %10;
        q.pop();
        for(int i=0;i<t;i++){
            q.push(n*10+i);
            arr.push_back(n*10+i);
        }
    }
    if(num>arr.size()-1)
        cout<<-1;
    else
        cout<<arr[num];
}

int main(){
    int n;
    cin >> n;
    sol(n);
}
    
        