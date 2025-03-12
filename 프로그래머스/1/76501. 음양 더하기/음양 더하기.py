def solution(absolutes, signs):
    answer = 0
    for i in range(0, len(absolutes)):
        if signs[i]: answer += absolutes[i]
        if not(signs[i]): answer -= absolutes[i]
    return answer