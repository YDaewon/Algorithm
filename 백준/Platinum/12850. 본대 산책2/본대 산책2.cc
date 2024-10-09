#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
#define MOD 1000000007
typedef long long ll;
typedef vector<ll> v;
typedef vector<v> vv;

vv map = { {0,1,1,0,0,0,0,0},
           {1,0,1,1,0,0,0,0},
           {1,1,0,1,1,0,0,0},
           {0,1,1,0,1,1,0,0},
           {0,0,1,1,0,1,0,1},
           {0,0,0,1,1,0,1,0},
           {0,0,0,0,0,1,0,1},
           {0,0,0,0,1,0,1,0}};
vv ans;
int d;

vv mul(vv m1, vv m2, int row, int col, int mid){
    vv val(row,v(col));
    for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++){
            val[i][j]=0;
            for(int k = 0; k < mid; k++){
                val[i][j] += m1[i][k] * m2[k][j];
                val[i][j] %= MOD;
            }
        }
    }
    return val;
}

void sol(){
    for(int i = 0; i < 8; i++){
        v t;
        for(int j = 0; j < 8; j++){
            if(i == j) t.push_back(1);
            else t.push_back(0);
        }
        ans.push_back(t);
    }
    while(d > 0){
        if(d & 1){
            ans = mul(ans,map,8,8,8);
        }
        map =  mul(map, map,8,8,8);
        d >>= 1;
    }
    cout << ans[0][0];
}

int main(){
    cin>>d;
    sol();
}