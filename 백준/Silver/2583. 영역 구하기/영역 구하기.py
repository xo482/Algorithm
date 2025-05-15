from collections import deque


dr = [-1, 1, 0, 0]
dc = [0, 0, 1, -1]
cnt = 0

def dfs(r, c):
    cnt = 0
    stack = deque([(r,c)])
    board[i][j] = True

    while stack:
        cnt += 1
        r, c = stack.pop()

        for k in range(4):
            nr = r + dr[k]
            nc = c + dc[k]
            if nr >= n or nr < 0 or nc >= m or nc < 0: continue
            if board[nr][nc]: continue

            board[nr][nc] = True
            stack.append((nr,nc))

    ans.append(cnt)


m, n, k = map(int, input().split())
board = [[False] * m for _ in range(n)]
ans = []

for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())

    for i in range(x1, x2):
        for j in range(y1, y2):
            board[i][j] = True

for i in range(n):
    for j in range(m):
        if board[i][j]: continue
        dfs(i, j)

print(len(ans))
print(*sorted(ans))