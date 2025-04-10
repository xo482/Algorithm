def solution(food):
    ans = []
    for i in range(1, len(food)):
        for re in range(food[i]//2):
            ans.append(str(i))
    
    ans = ''.join(ans)
    return ans + '0' + ''.join(reversed(ans))