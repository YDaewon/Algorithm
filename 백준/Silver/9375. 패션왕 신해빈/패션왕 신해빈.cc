#include <iostream>
#include <map>
#include <string>
using namespace std;

int main(){
    int T;
    cin>>T;
    while(T--){
        map<string,int> cloth;
        int n;
        cin>>n;
        string f,s;
        while(n--){
            cin>>f>>s;
            cloth[s]++;
        }
        int ans=1;
        for(auto i : cloth){
            ans*=(i.second+1);
        }
        cout << ans-1<<"\n";
    }
}