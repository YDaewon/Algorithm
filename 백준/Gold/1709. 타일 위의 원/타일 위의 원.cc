#include <iostream>
#include <cmath>
using namespace std;
double n,r_pow,i,j,px,py;
int count=0;
void circle(double x, double y){
    double sum = pow(x+1,2)+pow(y,2);
    if(sum<=r_pow) px++;
    if(sum>=r_pow) py--;
    
}
int main(){
    cin >> n;
    n /=2;
    r_pow = pow(n, 2);
    px=0;
    py=n-1;
    while(px<n&&py>-1){
      circle(px,py);
      count++;
    }
    cout<<count*4;
}