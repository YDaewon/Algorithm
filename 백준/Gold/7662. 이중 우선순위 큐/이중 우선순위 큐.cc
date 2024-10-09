#include <iostream>
#include <set>
using namespace std;

int main(){
    int t,n,num;
    char line;
    cin>>t;
    while(t--){
        multiset<int> s;
        cin>>n;
        while(n--){
            cin>>line>>num;
            if(line=='I') s.insert(num);
            else{
                if(!s.empty()){
                    if(num==-1)s.erase(s.begin());
                    else s.erase(--s.end());
                }
            }
        }
        if(s.empty()) cout << "EMPTY\n";
        else cout << *(--s.end()) << " " << *s.begin()<<"\n";
    }
}