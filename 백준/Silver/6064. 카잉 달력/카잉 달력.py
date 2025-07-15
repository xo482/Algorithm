def gcd(a, b):
    if b == 0: return a
    return gcd(b, a % b)

t = int(input())
for _ in range(t):
    M, N, x, y = map(int, input().split())
    end = M * N // gcd(M, N)

    now_year = x - M
    flag = False
    while now_year <= end:
        now_year += M
        if (now_year - 1) % N + 1 == y:
            flag = True
            break

    if flag:
        print(now_year)
        continue
    print(-1)
