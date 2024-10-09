#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

vector<int> broke;
int s=100;
int e,n;

bool check(int tnum){
    for(int t :to_string(tnum)){
        for(int i : broke){
            if(t-'0'==i) return false;
        }
    }
    return true;
}

int search(int num){
    int r = 499900;
    for(int i = 0;i<999800;i++){
        if(check(i)){
            int t = abs(num-i)+to_string(i).size();
            r = min(r,t);
        }
    }
    return r;
}

int main(){
    cin>>e;
    cin>>n;
    for(int i=0;i<n;i++){
        int t;
        cin>>t;
        broke.push_back(t);
    }
    int result=min(search(e), abs(e-s));
    cout << result;
}
            