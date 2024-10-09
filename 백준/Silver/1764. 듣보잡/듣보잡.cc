#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <algorithm>
using namespace std;

map<string,int> a;
vector<string> r;

int main(){
    int n,m;
    cin>>n>>m;
    string t;
    for(int i = 0; i<n;i++){
        cin>>t;
        a.insert({t,i});
    }
    for(int i = 0; i < m;i++){
        cin>>t;
        if(a.find(t)!=a.end())
            r.push_back(t);
    }
    r.erase(unique(r.begin(), r.end()),r.end());
    sort(r.begin(),r.end());
    cout<<r.size()<<endl;
    for(string a :r)
        cout << a<<endl;
}