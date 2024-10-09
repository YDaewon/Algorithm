#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n,m,k,t;
vector<int> card;
int parant[4000001];

int find(int a){
    if(a==parant[a]) return a;
    else return find(parant[a]);
}

void uni(int a, int b){
    a=find(a);
    b=find(b);
    if(a<b) parant[a]=b;
    else parant[b]=a;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin>>n>>m>>k;
    for(int i=0;i<m;i++){
        cin>>t;
        card.push_back(t);        
    }
    sort(card.begin(),card.end());
    for(int i=0;i<m;i++) parant[i]=i;
    while(k--){
        cin>>t;
        int i=lower_bound(card.begin(),card.end(),t+1)-card.begin();
        cout<<card[find(i)]<<"\n";
        if(i<m) uni(find(i),find(i)+1);
    }
}