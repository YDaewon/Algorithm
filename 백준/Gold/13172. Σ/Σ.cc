#include <iostream>

#include <cmath>

using namespace std;

#define MOD 1000000007 // 나눠주는 X

int N,S;

// 분할정복(b의 역원 구하기) x -> b, y -> 지수

long long getReverse(long long x,long long y){

    if(y == 1) return x;

    

    if(y % 2 == 1) return (x * getReverse(x,y-1))%MOD;

    long long val = getReverse(x,y/2);

    return (val*val)%MOD;

}

int main(){

    cin.tie(0); cout.tie(0); ios::sync_with_stdio(false);

    int M;

    cin >> M;

    long long ans = 0;

    while(M--){

        cin >> N >> S;

        long long val = (S*getReverse(N,MOD-2))%MOD;

        ans += (val%MOD);

    }

    cout << ans%MOD;

}