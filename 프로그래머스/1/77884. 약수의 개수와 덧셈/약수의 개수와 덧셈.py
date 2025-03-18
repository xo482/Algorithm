def solution(left, right):
    return sum([cal(i) for i in range(left, right+1)])


def cal(n):
    cnt = 0
    for i in range(1,n+1):
        if n % i == 0:
            cnt += 1
    
    if cnt % 2 == 0:
        return n;
    return -n;