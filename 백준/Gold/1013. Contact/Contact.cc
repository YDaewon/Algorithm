#include <iostream>
#include <regex>
#include <string>
using namespace std;

int main(){
    int n;
    cin >> n;
    regex p("(100+1+|01)+");
    while(n--){
        string s;
        cin >> s;
        cout << (regex_match(s,p)?"YES":"NO")<<endl;
    }
}