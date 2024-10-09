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