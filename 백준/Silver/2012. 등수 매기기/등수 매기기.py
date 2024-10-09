import sys
n = int(sys.stdin.readline())
grade = []
for _ in range(n):
    grade.append(int(sys.stdin.readline()))
grade.sort()
result = 0
for i in range(1, n + 1):
    result += abs(i - grade[i-1])
print(result)