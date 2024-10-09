#include <iostream>
#include <string>
#include <math.h>
using namespace std;

void hanoi(int n, int s, int m, int e){
    if(n==1){
        cout << s << " " << e << "\n";
        return;
    }
    else{
        hanoi(n-1,s,e,m);
        cout << s << " " << e << "\n";
        hanoi(n-1,m,s,e);
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    int n;
    cin >> n;
    string a = to_string(pow(2,n));
    a= a.substr(0,a.find("."));
    a[a.length()-1] -= 1;
    cout << a << "\n";
    if( n<=20) hanoi(n,1,2,3);
}