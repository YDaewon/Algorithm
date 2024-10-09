#include <iostream>
#include <algorithm>
using namespace std;

int n;
int building[51];

double line(int i, int j){
    return (double)(building[j]-building[i])/(j-i);
}

int main(){
    cin>>n;
    int cnt[51];
    int result =0;
    for(int i = 1;i<=n;i++){
        cin >> building[i];
        cnt[i]=0;
    }
    
    for(int i = 1;i<n;i++){
        double max_gradient = -9999999999999;
        for(int j =i+1; j<= n;j++){            
            double gradient = line(i,j);
            if(max_gradient < gradient){
                cnt[i]++;
                cnt[j]++;
                max_gradient=gradient;
            }            
        }
    }
    for(int i = 1;i<=n;i++) result = max(result,cnt[i]);
    cout<<result;
}
                