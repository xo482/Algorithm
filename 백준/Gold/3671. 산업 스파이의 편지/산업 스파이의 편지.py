from itertools import permutations
import sys
input = sys.stdin.readline

is_prime = [False] * 10_000_000
is_prime[0] = True
is_prime[1] = True
for i in range(2, int(10_000_000**(1/2))+1):
    if is_prime[i] == True:
        continue

    for j in range(i*i, 10_000_000, i):
        is_prime[j] = True


t = int(input())
for _ in range(t):
    ls = list(input())[:-1]
    size = len(ls)
    cnt = 0
    se = set()
    
    for i in range(1, size+1):
        for now in permutations(ls, i):
            num = int(''.join(now))
            se.add(num)

    for i in se:
        if is_prime[i] == False:
            cnt += 1

    print(cnt)