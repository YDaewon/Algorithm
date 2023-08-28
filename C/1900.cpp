#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<int>> player;
vector<int> win;

int Strong(int a, int b) {
    return (player[a][0] + (player[b][0] * player[a][1]));
}

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        vector<int> temp;
        int num;
        for (int j = 0; j < 2; j++) {
            cin >> num;
            temp.push_back(num);
        }
        player.push_back(temp);
        win.push_back(1);
    }
    for (int i = 0;i < n;i++) {
        for (int j = i + 1; j < n;j++) {
            if (Strong(i, j) > Strong(j, i))
                win[i]++;
            else
                win[j]++;
        }
    }
    for (int i = 0; i < n; i++) {
        int max_idx = max_element(win.begin(), win.end()) - win.begin();
        cout << max_idx + 1 << endl;
        win[max_idx] = 0;
    }
}