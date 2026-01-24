s = input()
res = 0

for i in range(len(s)):
    if s[i:i+4] == "kick":
        res += 1
print(res)