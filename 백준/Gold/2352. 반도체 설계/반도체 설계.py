import sys
input = sys.stdin.readline

n = int(input())
from_ports = [int(i) - 1 for i in input().split()]
to_ports = []

for val in from_ports:
    if len(to_ports) == 0 or val > to_ports[-1]:
        to_ports.append(val)
        continue

    start = -1
    end = len(to_ports) - 1 # 가능한 가장 높은 인덱스의 제거 대상
    while start + 1 < end:
        mid = (start + end) // 2

        if val < to_ports[mid]:
            end = mid
        if val > to_ports[mid]:
            start = mid
        if val == to_ports[mid]:
            end = mid
            break

    to_ports[end] = val

print(len(to_ports))
