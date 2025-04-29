def solution(k, m, score):
    score.sort()
    score.reverse()
    cnt = 0
    ans = 0
    
    for v in score:
        cnt += 1
        if cnt == m:
            ans += (v * m)
            cnt = 0
    
    return ans