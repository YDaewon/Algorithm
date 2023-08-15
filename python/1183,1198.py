import sys
n = int(sys.stdin.readline())
wait = []
for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    wait.append(b-a)

wait.sort()
half = n // 2
count = 0
if n % 2 == 0:
    count = wait[half] - wait[half-1] + 1
else:
    count = 1
print(count)

from itertools import combinations
import sys

n = int(sys.stdin.readline())
num_list = []
for _ in range(n):
    temp = list(map(int, sys.stdin.readline().split()))
    num_list.append(temp)

num_combi = list(combinations(num_list, 3))
result = 0
for a, b, c in num_combi:
    area = abs(((a[0] * b[1]) + (b[0] * c[1]) + (c[0] * a[1])) - ((a[1] * b[0]) + (b[1] * c[0]) + (c[1] * a[0]))) / 2
    if result < area:
        result = area
print(result)
