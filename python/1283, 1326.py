import sys
n = int(sys.stdin.readline())
alphabet = []
for _ in range(n):
    string = list(sys.stdin.readline().split())
    flag = True
    for i in range(len(string)):
        if string[i][0] not in alphabet:
            alphabet.append(string[i][0].lower())
            alphabet.append(string[i][0].upper())
            string[i] = "[" + string[i][0] + "]" + string[i][1:]
            print(" ".join(string))
            flag =False
            break
    if flag:
        for i in range(len(string)):
            if flag:
                for j in range(len(string[i])):
                    if string[i][j] not in alphabet:
                        alphabet.append(string[i][j].lower())
                        alphabet.append(string[i][j].upper())
                        string[i] = string[i][:j] + "[" + string[i][j] + "]" + string[i][j + 1:]
                        print(" ".join(string))
                        flag = False
                        break
    if flag:
        print(" ".join(string))



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