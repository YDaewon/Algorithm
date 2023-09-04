#include <iostream>
#include <math.h>
using namespace std;

int sol(int n, int r, int c) {
    int pr = 0;
    int pc = 0;
    int b_size = pow(2, n - 1);
    if (r >= pow(2, n - 1))
        pr = 2;
    if (c >= pow(2, n - 1))
        pc = 1;
    if (n == 1)
        return pr + pc;
    else
        return (pr + pc) * pow(b_size, 2) + sol(n - 1, r % b_size, c % b_size);
}

int main() {
    int n, r, c;
    cin >> n >> r >> c;
    cout << sol(n, r, c);
}