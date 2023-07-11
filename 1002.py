import math
num = int(input(""))
for i in range(num):
    x1, y1, r1, x2, y2, r2 = map(int, input().split(" "))
    result = math.sqrt(((x2 - x1)**2) + ((y2 - y1)**2))
    if result == 0 and (r1 - r2) == 0: # 일치할 때
        print(-1)
    elif abs(r1- r2) == result or (r1 + r2) == result: # 접할 때
        print(1)
    elif (r1 + r2) > result > abs(r1 - r2): # 겹칠 때
        print(2)
    else:
        print(0)