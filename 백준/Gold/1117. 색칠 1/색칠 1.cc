#include <iostream>
#include <algorithm>
typedef long long L;
using namespace std;

int main(){
    L w,h,f,c,x1,y1,x2,y2;
    cin >> w >> h >> f >> c >> x1 >> y1 >> x2>>y2;
    L result=(x2-x1)*(y2-y1)*(c+1);
    if(f <= w/2){
        if(x1>=f){
            cout<<w*h-result;
        }
        else{
            cout << w*h-(result+(min(x2,f)-x1) * (y2-y1)*(c+1));
        }
    }
    else{
        if(x1>= w - f){
            cout<<w*h-result;
        }
        else{
            cout << w*h-(result+(min(x2, w-f)-x1) * (y2-y1)*(c+1));
        }
    }
}