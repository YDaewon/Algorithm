#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cmath>
#define pr pair<double,int>
using namespace std;

struct star{
    double x,y;
};

int n;
vector<star> s;
int visit[101];

double get_cost(star a, star b){
    return sqrt(pow(a.y-b.y,2)+pow(a.x-b.x,2));
}

void input(){
    cin >> n;
    for(int i = 0;i<n;i++){
        star t;
        cin>>t.x>>t.y;
        s.push_back(t);
    }
}

void sol(){
    priority_queue<pr, vector<pr>, greater<pr>> pq; //first: cost, second: next_node_idx
    double ans=0;
    pq.push({0,0});
    while(!pq.empty()){
        double cost=pq.top().first;        
        int cur=pq.top().second;
        pq.pop();
        if(visit[cur]) continue;
        visit[cur]=1;
        ans+=cost;
        for(int i=0;i<n;i++){
            if(visit[i]) continue;
            pq.push({get_cost(s[cur],s[i]), i});
        }
    }
    cout<<fixed;
    cout.precision(2);
    cout << ans;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    input();
    sol();
}