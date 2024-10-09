#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <map>
#include <set>
using namespace std;

int main(){
    int n, f, s;
    cin >> n;
    vector<pair<int, int>> v;
    vector<int> lis, idxarr(n);
    set<int> ans;


    for (int i = 0; i < n; i++){
        cin >> f >> s;
        v.push_back({ f, s });
        ans.insert(f);
    }
    sort(v.begin(), v.end());
    for (int i = 0; i < n; i++) {
        int idx = lower_bound(lis.begin(), lis.end(), v[i].second) - lis.begin();
        if (idx == lis.size()) lis.push_back(v[i].second);
        else lis[idx] = v[i].second;
        idxarr[i] = idx;
    }
    int len = lis.size()-1;
    for (int i = n - 1; i >= 0; i--) {
        if (idxarr[i] == len) {
            ans.erase(v[i].first);
            len--;
        }
    }
    cout << ans.size() << "\n";
    for (int i : ans) {
        cout << i << " ";
    }
}