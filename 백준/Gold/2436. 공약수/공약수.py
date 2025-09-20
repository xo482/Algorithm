import sys
from math import gcd
input = sys.stdin.readline

a, b = map(int, input().split())
x = a * b

now_min = 10000000000000000
ans_l = 0
ans_r = 0
for i in range(a, int(x ** (1/2)) + 1):
    if x % i == 0:
        if (abs(x / i - i)) < now_min:
            if gcd(i, int(x / i)) == a:
                now_min = (abs(x / i - i))
                ans_l = i
                ans_r = int(x / i)

print(ans_l, ans_r)