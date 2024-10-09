from collections import deque
import sys


T=int(sys.stdin.readline())
for _ in range(T):
    N, K = map(int, sys.stdin.readline().split(" "))
    cost = [0] + list(map(int, sys.stdin.readline().split(" ")))
    S = [[] for _ in range(N + 1)]
    indegree = [0 for _ in range(N+1)]
    ndc = [0 for _ in range(N+1)]

    for _ in range(K):
        a, b = map(int, sys.stdin.readline().split(" "))
        S[a].append(b)
        indegree[b] += 1

    q = deque()
    for i in range(1, N + 1):
        if indegree[i] == 0:
            q.append(i)
            ndc[i] = cost[i]

    while q:
        now = q.popleft()
        for i in S[now]:
            indegree[i] -= 1
            ndc[i] = max(ndc[i], ndc[now] + cost[i])
            if indegree[i] == 0:
                q.append(i)

    W = int(sys.stdin.readline())
    print(ndc[W])
