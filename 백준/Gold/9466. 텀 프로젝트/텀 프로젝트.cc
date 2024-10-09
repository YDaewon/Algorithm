#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int n,ans;
vector<int> student;
vector<int> visit;
vector<int> cycle;

void init(){
    student.clear();
    visit.clear();
    cycle.clear();
    ans=0;
}

void input(){
    init();
    cin>>n;
    student.resize(n+1);
    visit.resize(n+1);
    cycle.resize(n+1);
    for(int i=1;i<=n;i++){
        cin>>student[i];
        visit[i]=0; cycle[i]=0;
    }
}

void sol(int cur){
    visit[cur]=1;
    int next = student[cur];
    if(visit[next]==0) sol(next);
    else if (cycle[next]==0){
        int i = next;
        while(i!=cur){
            ans++;
            //cout<<i<<", ";
            i= student[i];
        }
        ans++;
        //cout<< cur<<"is cycle\n";
    }
    cycle[cur]=1;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    int T;
    cin >> T;
    while(T--){
        input();
        for(int i=1;i<=n;i++)
            if(visit[i]==0)sol(i);
        cout << n - ans<<"\n";
    }
}