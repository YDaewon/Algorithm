#1166
N, L, W, H = map(int, input().split(" "))
left = 0
right = 1000000000
for i in range(100):
    mid = (left + right) / 2
    if ((L // mid) * (W // mid) * (H // mid)) >= N:
        left = mid
    else:
        right = mid

print("%.10f" % left)
