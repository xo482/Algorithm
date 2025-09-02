from itertools import combinations
import sys
input = sys.stdin.readline

answer = 0
people = []
for i in range(5):
    line = input()
    for j in range(5):
        people.append((i, j, line[j]))


for arr in combinations(people, 7):

    # 연결여부 및 이다솜파 수 확인
    visited = [False] * 7
    visited[0] = True
    queue = [arr[0]]
    cnt = 1
    s_cnt = 0

    while queue:
        r, c, pa = queue.pop(0)
        if pa == 'S': s_cnt += 1

        for i in range(7):
            if visited[i]: continue
            nr, nc, npa = arr[i]
            if (r == nr and abs(nc - c) == 1) or (c == nc and abs(nr - r) == 1):
                visited[i] = True
                cnt += 1
                queue.append(arr[i])


    if s_cnt < 4: continue
    if cnt < 7: continue

    answer += 1


print(answer)
