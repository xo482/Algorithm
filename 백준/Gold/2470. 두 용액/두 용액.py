n = int(input())
ls = sorted(list(map(int, input().split())))
p1 = 0
p2 = n - 1
ans = 2000000000
ans_p1 = 0
ans_p2 = 0

while p1 < p2:
    now = ls[p1] + ls[p2]
    if abs(now) < ans:
        ans = abs(now)
        ans_p1 = p1
        ans_p2 = p2
        
    if now < 0: p1 += 1
    if now > 0: p2 -= 1
    if now == 0: break

print(ls[ans_p1], ls[ans_p2])
        