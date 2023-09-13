#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

bool lucky(string s) {
    for (int i = 0; i < s.size() - 1;i++) {
        if (s[i] == s[i + 1]) return false;
    }
    return true;
}

int factor(int n) {
    if (n == 1)return 1;
    int r = n;
    r *= factor(n - 1);
    return r;
}

int main() {
    string str;
    int count = 0;
    int alpha[26];
    bool flag = true;
    fill_n(alpha, 26, 0);

    cin >> str;
    sort(str.begin(), str.end());
    for (char a : str)
        alpha[a - 'a'] += 1;
    for (int i : alpha)
        if (i > 1) flag = false;
    if (flag) count = factor(str.size());
    else {
        do {
            if (lucky(str)) count++;
        } while (next_permutation(str.begin(), str.end()));
    }
    cout << count;
}
