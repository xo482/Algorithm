import sys
input = sys.stdin.readline

s = 0
idx = -1
ls = list(input())
m = int(ls[12])

for i in range(12):
    if ls[i] == '*':
        idx = i
        continue

    num = int(ls[i])
    s += num

    if i % 2 == 1:
        s += 2 * num

for v in range(10):
    if idx % 2 == 1:
        if ((s + 3 * v) % 10 + m) % 10 == 0:
            print(v)
            exit()

    if idx % 2 == 0:
        if ((s + v) % 10 + m) % 10 == 0:
            print(v)
            exit()