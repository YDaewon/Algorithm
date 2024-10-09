#include <iostream>
#include <vector>
using namespace std;

int n;
int cnt[3] = {0,0,0};
vector<vector<int>> arr;
void cut_paper(int num, int x, int y){
    int check = arr[y][x];
    bool flag = false;
    for (int i = y; i < y + num; i++){
        for (int j = x; j < x + num; j++){
            if (arr[i][j] != check){
                flag = true;
                break;
            }       
        }
        if (flag) break;
    }
    if (flag) {
        int resize = num / 3;
        for (int i =0; i < 3; i++)
            for (int j =0; j < 3; j++)
                cut_paper(resize, x + (j * resize), y + (i * resize));
    }
    else cnt[check] ++;
}

int main(){
    cin >> n;
    int num;
    for (int i =0; i < n; i++){
        vector<int> temp;
        for (int j = 0; j < n; j++){
            cin >> num;
            temp.push_back(num+1);
        }
        arr.push_back(temp);
    }
    cut_paper(n, 0, 0);
    for (int i = 0; i < 3; i++) cout << cnt[i] << endl;
}
        
    
    