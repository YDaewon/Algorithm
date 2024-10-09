#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;
#define MAX 40000000000
int n;
vector<long long> arr;


void sol() {
    long long ans = MAX, as, am, ae;
    for (int i = 0; i < n-2; i++){
        int s = i+1, e = n - 1;
        while (s < e) {
            long long cur = arr[s] + arr[i] + arr[e];
            if (abs(cur) < ans) {
                ans = abs(cur);
                as = s; am = i; ae = e;
            }
            if (cur < 0) {
                s++;
                if (s == i) s++;
            }
            else{ 
                e--; 
                if (e == i) e--;
            }
        }
    }
    int answer[3] = { arr[as], arr[am], arr[ae] };
    sort(answer, answer + 3);
    for (int i : answer) cout << i << " ";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);cout.tie(0);
    cin >> n;
    int m_cnt = 0;
    arr.resize(n);
    for (int i = 0; i < n; i++){
        cin >> arr[i];
        if (arr[i] < 0) m_cnt++;
    }
    sort(arr.begin(), arr.end());
    sol();
}