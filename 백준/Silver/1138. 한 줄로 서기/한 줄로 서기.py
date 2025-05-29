import sys
input = sys.stdin.readline

n = int(input())
ls = list(map(int, input().split()))
ans = []

[ans.insert(ls[i], i+1) for i in reversed(range(n))]
[print(v, end=' ') for v in ans]