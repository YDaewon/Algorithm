#include <iostream>
#include <vector>

using namespace std;

int main() {
    int k, n, v_temp;
    cin >> k >> n;
    vector<int> lan;
    long long int sum = 0;
    for (int i = 0; i < k; i++) {
        cin >> v_temp;
        lan.push_back(v_temp);
        sum += v_temp;
    }
    long long int start = 1;
    long long int end = sum / n;
    int count = 0;
    long long int mid = (start + end) / 2;
    int idx = 0;
    while (start <= end) {
        count = 0;
        mid = (start + end) / 2;
        for (idx = 0; idx < k; idx++) {
            count += (lan[idx] / mid);
        }
        if (count >= n) start = mid + 1; else end = mid - 1;
    }
    cout << end << endl;
}