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