'''
에라토스테네스의 채(1~n)
- 1제거
- 2를 제외한 2의 배수 제거
- 3을 제외한 3의 배수 제거
- 5를 제외한 5의 배수 제거
...루트n 이하의 수 만 제거
n보다 작은 수를 ab라 가정했을 때, a와 b중 하나 이상은 n보다 작다(루트n x 루트n = n)

# 1529번
m, n = map(int, input().split())
root_n = int(n ** 0.5)
prime = [True] * (n + 1)
for i in range(2, root_n + 1):
    if prime[i]:
        for j in range(2 * i, n+1, i):
            # print(j, "는 소수가 아닙니다")
            prime[j] = False

result = [i for i in range(m, n+1) if prime[i]]
for i in result:
    if i != 1:
        print(i)


for i in range(m, n+1):
    if prime[i]:
        if i != 1:
            print(i)
'''

# 1935
n = int(input())
cal = input()
n_list = []
for i in range(n):
    n_list.append(int(input()))
cal_list = []
# 42: *, 43: +, 45:-, 47: /
for i in cal:
    chr_num = ord(i)
    if chr_num >= 65:
        cal_list.append(n_list[chr_num - 65])
    else:
        if chr_num != 43 and chr_num != 42 and chr_num != 45 and chr_num != 47:
            exit()
        else:
            a = cal_list.pop()
            b = cal_list.pop()
            if chr_num == 43:
                cal_list.append(b + a)
            elif chr_num == 45:
                cal_list.append(b - a)
            elif chr_num == 42:
                cal_list.append(b * a)
            elif chr_num == 47:
                cal_list.append(b / a)
print('%0.2f' % cal_list[0])
