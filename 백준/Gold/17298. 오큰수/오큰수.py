import sys
input = sys.stdin.readline

n = int(input())
ls = list(map(int, input().split()))

ans = [-1] * n
stack = [(0, ls[0])]
for i in range(1, n):
    while len(stack) > 0 and stack[-1][1] < ls[i]:
        ans[stack[-1][0]] = ls[i]
        stack.pop()
    stack.append([i, ls[i]])

print(*ans)