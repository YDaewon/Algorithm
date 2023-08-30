#include <iostream>
#include <algorithm>
using namespace std;
typedef long long LL;

pair<LL, LL> Count_two_five(LL num) {
    LL two = 0;
    LL five = 0;
    for (LL i = 2; i <= num; i *= 2) {
        two += num / i;
    }
    for (LL i = 5; i <= num; i *= 5) {
        five += num / i;
    }
    return make_pair(two, five);
}

int main() {
    LL n, m;
    cin >> n >> m;
    pair<LL, LL> n_zero = Count_two_five(n);
    pair<LL, LL> m_zero = Count_two_five(m);
    pair<LL, LL> nm_zero = Count_two_five(n - m);
    LL two_count = n_zero.first - m_zero.first - nm_zero.first;
    LL five_count = n_zero.second - m_zero.second - nm_zero.second;
    cout << min(two_count, five_count);
}