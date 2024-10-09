#include <iostream>
#include <map>
#include <string>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n,m;
    map<string,string> note;
    string f,s;
    cin>>n>>m;
    while(n--){
        cin>>f>>s;
        note[f]=s;
    }
    while(m--){
        cin>>f;
        cout<<note[f]<<"\n";
    }
}
    