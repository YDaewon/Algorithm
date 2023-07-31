
#2108
import sys
from collections import Counter
N= int(sys.stdin.readline())
num= []
for _ in range(N):
    num.append(int(sys.stdin.readline()))
num.sort()
print(round(sum(num) /N)) # 산술평균
print(num[(N-1)//2]) # 중앙 값
count = Counter(num)
temp = []
for key, value in count.items():
    if value == max(count.values()):
        temp.append(key)
if len(temp) > 1:
    temp.sort()
    del temp[0]
print(temp[0])  # 최빈값
print(max(num) - min(num)) # 범위

#2193
N= int(input())
temp = [1,1]+[0 for _ in range(N-2)]
for i in range(2,N):
    temp[i] = temp[i-2] + temp[i-1]
print(temp[N-1])

def result(one_or_zero, N):
    if N == 1:
        return 1
    if one_or_zero == 0:
        return result(0, N-1) + result(1, N-1)
    else:
        return result(0, N-1)

N= int(input())
print(result(1, N))