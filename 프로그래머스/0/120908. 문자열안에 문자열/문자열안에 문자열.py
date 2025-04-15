def solution(str1, str2):
    l1 = list(str1)
    l2 = list(str2)
    len1 = len(l1)
    len2 = len(l2)
    
    for i in range(len1-len2+1):
        flag = True
        
        for j in range(len2):
            if l1[i+j] != l2[j]:
                flag = False
                break
        
        if flag: return 1
    
    return 2
    