#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main(){
    string s;
    cin >> s;
    int a = count(s.begin(), s.end(), 'a');
    
    s = s + s;
    int result = 1000;
    for(int i = 0; i < s.size()/2;i++){
        auto start = s.begin()+i;
        int b = count(start, start+a,'b');
        result = min(result,b);
    }
    cout << result;
}