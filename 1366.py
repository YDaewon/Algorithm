N, M = map(int, input().split(" "))
string_sound = input().split(" ")
tuning = input().split(" ")
sound = {}
temp = []
count_list = []
diff_list = []
diff = True

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

for i in range(M):
    diff_list.append(translate_sound(tuning[i]))

for i in range(N):
    s_sound = translate_sound(string_sound[i])
    a = 0
    if (string_sound[i] in tuning and not len(diff_list)) or (diff and string_sound[i] in tuning):
        temp.append(0)
        temp.append(0)
    else:
        for j in range(M):
            t_sound = translate_sound(tuning[j])
            a = t_sound - s_sound
            if a < 0:
                a += 12
            if a > 0:
                temp.append(a)
            print(string_sound[i], "(", s_sound, ")", "->", tuning[j], "(", t_sound, ")  flat:", a)
    print(" temp_list:  ", temp)
    temp.sort()
    t_temp = []
    for k in temp:
        if (k + s_sound) % 12 in diff_list:
            t_temp.append(k)
        else:
            sound[i] = min(temp)
    if len(t_temp):
        print("t_temp:", t_temp)
        sound[i] = min(t_temp)
    if len(diff_list) and (s_sound + sound[i]) in diff_list:
        diff_list.pop(diff_list.index(s_sound + sound[i]))
        print(s_sound + sound[i], " diff_list 에서 제거")
    print(diff_list)
    print("count", sound[i], "삽입")
    count_list.append(s_sound + temp[0])
    temp = []
    diff = False



small_key = list(sound.keys())[0]
big_key = list(sound.keys())[0]
print(sound.values())
for i in range(len(sound)):
    if list(sound.values())[i] == 0:
        continue
    if list(sound.keys())[i] < int(small_key) or sound[small_key] == 0:
        small_key = list(sound.keys())[i]
    if list(sound.keys())[i] > int(big_key) or sound[big_key] == 0:
        big_key = list(sound.keys())[i]

if sound[big_key] == 0 and sound[small_key] == 0:
    print(0)
elif abs(sound[big_key] - sound[small_key]) > 6:
    small_num, big_num = min(sound[small_key], sound[big_key]), max(sound[small_key], sound[big_key])
    print(abs(big_num - small_num - 12 + 1))
else:
    print(abs(sound[big_key] - sound[small_key]) + 1)