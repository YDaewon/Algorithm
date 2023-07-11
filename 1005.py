from collections import deque
import sys


T=int(sys.stdin.readline())  # 테스트 케이스 수
for _ in range(T):
    N, K = map(int, sys.stdin.readline().split(" "))  # N: 건물의 개수, K: 규칙의 개수
    cost = [0] + list(map(int, sys.stdin.readline().split(" ")))  # 건물 짓는데 드는 시간(비용)
    S = [[] for _ in range(N + 1)]  # 규칙 저장
    indegree = [0 for _ in range(N+1)]  # 위상 정렬 진입 차수
    ndc = [0] * (N + 1)

    for i in range(K):
        a, b = map(int, sys.stdin.readline().split(" "))
        S[a].append(b)
        indegree[b] += 1  # 차수 설정

    q = deque()
    for i in range(1, N + 1):  # 차수가 0인 자리를 보기 위해 큐에 삽입
        if indegree[i] == 0:
            q.append(i)
            ndc[i] = cost[i]

    while q:
        now = q.popleft()
        for i in S[now]:
            indegree[i] -= 1  # 차수 줄이고 비용 갱신
            ndc[i] = max(ndc[i], ndc[now] + cost[i])  # 건설 비용의 최대 값 설정
            if indegree[i] == 0:
                q.append(i)

    W = int(sys.stdin.readline())
    print(ndc[W])
