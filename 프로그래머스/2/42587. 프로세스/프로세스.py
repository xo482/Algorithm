def solution(pri, loc):
    m_v = 0
    m_v_list = []
    cnt = 0
    size = len(pri)
    visited = [False] * size

    ans = 0
    idx = -1
    while True:
        if cnt == 0:
            m_v_list.append(m_v)
            m_v = 0
            for v in pri:
                if v not in m_v_list:
                    m_v = max(m_v, v)
            cnt = pri.count(m_v)

        idx = (idx + 1) % size
        if visited[idx]: continue
        if m_v != pri[idx]: continue

        ans += 1
        cnt -= 1
        visited[idx] = True
        if idx == loc: return ans