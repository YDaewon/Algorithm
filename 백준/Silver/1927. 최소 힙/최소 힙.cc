#include <iostream>
#include <queue>
using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    priority_queue<int, vector<int>, greater<int>> q;
    int n;
    cin >> n;
    for(int i=0; i <n; i++){
        int num;
        cin >> num;
        if (num != 0)
            q.push(num);
        else{
            if(!q.empty()){
                cout << q.top() << '\n';
                q.pop();
            }
            else
                cout << 0 << '\n';
        }
    }
}    

                
            
    