#include <iostream>
#include <map>
using namespace std;

map<int,pair<int,int>> m;
//  학생      추천 등록시간

int find_min_studunt(){
    int idx = 0;
    int s = 9999;
    int last = 9999;
    for(auto i : m){
        if(i.second.first<s){
            idx = i.first;
            s = i.second.first;
            last = i.second.second;
        }
        else if(i.second.first==s&&i.second.second < last){
            idx=i.first;
            s = i. second.first;
            last=i.second.second;
        }
    }
    return idx;
}

int main(){
    int n,k,t;
    cin >> n >> k;
    for(int i=1;i<=k;i++){
        cin>>t;
        if(m.find(t)!=m.end()){
            m[t].first ++;
        }
        else if (m.size() == n){
            m.erase(find_min_studunt());
        }
        m.insert({t,make_pair(1,i)});
    }
    
    for(auto i : m){
        cout << i.first << ' ';
    }
}