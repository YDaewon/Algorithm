#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<int>> conference_info;

int main() {
    int n, start, end;
    cin >> n;
    int count = 1;
    for (int i = 0; i < n; i++) {
        vector<int> temp;
        cin >> start >> end;
        temp.push_back(end);
        temp.push_back(start);
        conference_info.push_back(temp);
    }
    sort(conference_info.begin(), conference_info.end());
    int early_end = conference_info[0][0];
    for (int i = 1;i < n;i++) {
        if (early_end <= conference_info[i][1]) {
            early_end = conference_info[i][0];
            count++;
        }
    }

    cout << count;
}
