#include<iostream>
#include<algorithm>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;
    vector<int> trees;
    for (int i = 0; i < N; i++) {
        int t;
        cin >> t;
        trees.push_back(t);
    }

    long long s = 0, e = *max_element(trees.begin(), trees.end());
    long long curr;
    long long sum = 0, ans;

    while (s <= e) {
        curr = (s + e) / 2;
        sum = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] > curr) {
                sum += trees[i] - curr;
            }
        }
        if (sum >= M) {
            ans = curr;
            s = curr + 1;
        }
        else {
            e = curr - 1;
        }
    }
    cout << ans;
}