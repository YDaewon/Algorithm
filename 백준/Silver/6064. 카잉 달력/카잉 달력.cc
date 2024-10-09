#include <iostream>
using namespace std;

int main(){
    int t,m,n,x,y,ty;
    cin>>t;
    while(t--){
        cin>>m>>n>>x>>y;
        x--;
        y--;
        bool flag=false;
        for(ty = x; ty<m*n; ty+=m){
            if(ty%n==y){
                flag=true;
                break;
            }
        }
        if(flag)
            cout<<ty+1<<"\n";
        else
            cout<<-1<<"\n";
    }
}