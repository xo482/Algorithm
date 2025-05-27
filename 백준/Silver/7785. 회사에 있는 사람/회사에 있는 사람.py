import sys
input = sys.stdin.readline

d = dict()
n = int(input())
while n:
    n -= 1
    key, val = input().split()
    d[key] = val

for key in reversed(sorted(list(d.keys()))):
    if d[key] == 'enter':
        print(key)