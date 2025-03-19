def solution(price, money, count):
    p = 0
    while count > 0:
        p += count*price
        count-=1
    
    if p > money:
        return p-money
    return 0