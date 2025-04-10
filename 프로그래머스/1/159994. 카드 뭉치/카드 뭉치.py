def solution(cards1, cards2, goal):
    p1 = 0
    p2 = 0
    
    for s in goal:
        if p1 < len(cards1) and cards1[p1] == s:
            p1 += 1
            continue
    
        if p2 < len(cards2) and cards2[p2] == s:
            p2 += 1
            continue
        
        return "No"
    return "Yes"