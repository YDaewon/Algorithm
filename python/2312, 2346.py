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


#2346
from collections import deque
N = int(input())
que = deque(enumerate(map(int, input().split())))
result = []
while len(que) >= 1:
    idx, value = que.popleft()
    print(idx+1, end=" ")
    if value > 0:
        que.rotate(-value + 1)
    else:
        que.rotate(-value)
