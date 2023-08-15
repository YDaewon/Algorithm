#include <iostream>
#include <vector>
#include <string>
using namespace std;

int N = 0;
int num;

vector<int> Weight;
vector<int> Score;
int Bag[21][101];   // 최대가치의 저장, i: 현재 넣은 물건의 번호, j: 배낭의 최대 무게

void DP() {
	for (int i = 1; i <= N; i++) {  //사람의 수
		//cout << "i = " << i << endl;
		for (int j = 1; j <= 100; j++) {
			if (Weight[i] >= j) {    // 지금 넣으려는 물건의 무게가 베낭 무게이상이면
				Bag[i][j] = Bag[i - 1][j];   // 안넣는다(무게를 딱맞춰도 0으로 처리)
			}
			else { // 작다면
				Bag[i][j] = max(Bag[i - 1][j], Bag[i - 1][j - Weight[i]] + Score[i]); // 안넣거나, 넣거나(둘중에 큰거)
			}
			//cout << Bag[i][j]<< " ";
		}
		//cout << endl;
	}
	cout << Bag[N][100] << endl;
}

int main() {
	cin >> N;
	Weight.push_back(0);
	for (int i = 0; i < N; i++) {
		cin >> num;
		Weight.push_back(num);
	}
	Score.push_back(0);
	for (int i = 0; i < N; i++) {
		cin >> num;
		Score.push_back(num);
	}
	DP();
}