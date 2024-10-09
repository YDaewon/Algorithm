#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <queue>

using namespace std;

int n, m;
vector<pair<int, pair<int, int>>> town;
vector<int> parant;

int getp(int num) {
    if (parant[num] == num) return num;
    else  return parant[num] = getp(parant[num]);
}

void uni(int n1, int n2) {
    n1 = getp(n1);
    n2 = getp(n2);
    parant[n2] = n1;
}


void input() {
    cin >> n >> m;
    int f, s, c;
    parant.resize(n + 1);
    for (int i = 0; i < m; i++) {
        cin >> f >> s >> c;
        town.push_back({ c, { f, s } });
    }
    sort(town.begin(), town.end());
    for (int i = 1; i <= n; i++) {
        parant[i] = i;
    }
}

void sol() {
    int max_cost = 0;
    int ans = 0;
    for (int i = 0; i < m; i++){
        int cost = town[i].first;
        int start = town[i].second.first;
        int end = town[i].second.second;
        if (getp(start) == getp(end)) continue;
        else {
            uni(start, end);
            max_cost = max(max_cost, cost);
            ans += cost;
            //cout << start << " - > " << end << " , " << "cost: " << cost << ", now ans : " << ans << endl;
        }
    }
    cout << ans - max_cost;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);cout.tie(0);
    input();
    sol();
}