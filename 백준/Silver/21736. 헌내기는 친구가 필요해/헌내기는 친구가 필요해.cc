#define _CRT_SECURE_NO_WARNINGS

#include <iostream>

#include <cstdio>

#include <algorithm>

#include <vector>

#include <queue>

#include <cstring>

#include <string>

#include <cmath>

#define P pair<int,int>

#define F first

#define S second

using namespace std;

int N, M;

char map[601][601];

int check[601][601];

int dx[4] = {1,0,-1,0};

int dy[4] = {0,1,0,-1};

P start;

int bfs(){

    int Friend = 0;

    queue<P> q;

    q.push(start);

    check[start.F][start.S] = 1;

    while(!q.empty()){

        int x = q.front().F;

        int y = q.front().S;

        q.pop();

        for(int i = 0; i < 4; i++){

            int xx = x + dx[i];

            int yy = y + dy[i];

            if(xx >= 1 && xx <= N && yy >= 1 && yy <= M){

                if(check[xx][yy] == 0){

                    if(map[xx][yy] == 'P'){

                        check[xx][yy] = 1;

                        q.push({xx,yy});

                        Friend++;

                    }

                    else if(map[xx][yy] == 'O'){

                        check[xx][yy] = 1;

                        q.push({xx,yy});

                    }

                }

            }

        }

    }

    return Friend;

}

void solve(){

    int ans = bfs();

    if(ans == 0) cout << "TT";

    else cout << ans;

}

int main() {

    cin.tie(0);

    cout.tie(0);

    cin >> N >> M;

    for(int i = 1; i <= N; i++){

        for(int j = 1; j <= M; j++){

            cin >> map[i][j];

            if(map[i][j] == 'I') start = {i,j};

        }

    }

    solve();

    return 0;

}