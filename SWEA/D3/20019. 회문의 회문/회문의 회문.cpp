#include <iostream>
using namespace std;


bool sol(string str) {
    int sz = str.size();
    int half_sz = sz / 2;
    for (int i = 0; i < half_sz; i++){
        if (str[i] != str[sz-1 - i]) return false;
    }
    for (int i = 0; i < half_sz/2; i++) {
        if (str[i] != str[half_sz- i - 1]) return false;
    }
    for (int i = half_sz + 1; i < half_sz + 1 + half_sz/2; i++) {
        if (str[i] != str[sz-1 - i]) return false;
    }
    return true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);cout.tie(0);
    int T;
    cin >> T;
    for (int i = 1; i <= T; i++){
        string str;
        cin >> str;
        cout << "#" << i << " ";
        if (sol(str)) {
            cout << "YES\n";
        }
        else cout << "NO\n";
    }
}