#include <iostream>
#include <queue>
using namespace std;

struct cmp{
    bool operator()(int first, int second){
        if(abs(first)>abs(second)) return true;
        else if(abs(first) == abs(second))
            if(first>second) return true;
        return false;
    }
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    priority_queue<int,vector<int>,cmp> pq;
    int n,t;
    cin>>n;
    while(n--){
        cin>>t;
        if(t) pq.push(t);
        else{
            if(pq.empty()) cout << 0 << "\n";
            else{
                cout << pq.top() << "\n";
                pq.pop();
            }
        }
    }
}