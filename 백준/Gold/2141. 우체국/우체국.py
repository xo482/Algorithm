import sys
input = sys.stdin.readline

points = []
total = 0
N = int(input())
while True:
    N -= 1
    if N < 0: break

    p, cnt = map(int, input().split())
    points.append((p, cnt))
    total += cnt

points.sort()
cnt = 0
for p, c in points:
    cnt += c
    if cnt >= total/2:
        print(p)
        break