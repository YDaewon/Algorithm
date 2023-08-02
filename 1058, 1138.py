'''
#1058번
N = int(input()) #친구 찾는걸 조건 별로 나눠서 했음
friend = []
f = [[0] * N for _ in range(N)]
result = 0
for i in range(N):
    friend.append(list(input()))

for k in range(N):
    for i in range(N):
        for j in range(N):   # 공통인 친구가 있는걸 찾는
            if j == i:   #자기 자신은 친구가 될 수 없다
                continue
            if friend[i][j] == 'Y' or (friend[i][k] == 'Y' and friend[k][j] == 'Y'):
                f[i][j] = 1

for i in f:
    result = max(result, sum(i))
print(result)
'''

#1138번
N = int(input())
in_line = list(map(int, input().split()))
result = [0] * N
# 왼쪽에서 몇번째로 들어가야되는지 판별
count = 0
for i in range(N):
    count = 0
    for j in range(N):
        if result[j] == 0 and count == in_line[i]: # count가 맞아도, 그 자리에 이미 누군가가 있으면 한칸 뒤로 가서 재검사
            result[j] = i + 1
            break
        elif result[j] == 0:
            count += 1
for i in result:
    print(i)