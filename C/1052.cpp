#include <iostream>
#include <bitset>
using namespace std;

int main() {
    int n, k, count = 0;
    cin >> n >> k;
    bitset<32> b_n(n);
    while (b_n.count() > k) {
        count++;
        b_n = n + count;
    }
    cout << count;
}