def solution(people, limit):
    ans = 0
    people.sort()
    p1 = 0
    p2 = len(people)-1 
    
    while p1 < p2:
        if people[p1] + people[p2] <= limit: 
            p1 += 1
            
        p2 -= 1
        ans+=1
        
    if p1 == p2:
        ans += 1
        
    return ans