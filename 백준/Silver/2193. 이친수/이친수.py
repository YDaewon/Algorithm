N= int(input())
temp = [1,1]+[0 for _ in range(N-2)]
for i in range(2,N):
    temp[i] = temp[i-2] + temp[i-1]
print(temp[N-1])