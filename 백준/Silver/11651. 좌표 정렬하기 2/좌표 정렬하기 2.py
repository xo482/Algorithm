import sys
from heapq import heappush, heappop
input = sys.stdin.readline

class point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    
    def __lt__(self, other):
        if self.y == other.y:
            return self.x < other.x
        return self.y < other.y
        

n = int(input())
pq = []
for _ in range(n):
    x, y = map(int, input().split())
    heappush(pq, point(x, y))

for _ in range(n):
    point = heappop(pq)
    print(point.x, point.y)
    