def solution(myString):
    ans = []
    cnt = 0
    
    for v in myString:
        if v == 'x':
            ans.append(cnt)
            cnt = 0
        else: cnt+=1
    
    ans.append(cnt)
    return ans