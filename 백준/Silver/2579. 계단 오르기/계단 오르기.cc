#include <iostream>
#include <algorithm>
using namespace std;

int stair[301];
int ans[301];
int n;

void dp(){
    ans[0]=0;
    ans[1]=stair[1];
    ans[2]=ans[1]+stair[2];
    for(int i = 3;i<=n;i++){
        int a = ans[i-3]+stair[i-1];
        int b = ans[i-2];
        ans[i]=max(a,b)+stair[i];
    }
}

int main(){
    cin>>n;
    int t;
    for(int i=1;i<=n;i++)
        cin>>stair[i];
    dp();
    cout<<ans[n];
}
        