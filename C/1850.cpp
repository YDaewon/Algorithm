#include <iostream>
#include <algorithm>
typedef long long L;
using namespace std;

L gcd(L a, L b) {
    L big = max(a, b);
    L small = min(a, b);
    L mod = 1;
    while (big % small != 0) {
        mod = big % small;
        big = small;
        small = mod;
    }
    return small;
}

int main() {
    L a, b;
    cin >> a >> b;
    L n = gcd(a, b);
    for (int i = 0;i < n;i++)
        cout << 1;
}