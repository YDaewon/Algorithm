#include <iostream>
#include <algorithm>
typedef long long L;
using namespace std;

L n;
int s[6];
L r[3];
void small(){
    r[0]=min(s[0],s[5]);
    r[1]=min(s[1],s[4]);
    r[2]=min(s[2],s[3]);
    sort(r,r+3);
}
void sol(){
    small();
    L answer=0;
    answer+=r[0]*((n-2)*(n-2)+(4*(n-1)*(n-2)));
    answer+=(r[0]+r[1])*(4*(n-1)+(4*(n-2)));
    answer+=4*(r[0]+r[1]+r[2]);
    cout<<answer;
}
int main(){
    cin>>n;
    int b=0;
    int result=0;
    for(int i=0;i<6;i++){
        cin>>s[i];
        result+=s[i];
        b=max(s[i],b);
    }
    if(n==1) cout << result-b;
    else sol();
}
                  