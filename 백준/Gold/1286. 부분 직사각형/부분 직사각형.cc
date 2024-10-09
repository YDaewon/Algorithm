#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(){
    string str;
    long long alpha[26];
    int n,m;
    cin >> n >> m;
    fill_n(alpha, 26,0);
    for(int i =0;i<n;i++){
        cin >> str;
        long long y = ((i+1)*(2*n-i))+((n+i+1)*(n-i));
        for(int j=0;j<m;j++){
            long long x = ((j+1)*(2*m-j))+((m+j+1)*(m-j));
            alpha[str[j]-'A'] += x*y;
        }
    }
    for(long long i:alpha){
        cout << i << endl;
    }
}
    