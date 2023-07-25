# 1904
'''
n = int(input())
d = [0, 1, 2]
for i in range(3, n + 1):
    d.append((d[i - 2] + d[i - 1]) % 15746)
print(d[n])
'''

# 1913
n = int(input())
board = [[0] * n for _ in range(n)]
x, y = n // 2, n // 2
board[y][x] = 1
i = -1
what = int(input())
point = []
up, down, left, right = 0, 0, 0, 0
num = 1
while num < n * n:
    if up == 0 and down == 0 and left == 0 and right == 0:
        i += 2
        up, right, down, left = i, i, i + 1, i + 1
    num += 1
    if up > 0:
        y -= 1
        up -= 1
    elif right > 0:
        x += 1
        right -= 1
    elif down > 0:
        y += 1
        down -= 1
    elif left > 0:
        x -= 1
        left -= 1
    board[y][x] = num

for i in range(n):
    for j in range(n):
        #print('%2.0f' % board[i][j], end=" ")
        print(board[i][j], end=" ")
        if board[i][j] == what:
            point.append(i + 1)
            point.append(j + 1)
    print()
for i in point:
    print(i, end=" ")
