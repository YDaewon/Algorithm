#include <iostream>
#include <vector>
using namespace std;

int main(){
    int n;
    vector<int> v;
    cin>>n;
    for(int i=0;i<n;i++){
        int cur;
        cin>>cur;
        int idx = lower_bound(v.begin(), v.end(), cur)-v.begin();
        if(idx==v.size()) v.push_back(cur);
        else v[idx]=cur;
    }
    cout << v.size();
}