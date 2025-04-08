def solution(my_string):
    ls = list(my_string)
    while 'a' in ls: ls.remove('a')
    while 'e' in ls: ls.remove('e')
    while 'i' in ls: ls.remove('i')
    while 'o' in ls: ls.remove('o')
    while 'u' in ls: ls.remove('u')
    return ''.join(ls)