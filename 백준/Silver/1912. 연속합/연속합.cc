#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> sum;

int main(){
    int n, num, temp, result;
    cin >> n;
    for(int i =0; i <n; i++){
        cin >> num;
        if (i >0){
            temp = max(num, sum[i-1] + num);
            sum.push_back(temp);
            result = max(result, sum[i]);
        }
        else{                   
            sum.push_back(num);
            result = sum[0];
        }
          
    }
    cout << result << endl;
}            
    