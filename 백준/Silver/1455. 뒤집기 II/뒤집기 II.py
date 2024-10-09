import sys
n, m = map(int, sys.stdin.readline().split())
square = []
for _ in range(n):
    coin = list(map(int, sys.stdin.readline().strip()))
    square.append(coin)

def turn(row, col):
    for i in range(row, -1, -1):
        for j in range(col, -1, -1):
            if square[i][j]:
                square[i][j] = 0
            else:
                square[i][j] = 1
                
count = 0
for row in range(n-1, -1, -1):
    for col in range(m-1, -1, -1):
        if square[row][col]:
            turn(row, col)
            count += 1
print(count)