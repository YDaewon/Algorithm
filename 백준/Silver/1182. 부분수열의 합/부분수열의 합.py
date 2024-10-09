from itertools import combinations
import sys
N, S = map(int, sys.stdin.readline().split())
num_list = list(map(int, sys.stdin.readline().split()))
count = 0
for i in range(1, N + 1):
    combi = list(combinations(num_list, i))
    for j in combi:
        if sum(j) == S:
            count += 1
print(count)