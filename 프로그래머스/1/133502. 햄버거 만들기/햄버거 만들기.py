def solution(ingredient):
    ans = 0
    stack = []
    
    for i in ingredient:
        if i == 1 and len(stack) >= 3 and stack[-3:] == [1,2,3]:
            stack.pop() ;stack.pop() ;stack.pop()
            ans += 1
            continue
            
        stack.append(i)
        
    return ans