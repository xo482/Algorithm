from collections import deque

dr = [-1, 1, 0, 0]
dc = [0, 0, 1, -1]

def bfs(i, j):
    q = deque([(i, j)])
    board[i][j] = True

    cnt = 1
    while q:
        r, c = q.popleft()

        for k in range(4):
            nr = r + dr[k]
            nc = c + dc[k]
            if nr >= n or nr < 0 or nc >= m or nc < 0: continue
            if board[nr][nc]: continue

            q.append((nr, nc))
            board[nr][nc] = True
            cnt += 1

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
        bfs(i, j)

print(len(ans))
print(*sorted(ans))