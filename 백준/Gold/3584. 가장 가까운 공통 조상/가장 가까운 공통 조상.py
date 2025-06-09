import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def find(v, ls):
    if parent[v] == v:
        return

    ls.append(parent[v])
    find(parent[v], ls)


t = int(input())
for _ in range(t):
    n = int(input())
    parent = [i for i in range(n+1)]

    for _ in range(n-1):
        a, b = map(int, input().split())
        parent[b] = a

    a, b = map(int, input().split())
    a_list = [a]
    b_list = [b]
    find(a, a_list)
    find(b, b_list)

    for a in a_list:
        if a in b_list:
            print(a)
            break
