def ssum(str):
    temp = []
    for i in str:
        if ord(i) < 60:
            temp.append(ord(i) - 48)
    return sum(temp)


def small(A, B):
    if len(A) != len(B):
        if len(A) < len(B):
            return 0
        else:
            return 1
    elif ssum(A) != ssum(B):
        if ssum(A) < ssum(B):
            return 0
        else:
            return 1
    else:
        if A == B:
            return 0
        for i in range(len(A)):
            if A[i] == B[i]:
                continue
            else:
                if ord(A[i]) < ord(B[i]):
                    return 0
                else:
                    return 1


N = int(input())
strlist = []
for i in range(N):
    xlist = input()
    strlist.append(xlist)

#print(strlist)
for end in range(1, N):
    for j in range(end, 0, -1):
        if small(strlist[j - 1], strlist[j]):
            # print(strlist[j],"<- 이동")
            strlist[j - 1], strlist[j] = strlist[j], strlist[j - 1]
# print(strlist)
# print( 'result')
for i in range(N):
    print(strlist[i])
