#include <iostream>
#include <math.h>
using namespace std;

int s,e;

int sol(){
    int d = e-s;
    int r = sqrt(d);
    int temp = r*(r+1);
    int ans = 2 * r;
    if(pow(r,2) == d) ans -= 1;
    else if(d > temp && pow(r,2)<d) ans += 1;
    return ans;
}

int main(){
    int c;
    cin >> c;
    while(c--){
        cin>>s>>e;
        cout << sol()<<endl;
    }
}
