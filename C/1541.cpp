#include <iostream>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

int main() {
    string str;
    cin >> str;
    int i = 0;
    vector<int> plus;
    vector<int> minus;
    string temp;
    int plus_sum = 0;
    int minus_sum = 0;
    int num = 0;
    temp.clear();

    while (i < str.length()) {
        if (str[i] == '-') {
            i++;
            while (i < str.length()) {
                temp = temp + str[i];
                if ((str[i] == '+' || str[i] == '-') || (i == str.length() - 1)) {
                    if (i != str.length() - 1) temp.pop_back();
                    stringstream ssInt(temp);
                    ssInt >> num;
                    minus.push_back(num);
                    temp.clear();
                }
                if (str[i] == '-') break;
                i++;
            }
        }
        else {
            while (i < str.length()) {
                temp = temp + str[i];
                if ((str[i] == '+' || str[i] == '-') || (i == str.length() - 1)) {
                    if (i != str.length() - 1) temp.pop_back();
                    stringstream ssInt(temp);
                    ssInt >> num;
                    plus.push_back(num);
                    temp.clear();
                }
                if (str[i] == '-')break;
                i++;
            }
        }
    }
    for (int j = 0; j < plus.size();j++) {
        plus_sum += plus.at(j);
    }
    for (int j = 0; j < minus.size();j++) {
        minus_sum += minus.at(j);
    }
    cout << plus_sum - minus_sum << endl;
}