#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int t, n;
    cin >> t;
    for (int j = 0;j < t;j++) {
        int a, b;
        cin >> n;
        vector<pair<int, int>> v;
        for (int i = 0;i < n;i++) {
            cin >> a >> b;
            v.push_back({ a,b });
        }
        sort(v.begin(), v.end());
        int temp = 0;
        int result = 1;
        for (int i = 1;i < n;i++) {
            if (v[temp].second > v[i].second) {
                temp = i;
                result++;
            }
        }
        cout << result << "\n";
    }
}

