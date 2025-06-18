position = dict()
for key in range(0,9): position[key] = (key//3, key%3)
position['*'] = (3,0)
position[-1] = (3,1)
position['#'] = (3,2)



def solution(numbers, hand):
    left = '*'
    right = '#'
    ans = []
    for key in numbers:
        key -= 1
        
        if key in [0, 3, 6]:
            ans.append('L')
            left = key
            continue
        
        if key in [2, 5, 8]:
            ans.append('R')
            right = key
            continue
        
        x, y = position[key]
        lx, ly = position[left]
        rx, ry = position[right]
        
        if abs(lx-x)+abs(ly-y) < abs(rx-x)+abs(ry-y):
            ans.append('L')
            left = key
            continue
        
        if abs(rx-x)+abs(ry-y) < abs(lx-x)+abs(ly-y):
            ans.append('R')
            right = key
            continue
        
        if hand == 'left':
            ans.append('L')
            left = key
            continue
        
        if hand == 'right':
            ans.append('R')
            right = key
    
    return ''.join(ans)