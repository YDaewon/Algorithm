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

import sys


def dfs(num):
    print(num, end=" ")
    num_list.append(num)
    for idx in node_list[num]:
        if idx not in num_list:
            dfs(idx)


def bfs(num):
    temp = [num]
    while temp:
        node = temp.pop(0)
        if node not in num_list:
            print(node, end=" ")
            num_list.append(node)
            for idx in node_list[node]:
                temp.append(idx)


n, m, v = map(int, sys.stdin.readline().split())
node_list = [[] for _ in range(n + 1)]
num_list = []
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    node_list[a].append(b)
    node_list[b].append(a)

for i in node_list:
    i.sort()

dfs(v)
print()
num_list = []
bfs(v)