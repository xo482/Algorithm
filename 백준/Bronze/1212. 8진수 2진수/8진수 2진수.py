import sys
input = sys.stdin.readline


line = input()
nums = list(line)
ans = [0] * ((len(nums)-1) * 3)

for i in range(len(nums)-1):
    num = int(nums[i])
    for k in reversed(range(3)):
        ans[i * 3 + k] = num % 2
        num //= 2

i = 0
while i < len(ans):
    if ans[i] == 1:
        break
    i += 1

if i == len(ans):
    print('0')
else:
    print(''.join(map(str, ans[i:])))