import collections


def factorization(x):  # 소인수분해
    d = 2
    dic = []
    num = x
    while d <= num:
        if num % d == 0:
            dic.append(d)
            num = num / d
        else:
            d = d + 1
    if x == 1:
        dic.append(1)
    return collections.Counter(dic).items()


def sum_digit(str):
    sum = 0
    for i in str:
        sum += int(i)
    if sum % 2 == 0:
        return 0
    else:
        return 1


x = int(input())
count = 0
if x > 5 and sum_digit(str(x)):
    count += 1
if x == 2 or x == 4 or len(factorization(x)) % 2 == 0:
    count += 2

if count == 0:
    print(3)
elif count == 1:
    print(1)
elif count == 2:
    print(2)
elif count == 3:
    print(4)
