import sys
input = sys.stdin.readline

cnt = 0
dc = {}
n = int(input())
for _ in range(n):
    cow, pos = map(int, input().split())
    if cow not in dc:
        dc[cow] = pos
        continue
    
    if dc[cow] == pos:
        continue
    
    dc[cow] = pos
    cnt += 1

print(cnt)