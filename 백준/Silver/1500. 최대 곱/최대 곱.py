import sys
s, k = map(int, sys.stdin.readline().split())
#   (s/k) ** k >= 합이 s인 k개의 자연수 조합의 곱
mod = s % k
result = [0] * k
result.append(1)
for i in range(k):
    result[i] = s//k
for i in range(mod):
    result[i % k] += 1
for i in range(k):
    result[k] *= result[i]
print(result[k])
            