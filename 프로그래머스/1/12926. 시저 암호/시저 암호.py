def solution(s, n):
    ans = []
    for i in list(s):
        if i == " ":
            ans.append(i)
            continue
            
        i = ord(i)
        if (97 <= i+n and i+n <= 122) and (97 <= i and i <= 122):
            ans.append(chr(i+n))
            continue
        
        
        if (65 <= i+n and i+n <= 90) and (65 <= i and i <= 90):
            ans.append(chr(i+n))
            continue
        
        ans.append(chr(i+n-26))
    
    return ''.join(ans)