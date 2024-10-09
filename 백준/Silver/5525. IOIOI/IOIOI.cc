#include <iostream>
#include <vector>
#include <string>
using namespace std;

int n,m;

int main(){
    cin>>n>>m;
    string p = "IOI";
    string s;
    int count = 0;
    int ans = 0;
    cin>>s;
    for(int i = 0;i<m;i++){
        if(s[i]=='I'){
            bool flag = true;
            for(int j = 0; j < 3;j++){
                if(p[j] != s[i+j]){
                    flag = false;
                    break;
                }
            }
            if(flag){// IOI가 나왔을때
                i++;
                count++;
                if(count == n){
                    count--;
                    ans++;
                }
            }
            else count = 0;
        }
    }
    cout << ans;
}
                   