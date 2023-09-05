#include <iostream>
#include <string>
using namespace std;

int main() {
    string l, r;
    cin >> l >> r;
    while (l.size() != r.size()) {
        if (l.size() < r.size())
            l.insert(0, "0");
        else
            r.insert(0, "0");
    }
    int count = 0;
    for (int i = 0; i < l.size();i++) {
        if (l[i] == r[i]) {
            if (l[i] == '8')
                count++;
        }
        else
            break;
    }
    cout << count;
}