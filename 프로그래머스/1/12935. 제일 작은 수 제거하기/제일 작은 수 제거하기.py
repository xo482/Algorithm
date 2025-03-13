def solution(arr):
    
    n = min(arr)
    answer = [num for num in arr if n != num]

    if len(answer) == 0: return [-1]
    return answer