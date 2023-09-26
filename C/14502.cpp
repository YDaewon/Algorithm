#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;

vector<vector<int>> origin;
vector<vector<int>> lab;
int n, m;
int result = 0;
int head_y[4] = { -1,1,0,0 };
int head_x[4] = { 0,0,-1,1 };

int dfs() {
    vector<vector<int>> test = lab;
    stack<pair<int, int>> s;
    for (int i = 0;i < n;i++) {
        for (int j = 0;j < m;j++) {
            if (test[i][j] == 2)
                s.push(make_pair(i, j));
        }
    }
    while (!s.empty()) {
        int ty = s.top().first;
        int tx = s.top().second;
        s.pop();
        for (int i = 0;i < 4;i++) {
            int py = ty + head_y[i];
            int px = tx + head_x[i];
            if (py >= n || py < 0 || px >= m || px < 0) continue;
            if (test[py][px] == 0) {
                s.push(make_pair(py, px));
                test[py][px] = 2;
            }
        }
    }
    int count = 0;
    for (int i = 0;i < n;i++) {
        for (int j = 0;j < m;j++) {
            if (test[i][j] == 0)
                count++;
        }
    }
    return count;
}

void test_wall(int c) {
    if (c == 2) {
        int r = dfs();
        if (r > result) {
            /*
            cout << "========== Update Lab ==========" << endl;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++)
                    cout << lab[i][j] << " ";
                cout << endl;
            }*/
            result = r;
        }
        return;
    }
    for (int i = 0;i < n;i++) {
        for (int j = 0;j < m;j++) {
            if (lab[i][j] == 0) {
                lab[i][j] = 1;
                test_wall(c + 1);
                lab[i][j] = 0;
            }
        }
    }
}

int main() {
    cin >> n >> m;
    int t;
    for (int i = 0;i < n;i++) {
        vector<int> temp;
        for (int j = 0;j < m;j++) {
            cin >> t;
            temp.push_back(t);
        }
        origin.push_back(temp);
    }
    for (int i = 0;i < n;i++) {
        for (int j = 0;j < m;j++) {
            if (origin[i][j] == 0) {
                lab = origin;
                lab[i][j] = 1;
                test_wall(0);
            }
        }
    }
    cout << result;
}

