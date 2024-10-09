#include <iostream>
#include <map>
#include <algorithm>
using namespace std;

struct Point{
    long long x, y;
    bool operator < (Point &p){
        if(x==p.x)
            return y < p.y;
        return x < p.x;
    }
    bool operator <= (Point &p){
        if(x==p.x)
            return y <= p.y;
        return x <= p.x;
    }
};

struct Line {
    Point p1,p2;
};

int n;
Line line[3001];
int uni[3001];
map<int,int> m;

void input(){
    cin >> n;
    for(int i = 1;i<=n;i++){
        Point p1,p2;
        cin>> p1.x>>p1.y>>p2.x>>p2.y;
        line[i]={p1,p2};
        uni[i]=i;
    }
}

int ccw(Point p1, Point p2, Point p3){
    long long ans = ((p2.x-p1.x)*(p3.y-p1.y))-((p2.y-p1.y)*(p3.x-p1.x));
    if(ans>0) return 1;
    else if(ans==0) return 0;
    else return -1;
}

int find(int num){
    if(num==uni[num]) return num;
    return find(uni[num]);
}

bool cycle(int n1, int n2){
    n1=find(n1); n2=find(n2);
    if(n1==n2) return true;
    else return false;
}

void union_find(int n1, int n2){
    n1=find(n1); n2=find(n2);
    if(n1< n2) uni[n2]=n1;
    else uni[n1]=n2;
}

bool check(Line l1, Line l2){
    Point a,b,c,d;
    a=l1.p1; b=l1.p2; c=l2.p1; d=l2.p2;
    int ab = ccw(a,b,c)*ccw(a,b,d);
    int cd = ccw(c,d,a)*ccw(c,d,b);
    if(ab==0&&cd==0){
        if(b<a) swap(a,b);
        if(d<c) swap(c,d);
        return c <= b && a <= d;
    }
    return ab <= 0 && cd <= 0;
}

void sol(){
    for(int i = 1; i<=n;i++){
        for(int j = 1; j <i;j++){
            if(check(line[i],line[j])){
                if(!cycle(i,j)){
                    union_find(i,j);
                }
            }
        }
    }
    for(int i = 1;i<=n;i++){
        m[find(i)]++;
    }
    int sz = m.size();
    int ans = 0;
    for(auto i : m){
        ans = max(ans, i.second);
    }
    cout << sz << "\n";
    cout << ans;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    input();
    sol();
}
    