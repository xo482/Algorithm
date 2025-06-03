import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    input()
    ls = list(map(int, input().split()))
    print(min(ls), end=' ')
    print(max(ls))
    