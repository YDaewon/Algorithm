#include <iostream>
#include <map>
#include <string>
typedef long long L;
using namespace std;

L n,s;
map<int,string,greater<int>> type;

int main(){
    string str = "";
    type.insert({0,str});
    cin >> n;
    for(int i =0; i< n;i++){
        string temp;
        cin >> temp;
        if(temp=="type"){
            string t;
            cin >> t >> s;
            str += t;
            type.insert({s,str});
        }
        else{
            L back;
            bool flag = true;
            cin >> back >> s;
            for(auto i : type){
                if(i.first >= s-back){
                    continue;
                }
                flag = false;
                str = i.second;
                type.insert({s,str});
                break;
            }
            if(flag){
                str="";
                type.insert({s,str});
            }
        }
    }
    auto it = type.begin();
    cout << it->second;
}