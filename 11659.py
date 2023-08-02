#11659번
import sys

N, M = map(int, sys.stdin.readline().split())
board = list(map(int, sys.stdin.readline().split()))
board_sum = [board[0]]
for j in range(1, N):
    board_sum.append(board[j] + board_sum[j - 1])

for i in range(M):   # x가 세로, y가 가로
    x1, x2 = map(int, sys.stdin.readline().split())
    x1 -= 1
    x2 -= 1
    if x1 - 1 >= 0:
        print(board_sum[x2] - board_sum[x1 - 1])
    else:
        print(board_sum[x2])