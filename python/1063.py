def str_to_point(str):
    arr = list( str)
    X = ord(arr[0]) - 65
    Y = 8 - int(arr[1])
    result = []
    result.append(X)
    result.append(Y)
    return result

def point_to_str( px, py):
    a = px + 65
    b = 8 - py
    result =chr(a) + str(b)
    return result

king, stone, N= input().split(" ")
kx = str_to_point(king)[0]
ky = str_to_point(king)[1]
sx = str_to_point(stone)[0]
sy = str_to_point(stone)[1]

for i in range (int (N )):
    move = input()
    if move == "R":
        if ((kx + 1) == sx) and (ky == sy):
            if sx < 7:
                kx += 1
                sx += 1
        else:
            if kx < 7:
                kx += 1
    elif move == "L":
        if ((kx-1) == sx) and (ky == sy):
            if sx > 0 :
                kx -= 1
                sx -= 1
        else:
            if kx > 0 :
                kx -= 1
    elif move == "B":
        if (kx == sx) and ((ky + 1) == sy):
            if sy < 7:
                ky +=1
                sy += 1
        else:
            if ky < 7:
                ky += 1
    elif move == "T":
        if (kx == sx) and ((ky -1) == sy):
            if sy > 0:
                ky -= 1
                sy -= 1
        else:
            if ky > 0 :
                ky -= 1

    elif move == "RT":
        if((kx+1)== sx) and ((ky-1) == sy):
            if sx<7 and sy > 0:
                kx += 1
                sx += 1
                ky -= 1
                sy -= 1
        else:
            if kx < 7 and ky > 0 :
                kx += 1
                ky -= 1
    elif move == "LT":
        if ((kx - 1) == sx) and ((ky - 1) == sy):
            if sx > 0 and sy > 0:
                kx -= 1
                sx -= 1
                ky -= 1
                sy -= 1
        else:
            if kx > 0 and ky > 0:
                kx -= 1
                ky -= 1
    elif move == "RB":
        if ((kx + 1) == sx) and ((ky + 1) == sy):
            if sx < 7 and sy < 7:
                kx += 1
                sx += 1
                ky += 1
                sy += 1
        else:
            if kx < 7 and ky < 7:
                kx += 1
                ky += 1
    elif move == "LB":
        if ((kx - 1) == sx) and ((ky + 1) == sy):
            if sx > 0 and sy < 7:
                kx -= 1
                sx -= 1
                ky += 1
                sy += 1
        else:
            if kx > 0 and ky < 7:
                kx -= 1
                ky += 1

print(point_to_str(kx, ky))
print(point_to_str(sx, sy))