#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main() {
    stack<int> s;
    vector<char> r;
    int n, num;
    bool flag = false;
    int top = 1;
    cin >> n;
    for (int i = 0; i < n;i++) {
        cin >> num;
        while (top <= num) {
            s.push(top++);
            r.push_back('+');
        }
        if (s.top() == num) {
            s.pop();
            r.push_back('-');
        }
        else
            flag = true;
    }
    if (flag)
        cout << "NO" << '\n';
    else {
        for (int i = 0; i < r.size();i++)
            cout << r[i] << '\n';
    }
}