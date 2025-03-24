def solution(number):
    answer = 0
    sz = len(number)
    
    for i in range(sz):
        for j in range(i+1, sz):
            for k in range(j+1, sz):
                if(number[i]+number[j]+number[k] == 0):
                    answer += 1
    
    
    return answer