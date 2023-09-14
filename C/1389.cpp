#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int graph[101][101];
    int n, m, f, s;
    int min_bacon = 101;
    int bacon[101];
    cin >> n >> m;
    for (int i = 1;i <= n;i++) {
        bacon[i] = 0;
        for (int j = 1;j <= n;j++) {
            if (i == j) graph[i][j] = 0;
            else graph[i][j] = n + 1;
        }
    }
    for (int i = 0;i < m;i++) {
        cin >> f >> s;
        graph[f][s] = 1;
        graph[s][f] = 1;
    }
    for (int k = 1;k <= n;k++) { //���İ� ���
        for (int i = 1;i <= n;i++) { // ��ü��忡 ���� Ȯ��
            for (int j = 1;j <= n;j++) {
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);
            }
        }
    }
    for (int i = 1;i <= n;i++) {
        for (int j = 1;j <= n;j++) {
            bacon[i] += graph[i][j];
        }
        if (min_bacon > bacon[i])
            min_bacon = bacon[i];
    }
    for (int i = 1;i <= n;i++) {
        if (min_bacon == bacon[i]) {
            cout << i;
            break;
        }
    }
}