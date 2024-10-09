#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool wire_fig(){
    int n;
    vector<double> arr;
    cin >> n;
    double num;
    for(int i =0;i<n;i++){
        cin >> num;
        arr.push_back(num);
    }
    if(n>2){
        sort(arr.begin(), arr.end());
        for(int i = 2; i < n;i++){
            double temp = 0;
            for(int j = 0; j < i; j++)
                temp += arr[j];
            if(temp >= arr[i])
                return true;
        }
    }
    else if(n == 2){
        if(arr[0] == arr[1])
            return true;
    }
    return false;    
}

int main(){
    int k;
    cin >> k;
    for(int i =0; i< k; i++){        
        if (wire_fig())
            cout << "YES" << endl;
        else
            cout << "NO" << endl;
    }
}
    