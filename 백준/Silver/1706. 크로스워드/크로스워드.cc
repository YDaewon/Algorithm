#define _CRT_SECURE_NO_WARINGS
#include <iostream>
#include <vector>
#include <string>
#include <cstring>
#include <algorithm>

using namespace std;

int main(){
    int r,c;
    cin >> r >> c;
    vector<string> str_arr;
    vector<string> str;
    char input[20];
    char* tok;
    for (int i = 0; i< r; i++){
        cin >> input;
        str_arr.push_back(input);
        tok = strtok(input, "#");
        while(tok != NULL){
            if(strlen(tok) != 1) str.push_back(tok);
            tok = strtok(NULL, "#");
        }
    }
    for(int i=0;i<20;i++) input[i] = NULL;    
    for (int i = 0; i< c; i++){
        for (int j =0; j < r; j++) input[j] = str_arr[j][i];
        tok = strtok(input, "#");
        while(tok != NULL){
            if(strlen(tok) != 1) str.push_back(tok);
            tok = strtok(NULL, "#");
        }
    }
    sort(str.begin(),str.end());
    cout << str[0] << endl;
}