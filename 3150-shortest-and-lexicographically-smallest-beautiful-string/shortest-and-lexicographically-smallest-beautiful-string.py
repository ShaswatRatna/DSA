class Solution:
    def shortestBeautifulSubstring(self, s: str, k: int) -> str:
        n = len(s)
        d = defaultdict(int)
        c = 0
        for i in range(n):
            if s[i] == "1":
                c += 1
                d[c] = i
        ans = ""
        m = float("inf")
        p = 1
        for key in d:
            if key - p + 1 == k:
                w = s[d[p] : d[key] + 1]

                if len(w) < m or (len(w) == m and w < ans):
                    m = len(w)
                    ans = w
                p += 1
        return ans