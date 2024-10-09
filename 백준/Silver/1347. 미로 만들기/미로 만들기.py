pointer = 0    # 밑: 0   왼쪽:1   위:2    오른쪽:  3
x = 0
y = 0
N = int(input())
box = input()
route = [[x, y]]
max_x = 0
max_y = 0
min_x = 0
min_y = 0
for i in range(N):
    if box[i] == 'R':
        if pointer < 3:
            pointer += 1
        else:
            pointer = 0
    elif box[i] == 'L':
        if pointer > 0:
            pointer -= 1
        else:
            pointer = 3
    elif box[i] == 'F':
        if pointer == 0:
            y += 1
            if max_y < y:
                max_y = y
        elif pointer == 1:
            x -= 1
            if min_x > x:
                min_x = x
        elif pointer == 2:
            y -= 1
            if min_y > y:
                min_y = y
        elif pointer == 3:
            x += 1
            if max_x < x:
                max_x = x
        route.append([x, y])

#print("초기 경로", route)
#print(max_x, max_y, min_x, min_y)
for i in range(len(route)):
    route[i][0] = route[i][0] + abs(min_x)
    route[i][1] = route[i][1] + abs(min_y)

#print("수정 경로", route)
row = abs(max_x) + abs(min_x) + 1
col = abs(max_y) + abs(min_y) + 1
#print("row:", row, "col:", col)
box = [([0] * row) for _ in range(col)]
for i, j in route:
    box[j][i] = 1

for i in range(col):
    for j in range(row):
        if box[i][j] == 1:
            print(".", end='')
        else:
            print("#", end='')
    print()
