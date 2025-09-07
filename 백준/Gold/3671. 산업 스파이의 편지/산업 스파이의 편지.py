from itertools import permutations
import math

num = 9999999                               # 종이조각 수가 최대 7개이고 가장 큰 숫자가 9이므로 소수 판별 최댓값은 9999999로 설정
prime = [True for i in range(num+1)]        # 해당 숫자(인덱스)가 소수라면 True, 소수가 아니라면 False를 넣을 배열

for i in range(2, int(math.sqrt(num)+1)):   # 에라스토테네스의 체(2부터 num의 제곱근까지 반복)
    if prime[i]:            
        j = 2
        while i*j <= num:                   
            prime[i*j] = False              # i의 배수는 false로 바꿔줌(배수는 소수가 아니기 때문에)
            j+=1
prime[1] = False                            # 1은 소수가 아니므로

c = int(input())
for i in range(c):
    result = 0
    temp = input()
    lenT = len(temp)
    num = []
    for j in range(lenT):                   # 입력받은 숫자를 각각 int형으로 배열에 넣어줌
        num.append(int(temp[j]))
    for j in range(1, lenT+1):
        per = list(set(permutations(num, j)))
        for x in per:                       # 각 순열을 숫자로 만듦      
            p = ''
            for y in x:
                p += str(y)
            if p and p[0] != '0':           # p값이 없거나 맨앞자리가 0일 경우는 제외
                p = int(p)
                if prime[p]:
                    result += 1
    print(result)