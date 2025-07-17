import sys
input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]
N = int(input())
board = [[False] * 101 for _ in range(101)]

for _ in range(N):
    x, y, d, g = map(int, input().split())
    board[x][y] = True
    board[x + dx[d]][y + dy[d]] = True
    points = [(x, y), (x + dx[d], y + dy[d])]

    axis_idx = 1
    for _ in range(g):
        axis_x, axis_y = points[axis_idx]
        axis_now_idx = axis_idx
        axis_idx = len(points)
        for i in range(axis_idx):
            if i == axis_now_idx:
                continue

            target_x, target_y = points[i]
            new_x = -(target_y - axis_y) + axis_x
            new_y = (target_x - axis_x) + axis_y

            board[new_x][new_y] = True
            points.append((new_x, new_y))


ans = 0
for i in range(100):
    for j in range(100):
        if board[i][j] and board[i+1][j] and board[i][j+1] and board[i+1][j+1]:
            ans += 1

print(ans)