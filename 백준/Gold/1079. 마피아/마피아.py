import sys
import time
input = sys.stdin.readline

N = int(input().strip()) 
sin = [int(x) for x in input().strip().split()]

increase = []
for _ in range(N):
    increase.append([int(x) for x in input().strip().split()])

me = int(input().strip())
found = False

def count_night(alive, sin, people_cnt):
    global found
    if found:
        return 0
    
    # night
    if people_cnt % 2 == 0:    
        max_score = 0
        for idx, a in enumerate(alive):
            if a and idx != me:
                new_sin = [s + r for s, r in zip(sin, increase[idx])]
                alive[idx] = 0
                max_score = max(max_score, count_night(alive, new_sin, people_cnt - 1))
                alive[idx] = 1

        return 1 + max_score

    # day
    else:
        max_score = 0
        max_idx = 0
        for idx, a in enumerate(alive):
            if a and sin[idx] > max_score:
                max_score = sin[idx] 
                max_idx = idx 
                
        if max_idx == me:   
            if people_cnt == 1:
                found = True
            return 0
        
        alive[max_idx] = 0
        result = count_night(alive, sin, people_cnt - 1)
        alive[max_idx] = 1
        return result

print(count_night([1 for _ in range(N)], sin, N))