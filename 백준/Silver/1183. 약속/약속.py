import sys
n = int(sys.stdin.readline())
wait = []
for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    wait.append(b-a)

wait.sort()
half = n // 2
count = 0
if n % 2 == 0:
    count = wait[half] - wait[half-1] + 1
else:
    count = 1
print(count)