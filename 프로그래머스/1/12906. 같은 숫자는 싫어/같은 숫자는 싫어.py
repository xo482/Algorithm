def solution(arr):
    
    answer = []
    for x in arr:
        size = len(answer)
        if size == 0: 
            answer.append(x)
            continue
        
        if answer[size-1] == x:
            continue
        
        answer.append(x)
        
    return answer