import sys
input = sys.stdin.readline

n = int(input())
for _ in range(n):
    words = input().split()
    for str in words:
        print(''.join(reversed(str)), end=' ')
    print()
    