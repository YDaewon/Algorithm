#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n, y, x1, x2;
    int total = 0;
    vector<pair<int, pair<int, int>>> plat;
    cin >> n;
    for (int i = 0;i < n;i++) {
        cin >> y >> x1 >> x2;
        total += y * 2;
        plat.push_back(make_pair(y, make_pair(x1, x2 - 1)));
    }
    sort(plat.begin(), plat.end());
    for (int i = n - 1;i > 0;i--) {
        for (int j = i - 1;j > -1;j--) {
            if ((plat[i].second.first >= plat[j].second.first) && (plat[i].second.first <= plat[j].second.second)) {
                total -= plat[j].first;
                break;
            }
        }
        for (int j = i - 1;j > -1;j--) {
            if ((plat[i].second.second >= plat[j].second.first) && (plat[i].second.second <= plat[j].second.second)) {
                total -= plat[j].first;
                break;
            }
        }
    }
    cout << total;
}
