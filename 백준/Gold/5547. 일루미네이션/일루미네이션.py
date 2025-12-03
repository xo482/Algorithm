import sys
input = sys.stdin.readline

even_dc = [-1, 0, -1, 1, -1, 0]
even_dr = [-1, -1, 0, 0, 1, 1]
odd_dc = [0, 1, -1, 1, 0, 1]
odd_dr = [-1, -1, 0, 0, 1, 1]

ans = 0
M, N = map(int, input().split())
board = [[0]*(M+2)] + [[0] + list(map(int, input().split())) + [0] for _ in range(N)] + [[0]*(M+2)]
visited = [[False for _ in range(M+2)] for _ in range(N+2)]

def bfs():
    cnt = 0
    q = [(0,0)]
    visited[0][0] = True

    while q:
        r, c = q.pop(0)

        if r % 2 == 0:
            temp_dr = even_dr
            temp_dc = even_dc
        else:
            temp_dr = odd_dr
            temp_dc = odd_dc

        for i in range(6):
            nr = r + temp_dr[i]
            nc = c + temp_dc[i]

            if nr < 0 or nr >= N + 2 or nc < 0 or nc >= M + 2: continue
            if visited[nr][nc]: continue
            if board[nr][nc] == 1:
                cnt += 1
                continue

            visited[nr][nc] = True
            q.append((nr, nc))

    return cnt

print(bfs())