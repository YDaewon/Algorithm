#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int main(){
    vector<string> s;
    int n;
    vector<bool> ers;
    cin >> n;
    string t;
    for(int i = 0; i < n; i++){
        cin >> t;
        s.push_back(t);
        ers.push_back(false);
    }
    sort(s.begin(),s.end());
    for(int i = 0; i < s.size();i++){  
        string a,b;
        for(int j = i+1; j < s.size();j++){           
            a = s[i].substr(0, s[i].size());
            b = s[j].substr(0, s[i].size());
            if (a == b){
                ers[i] = true;
                break;
            }
        }
    }
    int cnt = 0;
    for(bool i : ers){
        if(!i) cnt++;
    }
    cout << cnt;
}