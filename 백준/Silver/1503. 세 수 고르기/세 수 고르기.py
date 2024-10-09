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