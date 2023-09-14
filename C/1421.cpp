#include <iostream>
#include <algorithm>
#include <vector>
typedef long long L;
using namespace std;

// 나무 길이 1당 가격:W
// 나무 나눌때 나머지가 생기면 나무 ÷ 길이
// 나머지가 안생기면 나무÷길이 -1
// 나무 값이 싸고, 자르는 돈이 비싸면 안파는 경우도 생각할 것.

int main() {
    int n, c, w, s;
    vector<int> wood;
    cin >> n >> c >> w;
    int max_wood = 0;
    int temp;
    for (int i = 0;i < n;i++) {
        cin >> temp;
        wood.push_back(temp);
        max_wood = max(temp, max_wood);
    }
    L cost, point, max_p = 0;
    for (int leng = 1;leng <= max_wood;leng++) {
        L result = 0;
        for (int i : wood) {
            s = i / leng;
            cost = s * c;
            if (i % leng == 0) cost -= c;
            point = s * w * leng;
            result = max(result, result + point - cost);
        }
        max_p = max(result, max_p);
    }
    cout << max_p;
}
