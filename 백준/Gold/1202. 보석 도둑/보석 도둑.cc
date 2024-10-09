#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int n, k; // n: 보석 갯수, k: 가방 갯수
pair<int, int> ju[300001];
int bp[300001];

void input() {
    cin >> n >> k;
    int x, c;
    for (int i = 0; i < n; i++) {
        cin >> x >> c;
        ju[i] = { x, c };
    }
    sort(ju, ju + n);
    for (int i = 0; i < k; i++) {
        cin >> bp[i];
    }
    sort(bp, bp+k);
}

void sol() {
    long long ans = 0;
    int idx = 0;
    priority_queue<int> pq;
    for (int i = 0; i < k; i++){
        while (ju[idx].first <= bp[i]) {
            if (idx >= n) break;
            pq.push(ju[idx].second);
            idx++;
        }
        if (!pq.empty()) {
            ans += pq.top();
            pq.pop();
        }
    }
    cout << ans;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);cout.tie(0);
    input();
    sol();

}