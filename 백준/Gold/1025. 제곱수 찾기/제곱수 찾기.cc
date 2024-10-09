#include <iostream>
#include <string>
#include <algorithm>
#include <math.h>
using namespace std;

char board[10][10];

bool perfect(int num){
    return sqrt(num) == (int)sqrt(num);
}
int main(){
    int n,m;
    cin >> n>>m;
    for(int i = 0; i< n;i++){       
        for(int j =0;j<m;j++){
            cin >> board[i][j];
        }
    }
    int anr = -1;
    for(int i = 0; i < n; i++){       
        for(int j = 0; j < m; j++){
            for(int dy = -n; dy <= n; dy++){       
                for(int dx = -m; dx <= m; dx++){           
                    if(dy==0 && dx==0) continue;
                    int y=i;
                    int x=j;
                    string t="";
                    while(y>=0 && y<n && x>=0 && x<m){
                        t+=board[y][x];
                        if(perfect(stoi(t))) 
                            anr=max(anr, stoi(t));
                        y+=dy;
                        x+=dx;
                    }
                }
            }
        }
    }
    cout << anr;
}
        
    