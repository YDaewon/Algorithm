#include <iostream>
#include <algorithm>
#define MAX 1001
using namespace std;

int box[MAX];
int matryoshka[MAX];

int DP(int n) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j < i; j++) {
            if (box[j] < box[i])
                matryoshka[i] = max(matryoshka[j] + 1, matryoshka[i]);
        }
        count = max(count, matryoshka[i]);
    }
    return count;
}

int main() {
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> box[i];
        matryoshka[i] = 1;
    }
    cout << DP(n);
}