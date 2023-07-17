import sys

input = sys.stdin.readline

from itertools import product
from itertools import permutations

N, M = input().strip().split()

string = input().strip().split()
string_converted = []
tuning = input().strip().split()
tuning_converted = []
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
pplist = list(product(*[plist[i:i + lcn] for i in range(0, len(plist), lcn)]))

#print("plist:", plist)
#print("pplist:", pplist)
xxlist = []
for x in pplist:
    xlist = []
    for xx in x:
        xlist.append(xx[1])
    #print(xlist)
    if set(xlist) == set(tuning):
        xxlist.append(x)

#print(xxlist)
sumlist = []
count = 0
for x in xxlist:
    flet = []
    minion = 12
    print(count)
    for xx in x:
        print(xx[0], '->', xx[1],end=' ')
        a = translate_sound(xx[1]) - translate_sound(xx[0])
        if a < 0:
            a += 12
        print('flet:', a)
        flet.append(a)
        if a > 0 and translate_sound(xx[1]) > translate_sound(xx[0]):
            flet.append(a+12)
    print(flet)
    if max(flet) == 0:
        minion = -1
    result_list = list(permutations(flet, 2))
    print(result_list)
    for m in result_list:
        if max(m) - min(m) < minion and not (m[0] == 0 or m[1] == 0) and not (max(flet) == min(flet)):
            minion = max(m) - min(m)
    print("minion:", minion)
    sumlist.append(minion)
    count += 1

print(sumlist)
print(min(sumlist) + 1)