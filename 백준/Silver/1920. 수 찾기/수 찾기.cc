#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

map<int, int> m;
int arr[100001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
	int n, k, temp=0;
	cin >> n;

	while (n--) {
		cin >> temp;
		m[temp]++;
	}
	cin >> k;
	while (k--) {
		cin >> temp;
		if (m[temp]) cout << 1 << "\n";
		else cout << 0 << "\n";
	}
}