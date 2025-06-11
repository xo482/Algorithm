import sys
input = sys.stdin.readline

n = int(input())
ls_1 = list(input())
ls_2 = list(input())

black = sum([1 for v in ls_1 if v == '#'])
black += sum([1 for v in ls_2 if v == '#'])
ans = n - black

ls_check = []
for i in range(n):
    if ls_1[i] == '#':
        ls_check.append(1)
    if ls_2[i] == '#':
        ls_check.append(2)

for i in range(1, len(ls_check)):
    if ls_check[i] != ls_check[i-1]:
        ans -= 1

print(ans)