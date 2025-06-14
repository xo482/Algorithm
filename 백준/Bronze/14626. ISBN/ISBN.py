line = input()
m = int(line[12])
idx = line.index('*')
weight = [1, 3] * 6
su = 0

for i in range(12):
    if line[i] == '*': continue
    su += int(line[i]) * weight[i]

for v in range(10):
    if ((su + v * weight[idx]) % 10 + m) % 10 == 0:
        print(v)
        exit()