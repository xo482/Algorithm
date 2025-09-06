def solution(s, skip, index):
    new = []
    for ss in s:
        idx = 0
        while idx < index:
            ss = chr(ord(ss)+1)
            if ss == '{':
                ss = 'a'
            
            if ss in skip:
                continue
            idx += 1
        new.append(ss)
    
    return ''.join(new)
            