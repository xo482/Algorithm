def solution(price, money, count):
    p = price*(count*(count+1))/2
    
    if p > money:
        return p-money
    return 0