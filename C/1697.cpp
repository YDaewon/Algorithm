#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int visit[100001];
void bfs(int start, int end) {
    queue<pair<int, int>> q;
    q.push(make_pair(start, 0));
    fill_n(visit, 100001, 0);
    visit[start] = 1;
    while (!q.empty()) {
        int t = q.front().first;
        int count = q.front().second;
        q.pop();
        if (t == end) {
            cout << count;
            return;
        }
        if (t + 1 >= 0 && t + 1 < 100001) {
            if (visit[t + 1] == 0) {
                visit[t + 1] = 1;
                q.push(make_pair(t + 1, count + 1));
            }
        }
        if (t - 1 >= 0 && t - 1 < 100001) {
            if (visit[t - 1] == 0) {
                visit[t - 1] = 1;
                q.push(make_pair(t - 1, count + 1));
            }
        }
        if (t * 2 >= 0 && t * 2 < 100001) {
            if (visit[t * 2] == 0) {
                visit[t * 2] = 1;
                q.push(make_pair(t * 2, count + 1));
            }
        }
    }
}

int main() {
    int s, e;
    cin >> s >> e;
    bfs(s, e);
}