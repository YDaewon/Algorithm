#include <iostream>
using namespace std;

int n;
char star[3073][6145];

void sol(int y, int x, int d){
    if(d==3){
        star[y][x]='*';
        star[y+1][x-1]='*';
        star[y+1][x+1]='*';
        for(int i = -2;i<3;i++){
            star[y+2][x+i]='*';
        }
    }
    else{
        sol(y,x,d/2);
        sol(y+d/2,x-d/2,d/2);
        sol(y+d/2,d+x-d/2,d/2);
    }
}

int main(){
    cin>>n;
    for(int i = 1;i<=n;i++){
        for(int j = 1; j<= 2*n-1;j++){
            star[i][j]=' ';
        }
    }
    sol(1,n,n);
    for(int i = 1;i<=n;i++){
        for(int j = 1; j<= 2*n-1;j++){
            cout<<star[i][j];
        }
        cout<<endl;
    }
}