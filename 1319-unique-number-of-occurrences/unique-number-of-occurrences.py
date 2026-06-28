class Solution(object):
    def uniqueOccurrences(self, nums):
     
        hashmap = defaultdict(int)
        for num in nums:
            hashmap[num] += 1
        
        max_len = len(nums)
        bucket = [False] * (max_len + 1)
        
        for val in hashmap.values():
            if bucket[val]:
                return False
            bucket[val] = True
            
        return True