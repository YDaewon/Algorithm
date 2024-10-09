import sys
n = int(sys.stdin.readline())
point_x = [[] for _ in range(100000)]
point_y = [[] for _ in range(100000)]
for i in range(n):
    x, y = map(int, sys.stdin.readline().split())
    point_x[x].append(y)
    point_y[y].append(x)

result = 0
for i in point_y:
    if len(i) != 0:
        i.sort()
        for j in range(0, len(i) - 1, 2):
            result += i[j+1] - i[j]
for i in point_x:
    if len(i) != 0:
        i.sort()
        for j in range(0, len(i) - 1, 2):
            result += i[j+1] - i[j]
print(result)