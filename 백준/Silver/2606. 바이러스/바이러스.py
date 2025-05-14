from collections import deque

n = int(input())
m = int(input())
list = []
visited = [0] * (n + 1)

for _ in range(n+1):
    list.append([])

for _ in range(m):
    a, b = map(int, input().split())
    list[a].append(b)
    list[b].append(a)

q = deque()
q.append(1)
visited[1] = 1

while q:
    now = q.popleft()

    for nxt in list[now]:
        if visited[nxt]:
            continue

        visited[nxt] = 1
        q.append(nxt)

print(sum(visited) - 1)