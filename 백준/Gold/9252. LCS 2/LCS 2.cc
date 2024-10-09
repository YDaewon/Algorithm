#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

string a,b;

void sol(){
    int lcs[1001][1001];
    memset(lcs,0,sizeof(lcs));
    int alen=a.size();
    int blen=b.size();
    int len=0;
    string result;
    for(int i=0;i<alen;i++){
        for(int j=0;j<blen;j++){
            if(a[i]==b[j]){
                lcs[i+1][j+1]=lcs[i][j]+1;
                len=max(lcs[i+1][j+1], len);
            }
            else
                lcs[i+1][j+1]=max(lcs[i][j+1], lcs[i+1][j]);
        }
    }
    cout<< len <<"\n";
    while(lcs[alen][blen]>0){
        if(lcs[alen-1][blen]==lcs[alen][blen]){
            alen--;
            continue;
        }
        if(lcs[alen][blen-1]==lcs[alen][blen]){
            blen--;
            continue;
        }
        result+=a[alen-1];
        alen--;blen--;
    }
    reverse(result.begin(), result.end()),
    cout << result;
}

int main(){
    cin>>a>>b;
    sol();
}