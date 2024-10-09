#include <iostream>
#include <string>
using namespace std;

void draw_tile(int n, int r1, int c1, int r2, int c2){
    int x,y,d;
    for(int i = r1;i<=r2;i++){
        for(int j = c1; j<= c2; j++){
            y = i % (2*n-1);
            x = j % (2*n-1);
            d = abs((n-1)-x)+abs((n-1)-y);
            if(d>=n)
                cout<<".";
            else
                cout<<char(97+(d%26));
        }
        cout << "\n";
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    int n,r1,c1,r2,c2;
    cin >> n >> r1 >> c1 >> r2 >> c2;
    draw_tile(n, r1,c1,r2,c2);
}