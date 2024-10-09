import sys
n = int(sys.stdin.readline())
alphabet = []
for _ in range(n):
    string = list(sys.stdin.readline().split())
    flag = True
    for i in range(len(string)):
        if string[i][0] not in alphabet:
            alphabet.append(string[i][0].lower())
            alphabet.append(string[i][0].upper())
            string[i] = "[" + string[i][0] + "]" + string[i][1:]
            print(" ".join(string))
            flag =False
            break
    if flag:
        for i in range(len(string)):
            if flag:
                for j in range(len(string[i])):
                    if string[i][j] not in alphabet:
                        alphabet.append(string[i][j].lower())
                        alphabet.append(string[i][j].upper())
                        string[i] = string[i][:j] + "[" + string[i][j] + "]" + string[i][j + 1:]
                        print(" ".join(string))
                        flag = False
                        break
    if flag:
        print(" ".join(string))