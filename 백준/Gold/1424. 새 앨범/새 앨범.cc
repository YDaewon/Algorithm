#include <iostream>
#include <algorithm>
using namespace std;

int n,l,c;

int main(){
    cin>>n>>l>>c;
    int cd = 999999;
    int max_val=min(n,(c+1)/(l+1));
    for(int k = max_val;k>0;k--){
        if(k%13==0)continue;
        int r = n%k;
        if(r>0){
            if(r%13==0&&k==r+1)r=2;
            else r = 1;
        }
        cd = min(cd,n/k+r);
    }
    cout<<cd;
}
        
                