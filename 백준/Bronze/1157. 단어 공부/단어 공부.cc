#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

map<char, int> m;
string str;
vector<int> v;
int ans = 0;

int main() {
	cin >> str;
	for (char c : str){
		int t = c;
		if (t >= 97) t -= 32;
		m[t]++;
		if (ans < m[t]) ans = m[t];
	}
	for (auto i : m) {
		if (ans == i.second) {
			ans = i.second;
			v.push_back(i.first);
		}
	}
	if (v.size() > 1) cout << "?";
	else cout << char(v[0]);
}