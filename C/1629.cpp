#include <iostream>
using namespace std;
typedef long long L;

L a, b, c;

L sol(L a, L b, L c) {
    L r = 1;
    while (b) {
        if (b % 2 == 1) {
            r = (r * a) % c;
        }
        a = (a * a) % c;
        b /= 2;
    }
    return r;
}

int main() {
    cin >> a >> b >> c;
    cout << sol(a, b, c);
}