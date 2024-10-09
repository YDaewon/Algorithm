#결국 1~N까지의 문자열 길이
# 1951번
n = input()
str_len = len(n)
i=2
result = 1
while str_len >= i:
    result += (i-1) * 9 * (10 **(i- 2))
    i+= 1
result += str_len-1
result += ((int(n[0]) -1) * 10 ** (str_len -1)) * str_len
if str_len >1:
    result += int(n[1:]) * str_len
    
print(result % 1234567)