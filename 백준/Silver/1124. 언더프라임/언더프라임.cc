#include <iostream>
#include <math.h>
#include <vector>
using namespace std;

vector<bool> num(100001, true);
vector<int> arr(100001, 0);
int a,b;

void mk_prime(int x){
   num[0] = false;
   num[1] = false;
   int rx = sqrt(x);
   for(int i = 2; i <= b; i++){
       if(num[i]){
           for(int j = 2*i; j <= x; j += i){
               num[j] = false;
               int cur = j;
               while (cur % i ==0){
                   cur /= i;
                   arr[j]++;
               }
           }            
       }
   }
}


int under_prime(int x){
    if(num[arr[x]])
        return 1;
    else
        return 0;   
}
 
int main(){
    cin >> a >> b;
    int result = 0;
    mk_prime(100000);
    for(int i = a; i <= b; i++)
        result += under_prime(i);
    cout << result;
}
          