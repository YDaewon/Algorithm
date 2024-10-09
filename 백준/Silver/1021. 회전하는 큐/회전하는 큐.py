#1021
from collections import deque

q= deque()
count = 0
N, M = map(int, input().split(" "))
W = [0] * M
W = list(map(int, (input().split(" "))))
for i in range(N):
    q.append(i + 1)
for i in range(M):
    while True:
        if q[0] == W[i]:
            q.popleft()
            break
        else:
            if q.index(W[i]) > len(q) // 2:
                q.rotate(1) #왼쪽으로 한칸 옮기기
                count += 1
            else:
                q.rotate(-1) #오른쪽으로 한칸 옮기기
                count += 1

print(count)