#include <iostream>
#include <algorithm>
#include <vector>
typedef long long L;
using namespace std;

// ���� ���� 1�� ����:W
// ���� ������ �������� ����� ���� �� ����
// �������� �Ȼ���� ���������� -1
// ���� ���� �ΰ�, �ڸ��� ���� ��θ� ���Ĵ� ��쵵 ������ ��.

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
