#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>> tree;
int n;

void preorder(int s){
    if(s==-1)return;
    char c = s+'A';
    cout << c;
    preorder(tree[s][0]);
    preorder(tree[s][1]);
}

void inorder(int s){
    if(s==-1)return;
    inorder(tree[s][0]);
    char c = s+'A';
    cout << c;
    inorder(tree[s][1]);
}

void postorder(int s){
    if(s==-1)return;
    postorder(tree[s][0]);
    postorder(tree[s][1]);
    char c = s+'A';
    cout << c;    
}

void input(){
    cin>>n;
    tree.resize(n+1);
    char p,c1,c2;
    for(int i = 0;i<n;i++){
        cin>>p>>c1>>c2;
        if(c1!='.') tree[p-'A'].push_back(c1-'A');
        else tree[p-'A'].push_back(-1);
        
        if(c2!='.') tree[p-'A'].push_back(c2-'A');
        else tree[p-'A'].push_back(-1);
    }
}

int main(){
    input();
    preorder(0);
    cout<<endl;
    inorder(0);
    cout<<endl;
    postorder(0);
}
         
        