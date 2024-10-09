# 1449
N, L = map(int, input().split())
water = list(map(int, input().split()))
water.sort()

count = 1
start = water[0] - 0.5 + L

for i in water:
    if start < i:
        count += 1
        start = i + L - 0.5
    #print(i, count, "태이프로 막음")
print(count)
