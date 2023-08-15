#include <iostream>
#include <vector>
#include <string>
using namespace std;

int N = 0;
int num;

vector<int> Weight;
vector<int> Score;
int Bag[21][101];   // �ִ밡ġ�� ����, i: ���� ���� ������ ��ȣ, j: �賶�� �ִ� ����

void DP() {
	for (int i = 1; i <= N; i++) {  //����� ��
		//cout << "i = " << i << endl;
		for (int j = 1; j <= 100; j++) {
			if (Weight[i] >= j) {    // ���� �������� ������ ���԰� ���� �����̻��̸�
				Bag[i][j] = Bag[i - 1][j];   // �ȳִ´�(���Ը� �����絵 0���� ó��)
			}
			else { // �۴ٸ�
				Bag[i][j] = max(Bag[i - 1][j], Bag[i - 1][j - Weight[i]] + Score[i]); // �ȳְų�, �ְų�(���߿� ū��)
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