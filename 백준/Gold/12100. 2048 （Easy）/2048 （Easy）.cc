#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int board[20][20]={0,};
int n, ans =0;

void input(){
    cin>>n;
    for(int i=0;i<n;i++)
        for(int j =0;j<n;j++)
            cin>>board[i][j];
}

void calc(int d){
    queue<int> q;
    int idx;
    if(d==0){
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                if(board[y][x]) {
                    q.push(board[y][x]);
                    board[y][x]=0;
                }
            }
            idx = 0;
            while(!q.empty()){
                int val = q.front();
                q.pop();
                if(board[idx][x]==0) board[idx][x]=val;
                else if (board[idx][x]==val){
                    board[idx][x] *= 2;                   
                    idx++;
                }
                else{
                    idx++;
                    board[idx][x]=val;
                }
            }
        }        
    }
    else if(d==1){
        for(int x = 0; x < n; x++){
            for(int y = n-1; y >= 0; y--){
                if(board[y][x]) {
                    q.push(board[y][x]);
                    board[y][x]=0;
                }
            }           
            idx = n-1;
            while(!q.empty()){
                int val = q.front();
                q.pop();
                if(board[idx][x]==0) board[idx][x]=val;
                else if (board[idx][x]==val){
                    board[idx][x] *= 2;                  
                    idx--;
                }
                else{
                    idx--;
                    board[idx][x]=val;
                }
            }
        }
    }
    else if(d==2){
        for(int y = 0; y < n; y++){
            for(int x = 0; x < n; x++){
                if(board[y][x]) {
                    q.push(board[y][x]);
                    board[y][x]=0;
                }
            }
            idx = 0;
            while(!q.empty()){
                int val = q.front();
                q.pop();
                if(board[y][idx]==0) board[y][idx]=val;
                else if (board[y][idx]==val){
                    board[y][idx] *= 2;
                    idx++;
                }
                else{
                    idx++;
                    board[y][idx]=val;
                }
            }
        }
    }
    else{
        for(int y = 0; y < n; y++){
            for(int x = n-1; x >= 0; x--){
                if(board[y][x]) {
                    q.push(board[y][x]);
                    board[y][x]=0;
                }
            }
            idx = n-1;
            while(!q.empty()){
                int val = q.front();
                q.pop();
                if(board[y][idx]==0) board[y][idx]=val;
                else if (board[y][idx]==val){
                    board[y][idx] *= 2;     
                    idx--;
                }
                else{
                    idx--;
                    board[y][idx]=val;
                }
            }
        }
    }
}

void sol(int depth){
    if(depth==5) return;
    int t_board[20][20];
    for(int i=0;i<n;i++)
        for(int j =0;j<n;j++)
            t_board[i][j]=board[i][j];
    for(int d =0;d<4;d++){
        calc(d);
        sol(depth+1);
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                ans=max(ans,board[i][j]);
                board[i][j]=t_board[i][j];
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    input();
    sol(0);
    cout << ans;
}
        
                
        