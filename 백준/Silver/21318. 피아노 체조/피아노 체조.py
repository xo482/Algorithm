import sys
input = sys.stdin.readline
n = int(input())
miss = [0] * (n+1)
arr = [0] + list(map(int, input().split()))

for i in range(1, n):
    miss[i] = miss[i - 1]
    
    if arr[i] > arr[i+1]:
        miss[i] += 1

q = int(input())
for _ in range(q):
    x, y = map(int, input().split())
    print(miss[y-1] - miss[x-1])