#include <iostream>
#include <map>
#include <math.h>
using namespace std;

string memo;
string pw;
map<char,int> m;

int main(){
    int result = 0;
    cin >> memo;
    cin >> pw;
    int m_size=memo.size();
    int p_size=pw.size();
    int cnt = 1;
    for(char i : memo){
        m.insert({i,cnt++});
    }
    int temp = 1;
    for(int i  = 0;i < p_size;i++){
        result += m[pw[p_size-1-i]] * temp;
        temp *= m_size;
        temp %= 900528;
        result %= 900528;
    }
    cout << result;
}
            