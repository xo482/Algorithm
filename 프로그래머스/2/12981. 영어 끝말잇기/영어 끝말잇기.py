def solution(n, words):
    pre_word = words[0]
    history = [pre_word]
    size = len(words)
    
    for i in range(1, size):
        word = words[i]
        if pre_word[-1] != word[0] or word in history:
            return [i%n+1, i//n+1]
        
        history.append(word)
        pre_word = word
        
        
    return [0, 0]
        