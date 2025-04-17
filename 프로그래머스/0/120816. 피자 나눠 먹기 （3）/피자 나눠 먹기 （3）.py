def solution(slice, n):
    answer = 0
    answer += n//slice
    if n%slice!=0:answer+=1
    return answer