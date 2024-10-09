import sys
from collections import deque

def count(s, e):
    visit = [-1] * (n+1)
    visit[s] = 0
    q = deque([s])
    while q:
        now = q.popleft()
        for i in range(now, n+1, bridge[now]):
            if visit[i] == -1:
                visit[i] = visit[now]+1
                q.append(i)
                if i == e:
                    return visit[i]
        for i in range(now, 0, -bridge[now]):
            if visit[i] == -1:
                visit[i] = visit[now]+1
                q.append(i)
                if i == e:
                    return visit[i]     
    return -1

n = int(sys.stdin.readline())
bridge = [0] + list(map(int, sys.stdin.readline().split()))
start, end = map(int, sys.stdin.readline().split())
print(count(start, end))