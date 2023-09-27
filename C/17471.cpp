#include <iostream>
#include <vector>
#include <stack>
#include <cstring>
using namespace std;

vector<vector<int>> graph(11);
int point[11];
int team[11];
int visit[11];
int n, result = 1000;

bool check(vector<int> v, int b) {
    int cnt = 1;
    stack<int> s;
    memset(visit, 0, sizeof(visit));
    s.push(v[0]);
    visit[v[0]] = 1;
    while (!s.empty()) {
        int t = s.top();
        s.pop();
        for (int i : graph[t]) {
            if (team[i] == b && visit[i] == 0) {
                s.push(i);
                visit[i] = 1;
                cnt++;
            }
        }
    }
    if (cnt == v.size())return true;
    else return false;
}

void combi(int cur, int end) {
    if (cur == end) {
        vector<int> A, B;
        for (int i = 1;i <= n;i++) {
            if (team[i])A.push_back(i);
            else B.push_back(i);
        }
        if (check(A, 1) && check(B, 0) && !A.empty() && !B.empty()) {
            int ap = 0, bp = 0;
            for (int i = 1;i <= n;i++) {
                if (team[i]) ap += point[i];
                else bp += point[i];
            }
            result = min(result, abs(ap - bp));
        }
        return;
    }
    for (int i = 1;i <= n;i++) {
        if (team[i]) continue;
        else {
            team[i] = 1;
            combi(cur + 1, end);
            team[i] = 0;
        }
    }
}

void Input() {
    cin >> n;
    for (int i = 1;i <= n;i++) cin >> point[i];
    int m, t;
    for (int i = 1;i <= n;i++) {
        cin >> m;
        for (int j = 0;j < m;j++) {
            cin >> t;
            graph[i].push_back(t);
            graph[t].push_back(i);
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);
    Input();
    for (int i = 1;i <= int(n / 2);i++) combi(0, i);
    if (result == 1000) cout << -1;
    else cout << result;

    return 0;
}


