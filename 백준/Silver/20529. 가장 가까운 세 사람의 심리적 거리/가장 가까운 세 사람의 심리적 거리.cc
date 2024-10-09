#include <iostream>
#include <vector>
#include <string.h>
using namespace std;

int n,result;
int visit[100000];

void combi(int d, int val, vector<string> v, vector<string> mbti){
    if(d==3){
        int cnt = 0;
        for(int i =0;i<4;i++){
            if(mbti[0][i]!=mbti[1][i]) cnt++;
            if(mbti[0][i]!=mbti[2][i]) cnt++;
            if(mbti[2][i]!=mbti[1][i]) cnt++;
        }
        if(result>cnt) result= cnt;
    }
    else{
        for(int i = val;i<n;i++){
            if(!visit[i]){
                mbti.push_back(v[i]);
                visit[i]=1;
                combi(d+1,i,v,mbti);
                visit[i]=0;
                mbti.pop_back();
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T;
    cin>>T;
    while(T--){
        result=99999999;
        vector<string> v;
        vector<string> mbti;
        cin>>n;        
        string t;
        for(int i =0;i<n;i++){
            cin>>t;
            v.push_back(t);
        }
        if(n>32){
            cout << 0<<"\n";
            continue;
        }
        combi(0,0,v,mbti);
        cout << result<<"\n";
        memset(visit,0,sizeof(visit));
    }
}
        
            
            
            
            