#include <string>
#include <iostream>
using namespace std;

long long n1, n2;
int ans = 0;
const int minsu[2] = { 4,7 };

void count(string s, int n) {
    s += n + '0';
    if (stoll(s) <= n2) {
        if (stoll(s) >= n1) ans++;
        for (int i : minsu) count(s, i);
    }
}

int main() {
    cin >> n1 >> n2;
    string s;
    for (int i : minsu) count(s, i);
    cout << ans;
}
