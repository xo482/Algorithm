def solution(n):
    answer = 0
    ls = [0, 1]
    for _ in range(n-1):
        ls.append(ls[-1] + ls[-2])
    return ls[n] % 1234567