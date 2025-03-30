import sys

def solution(s):
    s = s.split(" ")
    s = list(map(int, s))
    min_value = min(s)
    max_value = max(s)
    return ''.join([str(min_value), ' ', str(max_value)])