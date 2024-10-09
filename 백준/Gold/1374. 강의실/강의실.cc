#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<pair<int,int>> lecture;
vector<int> room;

int main(){
    cin >> n;
    int t,f,s;
    for(int i =0;i<n;i++){
        cin >>t>>f>>s;
        lecture.push_back({f,s});
    }
    sort(lecture.begin(), lecture.end());
    for(int i = 0;i<n;i++){
        if(room.empty()){
            room.push_back(lecture[i].second);
        }
        else{
            bool flag = false;
            for(int j =0;j<room.size();j++){
                if(room[j] <= lecture[i].first){
                    room[j] = lecture[i].second;
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                room.push_back(lecture[i].second);
            }
        }
    }
    cout << room.size();
}