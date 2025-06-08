from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
q = deque((i+1, mv) for i, mv in enumerate(map(int, input().split())))

while q:
    i, mv = q.popleft()
    print(i, end=' ')
    q.rotate(-(mv if mv < 0 else mv - 1))