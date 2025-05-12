from collections import deque

dr = [-1, 1, 0, 0]
dc = [0, 0, 1, -1]
n = int(input())
board = [list(map(int, input().split())) for i in range(n)]
max_value = max([max(row) for row in board])

def bfs(si, sj, h, visited):
    q = deque([(si, sj)])
    visited[si][sj] = True

    while q:
        r, c = q.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]

            if nr < 0 or nr >= n or nc < 0 or nc >= n: continue
            if board[nr][nc] <= h: continue
            if visited[nr][nc]: continue

            q.append((nr, nc))
            visited[nr][nc] = True

def solution(h):
    cnt = 0
    visited = [[False] * n for i in range(n)]

    for i in range(n):
        for j in range(n):
            if board[i][j] > h and not visited[i][j]:
                cnt += 1
                bfs(i, j, h, visited)

    return cnt

print(max([solution(i) for i in range(max_value + 1)]))