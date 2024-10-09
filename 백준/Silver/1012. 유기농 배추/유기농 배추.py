# 1012
import sys

sys.setrecursionlimit(10000)
T = int(input())


def dfs(x, y):
    if x <= -1 or x >= m or y <= -1 or y >= n:
        return 0
    if board[y][x] == 1:
        board[y][x] = 2
        dfs(x, y + 1)
        dfs(x + 1, y)
        dfs(x - 1, y)
        dfs(x, y - 1)
        return 1
    return 0


for _ in range(T):
    m, n, k = map(int, input().split())
    board = [[0] * m for _ in range(n)]
    count = 0
    for i in range(k):
        a, b = map(int, input().split())
        board[b][a] = 1
    for y in range(0, n):
        for x in range(0, m):
            if dfs(x, y):
                count += 1
    print(count)