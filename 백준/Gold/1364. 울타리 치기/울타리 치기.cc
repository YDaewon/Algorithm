#include <iostream>
using namespace std;

int main(){
    int n;
    cin >> n;
    long long r = 0;
    for(int i = 0;i<=n;i++){
        r += i/6+1;
        if(i%6==1)r--;
    }    
    cout << r;
}