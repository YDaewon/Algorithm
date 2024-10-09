#include <iostream>
#include <vector>
#include <map>
using namespace std;

int n;
vector<int> in;
map<int,int> idx;
vector<int> post;

void input(){
    cin>>n;
    in.resize(n);
    post.resize(n);
    for(int i=0;i<n;i++) {
        cin>>in[i];
        idx[in[i]]=i;
    }
    for(int i=0;i<n;i++) cin>>post[i];
}

void sol(int il, int ir, int pl, int pr){
    if(il<=ir&&pl<=pr){
        int root = post[pr];
        cout<< root<< " ";
        int left = idx[root]-il;
        sol(il,idx[root]-1,pl,pl+left-1);
        sol(idx[root]+1,ir,pl+left,pr-1);
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    input();
    sol(0,n-1,0,n-1);
}