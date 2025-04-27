def solution(array, commands):
    
    ans = []
    
    for i,j,k in commands:
        ls = array[i-1:j]
        ls.sort()
        ans.append(ls[k-1])
    
    return ans