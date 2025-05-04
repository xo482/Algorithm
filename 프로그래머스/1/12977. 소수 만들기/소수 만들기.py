from itertools import combinations as comb
def solution(nums):
    ls = [sum(i) for i in comb(nums, 3)]
    ans = len(ls)
    cnt = 0
    
    for v in ls:
        for i in range(2, (int(v**0.5))+1):
            if v%i == 0:
                cnt+=1
                break
    
    return ans - cnt