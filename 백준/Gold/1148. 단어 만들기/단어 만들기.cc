#include <iostream>
#include <string>
#include <algorithm>
#include<cstring>
using namespace std;

int dic[200000][30];
int puzzle[30];
int cnt[30];
int visit[30];

int main(){
    string temp;
    int n = 0;
    while(1){
        cin >> temp;
        if(temp=="-") break;
        for(char i : temp)
            dic[n][i-'A'] += 1;
        n++;
    }
    while(1){
        cin >> temp;
        if(temp=="#") break;
        memset(cnt,-1,sizeof(cnt));
        memset(puzzle,0,sizeof(puzzle));   
        for(char i : temp){
            cnt[i-'A'] = 0;
            puzzle[i-'A'] += 1;
        }
        for(int i = 0; i< n;i++){
            bool flag = true;
            for(int j = 0; j< 26;j++){
                if(puzzle[j] < dic[i][j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                for(char t : temp){
                    if(dic[i][t-'A'] != 0 && visit[t-'A'] == 0){
                        cnt[t-'A'] += 1;
                        visit[t-'A'] = 1;
                    }
                }
            }
            memset(visit,0,sizeof(visit));
        }
        int Min = 999999;
        int Max = -1;
        for(int i = 0; i<26;i++){
            if(cnt[i] != -1){
                Min = min(Min, cnt[i]);
                Max = max(Max, cnt[i]);
            }
        }
        string r1="",r2="";
        for(int i = 0; i<26;i++){
            if(cnt[i] == Min) r1 += i + 'A';
            if(cnt[i] == Max) r2 += i + 'A';
        }
        cout << r1 << " " << Min << " " << r2 << " " << Max << endl;
    }
}
                          
                    
                    
        