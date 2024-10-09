#include <iostream>
#include <vector>
#include <string>
#include <deque>
using namespace std;

int t,n,m;

void AC(){
    string str,line;
    deque<int> arr;
    bool reverse=false, error= false;
    cin>>str>>n>>line;    
    string temp="";
    for(char i : line){
        if(i-'0' >= 0 && i - '0'<=9){
            temp+=i;
        }
        else{
            if(!temp.empty()){
                arr.push_back(stoi(temp));
                temp="";
            }
        }
    }
    for(char i : str){
        if(i=='R'){
            reverse=!reverse;
        }
        else{
            if(!arr.empty()){
                if(reverse)
                    arr.pop_back();
                else
                    arr.pop_front();
            }
            else{
                cout << "error" << "\n";
                error=true;
                break;
            }
        }
    }
    if(!error)
        cout<<"[";
    int sz = arr.size();
    if(reverse && !arr.empty()){
        for(int i = sz-1;i>=1;i--){
            cout<<arr[i]<<",";
        }
        cout<<arr[0];
    }
    else if(!reverse&& !arr.empty()){
        for(int i = 0;i<sz-1;i++){
            cout<<arr[i]<<",";
        }
        cout<<arr[sz-1];
    }
    if(!error)
        cout<<"]\n";
}

int main(){
    cin>>t;
    ios_base::sync_with_stdio(false);
    cin.tie(0);cout.tie(0);
    while(t--){
        AC();
    }
}
        
