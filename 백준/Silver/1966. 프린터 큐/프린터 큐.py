# 1966번
test = int(input())
for _ in range(test):
    n, m = map(int, input().split())
    proprity = input().split()
    count = 0
    while True: #가장 큰 출자 국음 때 까지 반복
        a = 0
        for i in proprity: #max함수
            if a < int(i):
                a = int(i)
        temp = int(proprity[0])
        del proprity[0]
        if a == temp:
            count += 1
            if m == 0:
                print(count)
                break
        else:
            proprity.append(temp)
        m -= 1
        if m < 0:
            m = len(proprity) - 1