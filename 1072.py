X, Y = map(int, input().split(" "))

Z = (Y * 100) // X


def func(left, right):
    if left > right:
        return left
    mid = (left + right) // 2
    bx = X + mid
    by = Y + mid
    if (by * 100) // bx > Z:
        return func(left, mid - 1)
    else:
        return func(mid + 1, right)


if Z >= 99:
    print(-1)
else:
    count = func(1, X)
    print(count)
