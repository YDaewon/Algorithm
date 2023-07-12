# 1051
N, M = map(int, input().split(" "))
S = [list(map(int, (input()))) for _ in range(N)]
r = min(N, M)
count = 0


def func(k):  # 정사각형의 크기가 매개 변수, 인덱스 초과 하지 않도록 하기 위함
    for i in range(N - k + 1):
        for j in range(M - k + 1):
            if S[i][j] == S[i][j + k - 1] == S[i + k - 1][j] == S[i + k - 1][j + k - 1]:
                return 1


for k in range(r, 0, -1):
    if func(k):
        print(k ** 2)
        break
