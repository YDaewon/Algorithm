#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


vector<vector<int>> triangle;
vector<vector<int>> sum;
int n;
int result;

void dp(){
    for(int i = 1; i < n; i++){
        for(int j = 0; j <= i; j++){
            if(j==0) sum[i][j]=sum[i-1][j]+triangle[i][j];
            else if(i==j) sum[i][j]=sum[i-1][j-1]+triangle[i][j];
            else sum[i][j]= triangle[i][j] + max(sum[i-1][j-1], sum[i-1][j]);
            result = max(result, sum[i][j]);
        }
    }
}

int main(){
    cin >> n;
    int t;
    for(int i = 0;i<n;i++){
        vector<int> temp1;
        vector<int> temp2;
        for(int j = 0;j<= i;j++){
            cin >> t;
            temp1.push_back(t);
            temp2.push_back(0);
        }
        triangle.push_back(temp1);
        sum.push_back(temp2);
    }
    sum[0][0]= triangle[0][0];
    result=sum[0][0];
    dp();
    cout << result;
}
                
