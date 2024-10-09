#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    long long val,cnt=0,l,r,k,x;
    cin>>l>>r>>k;
    val=k*(k+1)/2;
    while(val<=r){
        if(val>=l)cnt++;
        if(k==2){
            int t=max(l,val);
            cnt=r-t+1;
            break;
        }
        else if(k==4){
            val+=2;
            if(val==12)val+=2;
        }
        else val+=k;
    }
    cout << cnt;
}