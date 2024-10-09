N = int(input())
def distance(a, b):
    return (a[0]- b[0]) ** 2 +(a[1]- b[1]) ** 2
for _ in range(N):
    square = []
    for i in range(4):
        point = list(map(int, input().split()))
        square.append(point)
    square.sort()   #앞점과 젤 뒷점은 대각
    for p in square:
        check = 0
        if p ==[0, 0]:
            check = 1
    if check == 4:
        print(0)
    elif (distance(square[0], square[1]) == distance(square[0], square[2]) == distance(square[1], square[3])) and (distance(square[1], square[2]) == distance(square[0], square[3])):
        print(1)
    else:
        print(0)