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