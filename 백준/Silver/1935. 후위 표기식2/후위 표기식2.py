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