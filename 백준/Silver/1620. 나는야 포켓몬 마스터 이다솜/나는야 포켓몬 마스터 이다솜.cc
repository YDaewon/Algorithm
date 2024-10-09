#include <iostream>
#include <map>
#include <string>
using namespace std;

map<int,string> dic;
map<string,int> dic2;

int main(){
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    int n,m;
    cin >> n>>m;
    string t;
    for(int i = 1; i<= n;i++){
        cin>>t;
        dic.insert({i,t});
        dic2.insert({t,i});
    }
    for(int i = 0;i<m;i++){
        cin>>t;
        if(t[0]>='A'&&t[0]<='Z'){
            cout<<dic2[t]<<'\n';
        }
        else{
            cout<<dic[stoi(t)]<<'\n';
        }
    }
}
        