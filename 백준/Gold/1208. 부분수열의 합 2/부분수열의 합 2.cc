#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

int n, s;
long long cnt = 0; // n: 보석 갯수
int num[40];
map<int, int> sum;

void r_sum(int mid, int su) {
    if (mid == n) {
        sum[su]++;
        return;
    }
    r_sum(mid + 1, su + num[mid]);
    r_sum(mid + 1, su);
}

void l_sum(int mid, int su) {
    if (mid == n / 2) {
        cnt += sum[s - su];
        return;
    }
    l_sum(mid + 1, su + num[mid]);
    l_sum(mid + 1, su);
}

void input() {
    cin >> n >> s;
    int x;
    for (int i = 0; i < n; i++) {
        cin >> num[i];
    }
}

void sol() {
    r_sum(n / 2, 0);
    l_sum(0, 0);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);cout.tie(0);
    input();
    sol();
    if (!s) cout << cnt - 1;
    else cout << cnt;
}