import sys
def palindrome(str):
    for i in range(0, len(str)//2):
        if str[i] != str[len(str) - ( i + 1)]:
            return True
    return False

count = 0
s =list(input())
while palindrome(s):
    for _ in range(count):
        s.pop()
    for i in range(count, -1, -1):
        s.append(s[i])
    count += 1
print(len(s))