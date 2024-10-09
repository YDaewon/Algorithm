#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <set>
using namespace std;

set<int> s;
vector<pair<int,int>> complete(10);
vector<int> original(10);
vector<int> code(10);
int n,m, answer=10000;

int code2num(string c){
    if(c=="A") return 0;
    else if(c=="A#") return 1;
    else if(c=="B") return 2;
    else if(c=="C") return 3;
    else if(c=="C#") return 4;
    else if(c=="D") return 5;
    else if(c=="D#") return 6;
    else if(c=="E") return 7;
    else if(c=="F") return 8;
    else if(c=="F#") return 9;
    else if(c=="G") return 10;
    else if(c=="G#") return 11;
    else return -1;
}

void convert(int line){
    if(line == n){
        int mini = 10000, big = 0;
        for(int i=0;i<n;i++){
            s.insert(complete[i].first);
            if(complete[i].second != 0){
                mini = min(mini,complete[i].second);
                big = max(big,complete[i].second);
            }
        }
        if(s.size() == m){
            if(mini == 10000) answer = 0;
            else if(big-mini+1 < answer) answer = big-mini+1;
        }
        s.clear();
        return;
    }
    
    for(int i=0;i<m;i++){
        complete[line].first=code[i];
        complete[line].second=code[i]-original[line];
        if(complete[line].second<0) complete[line].second+=12;
        convert(line+1);
        complete[line].second+=12;
        convert(line+1);
    }
}

int main(){
    cin >> n>>m;
    string t;
    for(int i=0;i<n;i++){
        cin>>t;
        original[i]=code2num(t);
    }
    for(int i=0;i<m;i++){
        cin>>t;
        code[i]=code2num(t);       
    }
    convert(0);
    cout<<answer;
}
        
    