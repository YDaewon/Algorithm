'''
#1972
while True:
    D_str= input()
    if D_str == '*':
        break
    d = 1
    while d < len(D_str):
        result =[]
        for i in range(len(D_str)- d):
            result.append(D_str[i] + D_str[i+d])
        #print(result)
        if len(result) != len(set(result)):
            print(D_str, "is NOT surprising.")
            break
        else:
            d += 1
    if d ==(len(D_str)) :
        print(D_str, "is surprising.")
'''
#2012
n = int(input())
grade = []
result = 0
for _ in range(n):
    grade.append(int(input()))

nsum = n * (n+1) // 2
print(abs(nsum - sum(grade)))

grade.sort()
print(grade)

for i in range(1, n + 1):
    result += abs(i - grade[i-1])
print(result)