#include <iostream>
#include <math.h>
#include <string>
using namespace std;

bool f(string n){
    for(int i =0;i <n.size()/2;i++){
        if(n[i] != n[n.size()-(1+i)]) return false;
    }
    return true;
}

bool prime(int n){
    for(int i =2; i<= sqrt(n);i++){
        if(n%i==0) return false;
    }
    return true;
}

int main(){
    int n;
    cin >> n;
    if(n==1) n++;
    while(1){
        if(f(to_string(n)) && prime(n)) break;
        n++;
    }
    cout << n;
}