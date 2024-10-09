#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int LCS[1001][1001];
int answer=0;
string a, b;

void sol(){
    int i,j;
    for(i = 1;i<=a.size();i++){
        for(j = 1;j<=b.size();j++){           
            if(a[i-1]==b[j-1]) LCS[i][j]=LCS[i-1][j-1]+1;
            else LCS[i][j]=max(LCS[i-1][j],LCS[i][j-1]);
        }
    }
    cout <<LCS[a.size()][b.size()];
}

int main(){
    cin>>a;
    cin>>b;
    sol();
}