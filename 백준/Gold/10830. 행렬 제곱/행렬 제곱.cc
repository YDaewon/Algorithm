#include <iostream>
#include <vector>
#define mod 1000
#define vvi vector<vector<long long>>
typedef long long ll;
using namespace std;

ll n,b;
string bit="";
vvi origin;

void input(){
    cin>>n>>b;
    ll temp;
    for(int i=0;i<n;i++){
        vector<ll> t;
        for(int j=0;j<n;j++){
            cin>>temp;
            t.push_back(temp);
        }
       origin.push_back(t);
    }
    while(b>0){
        if(b%2==0) bit="0"+bit;
        else bit = "1"+bit;
        b>>=1;
    }
}

vvi mat_mul(vvi a, vvi b){
    vvi temp;
    for(int i =0;i<n;i++){
        vector<ll> tt(n);
        for(int j=0;j<n;j++){
            ll val=0;
            for(int k=0;k<n;k++){
                val+=a[i][k]*b[k][j];
            }
            tt[j]=val%mod;
        }
        temp.push_back(tt);
    }
    return temp;
}

void sol(){
    vvi ans(n,vector<ll>(n));
    for(int i=0;i<n;i++)
        ans[i][i]=1;
    while(!bit.empty()){
        ans=mat_mul(ans,ans);
        if(bit[0]=='1')
            ans=mat_mul(ans,origin);
        bit.erase(bit.begin());
    }
    for(int i=0;i<n;i++){
        for(int j =0;j<n;j++){
            cout<< ans[i][j]<< " ";
        }
        cout<<"\n";
    }
}

int main(){
    input();
    sol();
}
            