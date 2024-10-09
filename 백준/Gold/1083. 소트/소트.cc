#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int arr[51];
    int n,s;
    cin >> n;
    for(int i=0;i<n;i++) cin>>arr[i];
    cin >> s;
    
    for(int i =0;i<n;i++){
        int m = arr[i];
        int m_idx=i;
        for(int j=i+1;j<n;j++){
            if(s-(j-i)>=0){
                if(m<arr[j]) {
                    m=arr[j];
                    m_idx=j;
                }
            }
        }
        for(int j=m_idx;j>i;j--){
            swap(arr[j],arr[j-1]);
            s--;
        }
        if(s<=0)break;
    }
    for(int i =0;i<n;i++) cout << arr[i] << " ";
}