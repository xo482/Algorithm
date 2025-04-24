def solution(answers):
    
    l1 = []
    l2 = []
    l3 = []
    patten1 = [1,2,3,4,5]
    patten2 = [2, 1, 2, 3, 2, 4, 2, 5]
    patten3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    for i in range(1,10001):
        l1.append(patten1[(i-1)%5])
        l2.append(patten2[(i-1)%8])
        l3.append(patten3[(i-1)%10])
    
    
    c1 = 0
    c2 = 0
    c3 = 0
    for i in range(len(answers)):
        if l1[i] == answers[i]: c1 += 1
        if l2[i] == answers[i]: c2 += 1
        if l3[i] == answers[i]: c3 += 1
    
    ans = []
    m = max(c1, c2, c3)
    if c1 == m: ans.append(1)
    if c2 == m: ans.append(2)
    if c3 == m: ans.append(3)
    return ans