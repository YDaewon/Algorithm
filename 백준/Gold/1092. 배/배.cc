#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
    int n,m;
    int crain[51];
    vector<int> box;
    cin>>n;
    for(int i=0;i<n;i++)
        cin>>crain[i];
    sort(crain,crain+n);
    cin>>m;
    for(int i=0;i<m;i++){
        int t;
        cin >> t;
        box.push_back(t);
    }
    sort(box.begin(),box.end());
    int time=0;
    if(box[m-1] > crain[n-1]){
        cout << -1;
        return 0;
    }
    while(!box.empty()){
        for(int i=n-1;i>-1;i--){
            for(int j= box.size()-1;j>-1;j--){        
                if(crain[i]>=box[j]){               
                    box.erase(box.begin()+j);
                    break;
                }
            }
        }
        time++;
    }
    cout<<time;
}
    