def solution(nums):
    can = len(nums) // 2
    s = set()
    for i in nums:
        s.add(i)
        
    l = len(s)
    return l if l < can else can