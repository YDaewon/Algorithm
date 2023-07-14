# 1213
import sys
import collections

name = list(map(str, sys.stdin.readline().strip()))
# print(collections.Counter(name)) --- 딕셔너리로 변환
count_word = collections.Counter(name).items()

cnt = 0
pnt = ''
mid = ''
for w, i in list(count_word):
    if i % 2 == 1:
        cnt += 1
        mid = w
        if cnt > 1:
            print("I'm Sorry Hansoo")
            break
else:
    for w, i in sorted(count_word):   #팰린드롬
        pnt += (w * (i // 2))
    print(pnt, mid, pnt[::-1], sep='')
