#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector<vector<int>> arr;
vector<vector<int>> t_arr;
int row, col;

void translate(int y, int x) {
    if (y + 2 > row - 1 || x + 2 > col - 1)
        return;
    for (int i = y; i < y + 3;i++) {
        for (int j = x; j < x + 3;j++) {
            if (arr[i][j] == 1)
                arr[i][j] = 0;
            else
                arr[i][j] = 1;
        }
    }
}

int main() {
    cin >> row >> col;
    string temp;
    for (int i = 0; i < row; i++) {
        vector<int> c;
        cin >> temp;
        for (int j = 0; j < col; j++) {
            c.push_back(temp[j] - '0');
        }
        arr.push_back(c);
    }
    for (int i = 0; i < row; i++) {
        vector<int> c;
        cin >> temp;
        for (int j = 0; j < col; j++) {
            c.push_back(temp[j] - '0');
        }
        t_arr.push_back(c);
    }

    int count = 0;
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            if (arr[i][j] != t_arr[i][j]) {
                count++;
                translate(i, j);
            }
        }
    }
    bool flag = true;
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            if (arr[i][j] != t_arr[i][j]) {
                flag = false;
                break;
            }
        }
    }
    if (flag)
        cout << count << endl;
    else
        cout << -1;
}