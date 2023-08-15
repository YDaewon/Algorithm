import sys

s, k = map(int, sys.stdin.readline().split())
#   (s/k) ** k >= 합이 s인 k개의 자연수 조합의 곱
mod = s % k
result = [0] * k
result.append(1)
for i in range(k):
    result[i] = s // k
for i in range(mod):
    result[i % k] += 1
for i in range(k):
    result[k] *= result[i]
print(result[k])

import sys

n, m = map(int, sys.stdin.readline().split())
S = list(map(int, sys.stdin.readline().split()))
result = 100000000
for i in range(1, 1001):
    if i in S:
        continue
    for j in range(i, 1001):
        if j in S:
            continue
        for k in range(j, 1002):
            if k not in S:                
                xyz = i * j * k
                result= min(result, abs(n-xyz))
                if xyz > n+1:
                    break
print(result)