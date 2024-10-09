#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, cnt=0;
int arr[1000001], dp[1000001];
vector<int> v, ans;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    cin>>n;
    for(int i=1;i<=n;i++) cin>>arr[i];
    v.push_back(arr[1]);
    for(int i=2;i<=n;i++){
        if(v[cnt]<arr[i]){
            v.push_back(arr[i]);
            cnt++;
            dp[i]=cnt;
        }
        else{
            int idx = lower_bound(v.begin(),v.end(), arr[i])-v.begin();
            v[idx]=arr[i];
            dp[i]=idx;
        }
    }
    for(int i=n;i>=0;i--){
        if(dp[i]==cnt){
            ans.push_back(arr[i]);
            cnt--;
        }
    }
    reverse(ans.begin(), ans.end());
    cout<<ans.size()<<"\n";
    for(int i: ans) cout << i << " ";
}