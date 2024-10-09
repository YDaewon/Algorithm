#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case){
		int arr[3];
        int cnt = 0;
        for(int i = 0; i < 3; i++){
            cin >> arr[i];
        }
        for(int i = 2; i > 0; i--){
            if(arr[i] <= i){
                cnt = -1;
                break;
            }
            if(arr[i] <= arr[i-1]){
                int temp = arr[i-1];
                arr[i-1] = arr[i]-1;
            	cnt += temp - arr[i-1];
            }
        }
        cout <<"#"<< test_case << " "<< cnt << endl;
	}
    return 0;
}