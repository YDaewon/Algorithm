#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;
vector<pair<int, pair<int,int>>> v;

int parent[10001];
int find(int x) {
    if (parent[x] == x)return x;
    else return parent[x] = find(parent[x]);
}
void uni(int x, int y) {
    x = find(x);
    y = find(y);
    parent[y] = x;
}
bool sameparent(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y)return true;
    else return false;
}

void input() {
    cin >> n >> m;
    int f, s, c;
    for (int i = 0; i < m; i++) {
        cin >> f >> s >> c;
        v.push_back({ c, {f, s} });
    }
    sort(v.begin(), v.end());
    for (int i = 1; i <= n; i++) {
        parent[i] = i;
    }
}

void sol() {
    int ans = 0;
    for (int i = 0; i < v.size(); i++){
        if (!sameparent(v[i].second.first, v[i].second.second)) {
            ans += v[i].first;
            uni(v[i].second.first, v[i].second.second);
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