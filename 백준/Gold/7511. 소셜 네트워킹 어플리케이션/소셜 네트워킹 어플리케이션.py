import sys

input = sys.stdin.readline
parent = []
def find(a):
    if parent[a] == a: return a
    parent[a] = find(parent[a])
    return parent[a]

def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b



T = int(input())
for t in range(T):
    n = int(input())
    k = int(input())

    parent = [i for i in range(n)]

    for _ in range(k):
        a, b = map(int, input().split())
        union(a, b)

    print(f"Scenario {t+1}:")
    m = int(input())
    for i in range(m):
        a, b = map(int, input().split())
        pa = find(a)
        pb = find(b)
        print(1 if pa == pb else 0)
    print()