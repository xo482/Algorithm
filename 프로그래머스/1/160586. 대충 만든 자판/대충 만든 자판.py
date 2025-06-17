def solution(keymap, targets):
    dic = dict()
    for str in keymap:
        for i in range(len(str)):
            key = str[i]
            if key not in dic:
                dic[key] = i + 1
                continue
            
            dic[key] = min(dic[key], i + 1)
    
    ans = []
    for target in targets:
        su = 0
        for key in target:
            if key not in dic:
                su = -1
                break
            su += dic[key]
        
        ans.append(su)
    
    return ans