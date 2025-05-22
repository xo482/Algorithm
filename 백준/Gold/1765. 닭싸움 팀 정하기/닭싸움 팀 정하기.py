import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
enemy_list = [[] for _ in range(n+1)]
parent = [i for i in range(n+1)]

def find(a):
    if parent[a] != a:
        parent[a] = find(parent[a])
    return parent[a]

def union(a, b):
    a = find(a)
    b = find(b)
    parent[b] = a

for _ in range(m):
    input_list = input().split()
    r = input_list[0]
    a = int(input_list[1])
    b = int(input_list[2])

    if r == 'E':
        enemy_list[a].append(b)
        enemy_list[b].append(a)

    if r == 'F':
        union(a, b)

for ls in enemy_list:
    size = len(ls)
    for i in range(size-1):
        for j in range(i+1, size):
            union(ls[i], ls[j])

result = set()
for i in range(1, n+1):
    val = find(parent[i])
    result.add(val)

print(len(result))