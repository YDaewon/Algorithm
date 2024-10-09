#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cmath>
#define pii pair<int,int>
#define f first
#define s second
using namespace std;

int n;
vector<pii> X;
vector<pii> Y;
vector<pii> Z;
vector<pair<int,pii>> tunnel;
int parent[100001];

int find(int a){
    if(a==parent[a]) return a;
    return find(parent[a]);
}

void union_find(int a, int b){
    a=find(a);
    b=find(b);
    if(a<=b) parent[b]=a;
    else parent[a]=b;
}

void input(){
    cin >> n;
    for(int i = 0;i<n;i++){
        int x,y,z;
        cin>>x>>y>>z;
        X.push_back({x,i});
        Y.push_back({y,i});
        Z.push_back({z,i});
        parent[i]=i;
    }
    sort(X.begin(),X.end());
    sort(Y.begin(),Y.end());
    sort(Z.begin(),Z.end());
    for(int i=0;i<n-1;i++){
        tunnel.push_back({X[i+1].f-X[i].f, {X[i+1].s, X[i].s}});
        tunnel.push_back({Y[i+1].f-Y[i].f, {Y[i+1].s, Y[i].s}});
        tunnel.push_back({Z[i+1].f-Z[i].f, {Z[i+1].s, Z[i].s}});
    }
    sort(tunnel.begin(), tunnel.end());
}

void sol(){
    int ans =0;
    for(int i=0;i<tunnel.size();i++){
        int start = tunnel[i].s.s;
        int end = tunnel[i].s.f;
        int cost = tunnel[i].f;
        if(find(start) != find (end)){
            union_find(start,end);
            ans+= cost;
        }
    }
    cout << ans;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    input();
    sol();
}