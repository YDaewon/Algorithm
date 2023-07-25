# 1783
'''
n, m = map(int, input().split())
if n >= 3 and m > 7:
    print(m - 2)
elif n >= 3 and m <= 7:
    print(min(m, 4))
elif n == 2:
    print(min(4, (m - 1) // 2 + 1))
elif n == 1 or m == 1:
    print(1)
'''

# 1788
def fibo(num):
    if num == 0:
        return 0
    elif num == 1:
        return 1
    array = [0, 1]
    for i in range(2, num+1):
        n = (array[i-1] + array[i-2]) % 1000000000
        array.append(n)
    return array[num]



n = int(input())
if n < 0:
    if abs(n) % 2 == 0:
        print(-1)
    else:
        print(1)
    print(fibo(abs(n)))
else:
    if n == 0:
        print(0)
    else:
        print(1)
    print(fibo(n))
