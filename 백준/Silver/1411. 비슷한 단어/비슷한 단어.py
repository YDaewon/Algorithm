import sys
n = int(sys.stdin.readline())
arr = []
count = 0
for _ in range(n):
    temp = sys.stdin.readline().strip()
    asc = []
    for i in temp:
        asc.append(ord(i) - ord('a'))
    arr.append(asc)
    
for i in range(n-1):
    for j in range(i+1,n):
        alpha = [-1] * 26    # 각 알파벳이 무엇으로 바꼈는지 저장
        overlap = [-1] * 26    # 두 개의 다른 알파벳은 바뀐 후에도 달라야 한다.
        flag = True
        for k in range(len(arr[i])):
            if alpha[arr[i][k]] == -1 and overlap[arr[j][k]] == -1:   #해당 알파벳이 처음 나왔다면
                alpha[arr[i][k]] = arr[j][k]   # 이 알파벳이 무슨 알파벳으로 바꼈는지 저장
                overlap[arr[j][k]] = arr[i][k]   # 해당 알파벳은 이미 가져왔다는 플래그를 세워둔다
            elif alpha[arr[i][k]] != arr[j][k]:   # ~로 바꾸기로 약속했던 알파벳과 두번째 문자열의 알파벳이 다른 경우
                flag = False   # i번째 문자열과 j번째 문자열은 비슷하지 않다
                break
        if flag:
            #print("(",i,")", arr[i], "와 (", j, ")", arr[j], "는 비슷하다")
            count += 1     
            
print(count)                       