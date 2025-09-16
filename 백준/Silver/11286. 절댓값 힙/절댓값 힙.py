import sys
from heapq import heappush, heappop
input = sys.stdin.readline

n = int(input())
q = []
for _ in range(n):
    val = int(input())
    (print(heappop(q)[1]) if len(q) != 0 else print(0)) if val == 0 else heappush(q, (abs(val), val))