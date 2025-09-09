import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
diff = [0 for _ in range(n+1)]

for _ in range(m):
    a, b, k = map(int, input().split())
    a -= 1
    b -= 1
    diff[a] += k
    diff[b+1] -= k

change = 0
for i in range(n):
    change += diff[i]
    arr[i] += change

print(*arr)