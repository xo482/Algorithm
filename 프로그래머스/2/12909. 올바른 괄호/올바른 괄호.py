def solution(s):
    st = []
    s = list(s)
    
    for i in s:
        if i == '(': 
            st.append(i)
        if i == ')':
            if len(st) == 0: return False
            st.pop()
    
    if len(st) != 0: return False
    return True