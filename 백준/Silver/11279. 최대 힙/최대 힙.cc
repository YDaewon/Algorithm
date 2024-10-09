#include <iostream>
#include <queue>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    priority_queue<int> heap;
    int n,t;
    cin>>n;
    for(int i=0; i< n;i++){
        cin>>t;
        if(t)
            heap.push(t);
        else{
            if(heap.empty())
                cout << 0<<"\n";
            else{
                cout<<heap.top()<<"\n";
                heap.pop();
            }
        }
    }    
}