# 2312
from collections import Counter
N= int(input())
for _ in range(N):
    num = int(input())
    soinsu = []
    count = 2
    while num > 1:
        while num % count == 0:
            soinsu.append(count)
            num //= count
        count += 1
    result = Counter(soinsu)
    for key, value in result.items():
        print(key, value)