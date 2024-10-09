#include <iostream>
#include <vector>
#include <string>
using namespace std;

int n;
vector<int> num;

int main(){
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    cin >> n;
    vector<int> stu(n);
    int Max = 0;
    for(int i = 0; i<n;i++){
        cin >> stu[i];
        Max = max(Max,stu[i]);
    }
    num.resize(Max+1);
    for(int i = 0;i < n;i++){
        num[stu[i]]++;
    }
    int count;
    for(int i = 0; i< n;i++){
        count = -1;
        for(int j = 1;j*j<=stu[i];j++){
            if(stu[i]%j==0){
                if(j*j!=stu[i]) count += num[stu[i]/j]+num[j];
                else count += num[j];
            }
        }
        cout << count << "\n";
    }
}
    