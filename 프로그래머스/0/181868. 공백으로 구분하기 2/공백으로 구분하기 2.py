def solution(my_string):
    
    temp = my_string.split(" ")
    ans = []
    for i in temp:
        if i == "": continue
        ans.append(i)
    return ans