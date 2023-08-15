#1515번
'''
n = input()
i = 0
while True:
    i += 1
    num = str(i)
    while len(num) > 0 and len(n) > 0:
        if n[0] == num[0]:
            n = n[1:]
        num = num[1:]
    if len(n) == 0:
        print(i)
        break
'''


#1560

n = int(input())
print(n if n < 3 else 2*(n-1))

