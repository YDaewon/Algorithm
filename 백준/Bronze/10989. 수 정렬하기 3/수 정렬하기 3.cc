#include <iostream>
#include <map>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int n;
    cin >> n;
    int t;
    map<int,int> m;
    while(n--){
        cin >> t;
        m[t]++;
    }
    for(int i = 1; i <= 10000; i++){
        while(m[i]--){
            cout << i << "\n";
        }
    }
}