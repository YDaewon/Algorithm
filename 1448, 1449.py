# 1448
from itertools import combinations
import sys

N = int(sys.stdin.readline())
angle = []
result = -1

for _ in range(N):
    angle.append(int(sys.stdin.readline()))
angle.sort()
#print(angle)

#com_angle = list(combinations(angle, 3))
#print(com_angle)
for i in range(len(angle) - 1, 1, -1):
    cond = angle[i-1] + angle[i-2]
    if angle[i] < cond:
        result = angle[i] + cond
        break
print(result)


# 1449
N, L = map(int, input().split())
water = list(map(int, input().split()))
water.sort()

count = 1
start = water[0] - 0.5 + L

for i in water:
    if start < i:
        count += 1
        start = i + L - 0.5
    print(i, count, "태이프로 막음")
print(count)
