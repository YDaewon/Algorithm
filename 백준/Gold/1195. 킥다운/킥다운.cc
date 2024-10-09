#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(){
    string a,b;
    cin>>a;
    cin>>b;
    if(a.size()<b.size()){
        string t = b;
        b=a;
        a=t;
    }
    int Min = a.size()+b.size();
    int temp = Min-1;
    bool flag;
    for(int i = 0; i < b.size();i++){
        flag = true;
        for(int j = 0;j<=i;j++){
            if(b[b.size()-1-i+j]-'0'==2&&a[j]-'0'==2){
                flag=false;
                break;
            }
        }
        if(flag){
            Min = min(Min,temp-i);
        }
    }
    for(int i = 0; i < a.size()-b.size();i++){
        flag = true;
        for(int j = 0;j<b.size();j++){
            if(b[j]-'0'==2&&a[i+j]-'0'==2){
                flag=false;
                break;
            }
        }
        if(flag){
            Min = min(Min,(int)a.size());
        }
    }
    for(int i = b.size()-1; i >= 0;i--){
        flag = true;
        for(int j = 0;j<=i;j++){
            if(b[j]-'0'==2&&a[a.size()-1-i+j]-'0'==2){
                flag=false;
                break;
            }
        }
        if(flag){
            Min = min(Min,temp-i);
        }
    }
    cout << Min;
}