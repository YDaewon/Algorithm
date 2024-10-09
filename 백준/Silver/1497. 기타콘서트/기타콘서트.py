import sys
from itertools import combinations

n, m = map(int, sys.stdin.readline().split())
guiter = []

for _ in range(n):
    garbage, music = sys.stdin.readline().split()
    temp = [0] * m
    for i in range(m):
        if music[i] == 'Y':
            temp[i] = 1
    guiter.append(temp)

count_guiter = 0
count_music = 0

for i in range(1, n+1):
    combi = list(combinations(guiter, i))
    for j in combi:
        count = 0
        result = [0] * m
        #print(j, end=" ")
        for k in range(len(j)):
            for idx in range(m):
                if j[k][idx]:
                    result[idx] = 1
        #print(result)
        for r in result:
            if r == 1:
                count += 1
        flag = False
        if count > count_music:
            count_music = count
            flag = True
        if flag:
            count_guiter = len(j)

if count_music == 0:
    print(-1)
else:
    #print(count_music, count_guiter)
    print(count_guiter)