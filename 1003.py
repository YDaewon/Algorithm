def fib(n):
    o = [0, 1, 1]
    z = [1, 0, 1]
    if n >= 3:
        for i in range(2, n): # 피보나치: 이전 값 + 현재 값
            z.append(z[i - 1] + z[i])
            o.append(o[i - 1] + o[i])
    print(f"{z[n]} {o[n]}")


h = int(input())
for _ in range(h):
    n = int(input())
    fib(n)