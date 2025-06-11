import sys
input = sys.stdin.readline

n = int(input())
ls = list(map(int, input().split()))

ans = [-1] * n
stack = []
for i in range(n):
    while stack and ls[stack[-1]] < ls[i]:
        idx = stack.pop()
        ans[idx] = ls[i]
    stack.append(i)

print(*ans)