k, n = map(int, input().split())
arr = [int(input()) for _ in range(k)]

start = 0
end = max(arr)+1
while start + 1 < end:
    mid = (start + end) // 2
    now = sum([v // mid for v in arr])

    if now >= n: start = mid
    else: end = mid

print(start)