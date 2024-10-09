#include <iostream>
#include <stack>
#include <string>
using namespace std;

int n;
string in,out;

void sol(){
    stack<char> s;
    for(char i : in){
        if(i=='('){
            s.push(i);
        }
        else if(i==')'){
            while(!s.empty()&&s.top()!='('){
                out+=s.top();
                s.pop();
            }
            s.pop();
        }
        else if(i=='*'||i=='/'){
            while(!s.empty()&&(s.top()=='*'||s.top()=='/')){
                out+=s.top();
                s.pop();
            }
            s.push(i);
        }
        else if (i=='+'||i=='-'){
            while(!s.empty()&&s.top()!='('){
                out+=s.top();
                s.pop();
            }
            s.push(i);
        }
        else
            out+=i;
    }
    while(!s.empty()){
        out+=s.top();
        s.pop();
    }
    cout<<out;
}

int main(){
    cin>>in;
    sol();
}