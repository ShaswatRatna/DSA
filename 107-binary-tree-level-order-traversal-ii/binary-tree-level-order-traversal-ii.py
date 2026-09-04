# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        q, ans = [root], []
        while q:
            ans.append([n.val for n in q])
            q = [c for n in q for c in (n.left, n.right) if c]
        return ans[::-1]