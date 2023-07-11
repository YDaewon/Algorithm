def fuc(x1, y1, x2, y2, cx,cy, r):
    c = 0
    r1 = (cx - x1)**2 + (cy - y1)**2
    r2 = (cx - x2)**2 + (cy - y2)**2
    if r1 <r**2 and r2 < r**2:
        return c;
    if r1 < r**2:  # 출발점 to 원점이 반지름 보다 작을 경우(원 내부)
        c += 1
    if r2 < r**2:      # 도착점 to 원점이 반지름 보다 작을 경우(원 내부)
        c += 1
    return c;

T= int(input()) # 테스트 케이스 수
for i in range(T):
    cnt = 0
    x1, y1, x2, y2 = map(int, input().split(" ")) # 출발 점과 도착점 좌표
    N = int(input()) # 원의 개수
    for j in range(N):
        cx, cy, r = map(int, input().split(" "))
        cnt = cnt + fuc(x1, y1, x2, y2, cx, cy, r)
    print(cnt)