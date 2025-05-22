import copy
import sys
input = sys.stdin.readline


def turn(n, ans, board):
    axis = n // 2
    for i in range(n):
        for j in range(n):
            if i == j:
                ans[i][j] = board[axis][j]
            elif i + j + 1 == n:
                ans[i][j] = board[i][axis]
            elif i == axis:
                ans[i][j] = board[n-1-j][j]
            elif j == axis:
                ans[i][j] = board[i][i]

t = int(input())
for _ in range(t):
    n, d = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(n)]
    ans = copy.deepcopy(board)

    d = int(((d / 45) + 8) % 8)
    for _ in range(d):
        turn(n, ans, board)
        board = copy.deepcopy(ans)

    for i in range(n):
        print(*board[i])
    