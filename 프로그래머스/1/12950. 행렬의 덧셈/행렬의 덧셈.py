def solution(arr1, arr2):
    return [ [x+y for x, y in zip(l1,l2)] for l1, l2 in zip(arr1, arr2)]
