#include <iostream>
#include <algorithm>
#include <math.h>
using namespace std;

int gcd(int x,int y){
    if(x == 0 || y == 0){
        if(x == 0 && y == 0) return 1;
        else return max(x,y);
    }
    int t1,t2,n;
    t1 = max(x,y);
    t2 = min(x,y);
    while(t2 != 0){
        n = t1%t2;
        t1=t2;
        t2=n;
    }
    return t1;
}

int length(int sx,int sy, int ex, int ey){
    return pow(ex-sx,2) + pow(ey-sy,2);
}

int main(){
    int sx,sy,ex,ey,dx,dy;
    cin>>ex>>ey;
    cin>>sx>>sy>>dx>>dy;
    int g = gcd(dx,dy);
    dx/=g;
    dy/=g;
    int bef = length(sx,sy,ex,ey);
    int bx=sx;
    int by=sy;
    while(1){
        sx+=dx;
        sy+=dy;
        int cur=length(sx,sy,ex,ey);
        if(bef > cur){
            bef = cur;
            bx = sx;
            by=sy;
        }
        else
            break;
    }
    cout << bx<<" "<<by;
}