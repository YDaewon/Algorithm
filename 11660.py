import sys

N, M = map(int, sys.stdin.readline().split())
board = []
board_sum = [[0] * N for _ in range(N)]
result = []
for i in range(N):
    board.append(list(map(int, sys.stdin.readline().split())))
    board_sum[i][0] = board[i][0] + board_sum[i - 1][0]
    for j in range(1, N):
        board_sum[i][j] = board[i][j] + board_sum[i][j - 1] + board_sum[i - 1][j] - board_sum[i - 1][j - 1]

for _ in range(M):  # x가 세로, y가 가로
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    x1 -= 1
    y1 -= 1
    x2 -= 1
    y2 -= 1
    p_sum = board_sum[x2][y2]
    if x1 != 0:
        p_sum -= board_sum[x1 - 1][y2]
    if y1 != 0:
        p_sum -= board_sum[x2][y1 - 1]
    if x1 != 0 and y1 != 0:
        p_sum += board_sum[x1 - 1][y1 - 1]
    result.append(p_sum)

for end in result:
    print(end)