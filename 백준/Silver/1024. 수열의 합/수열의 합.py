import sys
N, L = map(int, sys.stdin.readline().split())
for i in range(L, 101):
    Lx = N - ((i *(i+1)) / 2)
    if Lx >= -L and Lx % i ==0:
        x = int(Lx/i)
        for j in range(1, i+1):
            print(x + j, end=" ")
        break
else:
    print(-1)