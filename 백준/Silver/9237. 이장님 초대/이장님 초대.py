n = int(input())
ls = sorted(list(map(int, input().split())), reverse=True)
print(max([ls[i]+i+2 for i in range(len(ls))]))