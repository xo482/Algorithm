import queue
import sys
input = sys.stdin.readline

class Meeting:
    def __init__(self, s, e):
        self.s = s
        self.e = e

    def __lt__(self, other):
        if self.e == other.e:
            return self.s < other.s
        return self.e < other.e

q = queue.PriorityQueue()
n = int(input())
for _ in range(n):
    s, e = map(int, input().split())
    q.put(Meeting(s, e))

cnt = 0
time = 0
while not q.empty():
    now = q.get()
    if time > now.s:
        continue

    time = now.e
    cnt += 1

print(cnt)