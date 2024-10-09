#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<pair<int,int>> work;
int n;

bool compare(pair<int,int> & a, pair<int,int> & b){
    return a.first > b.first;
}

int main(){
    cin >> n;
    work.resize(n);
    for(int i = 0;i<n;i++){
        cin >> work[i].second >> work[i].first;
    }
    sort(work.begin(),work.end(), compare);
    int time = work[0].first-work[0].second;
    for(int i = 1; i< n;i++){
        if(time <= work[i].first)
            time -= work[i].second;
        else
            time = work[i].first-work[i].second;
    }
    if(time>=0) cout << time;
    else cout << -1;
}