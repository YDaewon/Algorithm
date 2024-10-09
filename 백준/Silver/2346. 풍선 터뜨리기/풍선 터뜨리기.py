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