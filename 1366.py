import sys

input = sys.stdin.readline

from itertools import product
from itertools import permutations

N, M = input().strip().split()

string = input().strip().split()
tuning = input().strip().split()
lcn = len(tuning)

def translate_sound(str):
    num = 0
    if str in "A":
        num = 0
    elif str in "A#":
        num = 1
    elif str in "B":
        num = 2
    elif str in "C":
        num= 3
    elif str in "C#":
        num= 4
    elif str in "D":
        num=5
    elif str in "D#":
        num=6
    elif str in "E":
        num=7
    elif str in "F":
        num = 8
    elif str in "F#":
        num = 9
    elif str in "G":
        num = 10
    elif str in "G#":
        num = 11
    return num

plist = list(product(string, tuning))
all_mul_plist = list(product(*[plist[i:i + lcn] for i in range(0, len(plist), lcn)]))

#print("plist:", plist)
#print("pplist:", pplist)
temp = []
for i in all_mul_plist:
    t_temp = []
    for j in i:
        t_temp.append(j[1])
    #print(xlist)
    if set(t_temp) == set(tuning):
        temp.append(i)

#print(xxlist)
sumlist = []
count = 0
for i in temp:
    flet = []
    minion = 12
    #print(count)
    for j in i:
        #print(j[0], '->', j[1],end=' ')
        a = translate_sound(j[1]) - translate_sound(j[0])
        if a < 0:
            a += 12
        #print('flet:', a)
        flet.append(a)
        flet.append(a + 12)
    #print(flet)
    result_list = list(permutations(flet, 2))
    #print(result_list)
    for m in result_list:
        if max(flet) == min(flet) or max(flet) == min(flet) + 12:
            if max(flet) == 12 or max(flet) == 0:
                minion = -1
            else:
                minion = 0
        elif max(m) - min(m) < minion and not (m[0] == 0 or m[1] == 0) and not max(m) == min(m):
            minion = max(m) - min(m)
    #print("minion:", minion)
    sumlist.append(minion)
    count += 1

print(min(sumlist) + 1)