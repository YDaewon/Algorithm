#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<int> arr;
int result = 0;

int count_line(){
    vector<int> t;
    t.push_back(0);
    int percent = 0;
    int count = 0;
    for(int i = 1;i<=n;i++){
        percent += arr[i-1];
        t.push_back(percent);
    }
    for(int i = 0; i<n;i++){
        for(int j = i+1;j<n;j++){
            if(t[i]+50 == t[j]){
                count++;
                break;
            }
        }
    }
    return count;
}

void permutation(int depth){
    if(depth == n-1){
        result = max(result, count_line());
    }
    else{
        for(int i = depth+1;i<n;i++){
            swap(arr[depth],arr[i]);
            permutation(depth+1);
            swap(arr[depth],arr[i]);
        }
    }
}

int main(){
    cin >> n;
    int t;
    for(int i = 0;i<n;i++){
        cin >> t;
        arr.push_back(t);
    }
    permutation(0);
    cout << result;
}