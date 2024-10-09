#include <iostream>
#include <algorithm>
#include <vector>
typedef long long L;
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n;
    cin>>n;
    vector<L> arr(n),res(n);
    for(int i=0;i<n;i++)
        cin>>arr[i];
    res=arr;
    sort(arr.begin(),arr.end());
    arr.erase(unique(arr.begin(),arr.end()),arr.end());
    for(int i =0;i<n;i++){
        int ans = lower_bound(arr.begin(),arr.end(),res[i])-arr.begin();
        cout<< ans <<" ";
    }
}