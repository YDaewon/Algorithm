#include <iostream>
#include <cmath>
using namespace std;
typedef long double L;

struct Point{
     L x,y;
};

int n;
L answer=0;
Point p[10001];

void input(){
    cin>>n;
    for(int i = 0;i<n;i++){
        cin>>p[i].x>>p[i].y;
    }
}

L ccw(Point p1, Point p2, Point p3){
    L a = ((p2.x-p1.x)*(p3.y-p1.y))-((p2.y-p1.y)*(p3.x-p1.x));
    return a;
}

void sol(){
    for(int i=1;i<n-1;i++){
        L temp = ccw(p[0],p[i],p[i+1]);
        answer+=(temp/2);
    }
    cout<<fixed;
    cout.precision(1);
    cout<<abs(answer);
}

int main(){
    input();
    sol();
}
