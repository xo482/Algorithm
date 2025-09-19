from heapq import heappush, heappop
import sys
input = sys.stdin.readline


class meeting:
    def __init__(self, start, end):
        self.start = start
        self.end = end

    def __lt__(self, other):
        if self.start == other.start:
            return self.end < other.end
        return self.start < other.start

meeting_q = []
end_q = []

n = int(input())
for _ in range(n):
    start, end = map(int, input().split())
    heappush(meeting_q, meeting(start, end))


while meeting_q:
    meeting = heappop(meeting_q)
    if not end_q:
        heappush(end_q, meeting.end)
        continue

    if end_q[0] <= meeting.start:
        heappop1 = heappop(end_q)

    heappush(end_q, meeting.end)

print(len(end_q))
