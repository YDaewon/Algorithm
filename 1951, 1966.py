# 결국 1~N까지의 문자열 길이
# 1951번
n = input()
str_len = len(n)
i = 2
result = 1
while str_len >= i:
    result += (i - 1) * 9 * (10 ** (i - 2))
    i += 1
result += str_len - 1
result += ((int(n[0]) - 1) * 10 ** (str_len - 1)) * str_len
if str_len > 1:
    result += int(n[1:]) * str_len

print(result % 1234567)

# 1966번
test = int(input())
for _ in range(test):
    n, m = map(int, input().split())
    proprity = input().split()
    count = 0
    while True:  # 가장 큰 출자 출력할 때 까지 반복
        a = 0
        for i in proprity:    # max 함수
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
