#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int h,w;
int player_key[26]; // 플레이어가 가진 열쇠
int building_map[110][110]; // 빌딩 지도
// -1: 벽
//  0: 빈 공간
// 65~90: 문
// 97~122: 열쇠
// 36: 점수

int hx[4]={0,0,-1,1};
int hy[4]={-1,1,0,0};
int score;
int visit[110][110];

void init(){
    memset(player_key, 0, sizeof(player_key));
    memset(building_map, 0, sizeof(building_map));
    memset(visit,0,sizeof(visit));
    score = 0;
}

void input(){
    cin>>h>>w;
    string t;
    for(int i = 1; i <= h; i++){
        cin >> t;
        for(int j = 1; j <= w; j++){
            int &cur = building_map[i][j];
            if(t[j-1]=='*') cur = -1;
            else if(t[j-1] == '.'){
                cur = 0;
            }
            else cur = t[j-1];
        }
    }
    cin >> t;
    if(t[0] != '0'){
        for(char c : t) player_key[c-97] = 1;
    }
}

void print(){
    for(int i = 1; i <= h; i++){
        for(int j = 1; j <= w; j++){
            int &cur = building_map[i][j];
            if(cur=='*') cout<<"■ ";
            else if(cur=='.') cout <<"□ ";
            else{
                string t = " ";
                t += cur;
                cout << t << " ";
            }
        }
        cout << "\n";
    }
}

void sol(){
    queue<pair<int,int>> q;
    queue<pair<int,int>> door[26];
    q.push({0,0});
    while(!q.empty()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++){
            int py = y + hy[i];
            int px = x + hx[i];
            int &nxt = building_map[py][px];
            if(py<0||py>h+1||px<0||px>w+1) continue;
            if(visit[py][px]==0&&nxt!=-1){
                visit[py][px]=1;
                if(nxt==36){
                    score++;
                    nxt = 0;
                    q.push({py,px});
                }
                else if(nxt >= 65 && nxt <= 90){
                    if(player_key[nxt-65] == 1){
                        q.push({py, px});
                        nxt = 0;
                    }
                    else{
                        door[nxt-65].push({py,px});
                    }
                }
                else if(nxt >= 97 && nxt <= 122){
                    q.push({py,px});
                    if(player_key[nxt-97] == 0){
                        player_key[nxt-97] = 1;
                        while(!door[nxt-97].empty()){
                            q.push(door[nxt-97].front());
                            door[nxt-97].pop();
                        }
                    }
                    nxt = 0;
                }
                else{
                    q.push({py, px});
                }
            }
        }
    }
    cout << score << endl;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    int T;
    cin>>T;
    for(int test_case = 1; test_case<=T;test_case++){
        init();
        input();
        sol();
    }
}

