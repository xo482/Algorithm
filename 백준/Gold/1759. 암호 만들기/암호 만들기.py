l, c = map(int, input().split())
ls = input().split()
ls.sort()
temp = []

def dfs(idx, cnt, temp):
    if cnt == l:
        x=0
        y=0
        for t in temp:
            if t in ['a', 'e', 'i', 'o', 'u']:
                x += 1
                continue
            y += 1
            
        if x >= 1 and y >= 2:
            print(''.join(temp))
            return
    
    for i in range(idx, c):
        temp.append(ls[i])
        dfs(i+1, cnt+1, temp)
        temp.pop()

dfs(0,0,temp)
    
    