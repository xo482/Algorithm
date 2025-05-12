def solution(A,B):
    A.sort()
    B.sort()
    B.reverse()
    
    return sum([A[i]*B[i] for i in range(len(A))])