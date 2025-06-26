from queue import PriorityQueue
import sys
input = sys.stdin.readline

q = PriorityQueue()
n = int(input())
cnt = 0

for _ in range(n):
    for v in list(map(int, input().split())):
        if cnt != n: 
            cnt += 1
            q.put(v)
            continue
            
        q.put(v)    
        q.get()

print(q.get())
