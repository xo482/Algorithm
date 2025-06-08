from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
ls = list(map(int, input().split()))
visited = [False] * n

idx = 0
cnt = 0
while True:
    print(idx+1, end=' ')
    visited[idx] = True
    mv = ls[idx]
    cnt += 1

    if cnt == n:
        break

    c = 0
    if mv > 0:
        while c != mv:
            idx = (idx + 1) % n
            if visited[idx] == True:
                continue
            c += 1

    if mv < 0:
        while c != mv:
            idx = (idx - 1 + n) % n
            if visited[idx] == True:
                continue
            c -= 1