import sys
from heapq import heappush, heappop
input = sys.stdin.readline

pq = []
n = int(input())
for _ in range(n):
    heappush(pq, int(input()))

ans = 0
while pq:
    min_value = heappop(pq)
    ans = max(ans, min_value * (len(pq) + 1))

print(ans)
