def solution(my_string, n):
    ans = []
    li = list(my_string)
    
    for val in li:
        for i in range(n):
            ans.append(val)
    return ''.join(ans)