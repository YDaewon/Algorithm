#include <iostream>
#include <string>
using namespace std;

string num,answer;
int n,mid;

int compare(){
    for(int i = 0;i<n;i++){
        if(num[i]>answer[i]) return 1;
        else if (num[i]<answer[i]) return 0;
    }
    return 1;
}

int main(){
    cin>>num;
    answer=num;
    n=num.size();
    mid=n/2;
    string nine(n,'9');
    if(num==nine){
        answer[0]='1';
        for(int i=1;i<n;i++) answer[i]='0';
        answer.insert(answer.end(),'1');
        cout << answer;
        return 0;
    }
    
    for(int i=0;i<n;i++){
        if(i<n/2) answer[i]=num[i];
        else answer[i]=num[n-1-i];
    }
    while(compare()){
        answer[mid]++;
        if(mid!=n-1-mid){
            answer[n -1 -mid]++;
        }
        while(answer[mid]-'0'>9 && answer[n-1-mid]-'0'>9){
            answer[mid]='0';
            answer[n-1-mid]='0';
            mid--;
            answer[mid]++;
            answer[n-1-mid]++;
        }
    }
    cout << answer;
}
    