#include <iostream>
#include <string.h>
using namespace std;

string str;
string bomb;
string q;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin>>str>>bomb;
    for(int i = 0;i<str.size();i++){
        q+=str[i];
        if(q.size()>=bomb.size()){
            bool flag=true;
            for(int j=0;j<bomb.size();j++){
                if(q[q.size()-bomb.size()+j]!=bomb[j]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                q.erase(q.end()-bomb.size(),q.end());
            }
        }
    }
    if(q.empty()) cout<<"FRULA";
    else cout <<q;
}