import sys

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n, b = map(int, input().split())
    part = {}
    quality_set = set()

    for _ in range(n):
        tp, _, price, quality = input().split()
        price = int(price)
        quality = int(quality)

        quality_set.add(quality)

        if tp not in part:
            part[tp] = []
        part[tp].append((price, -quality))

    for key in part.keys():
        part[key].sort()

    quality_list = sorted(list(quality_set))
    while quality_list:
        require_quality = quality_list.pop()
        total_price = 0
        is_ok = False

        for key in part.keys():
            is_ok = False

            for now_price, now_quality in part[key]:
                if -now_quality >= require_quality:
                    total_price += now_price
                    is_ok = True
                    break

            if not is_ok:
                break

        if is_ok and total_price <= b:
            print(require_quality)
            break
