# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# We use a monotonic decreasing stack to store indices of elements whose next greater element is not yet found.
# We traverse the array twice (using modulo) to simulate the circular nature of the array.
# Whenever the current element is greater than the stack top, we update the result for that index.

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = deque()
        stack.append(0)
        result = [-1]*len(nums)
        n = len(nums)
        for i in range(1, 2*n):
            while stack:
                latest = stack.pop()
                if nums[latest] < nums[i%n]:
                    result[latest] = nums[i%n]
                else:
                    stack.append(latest)
                    break
            if i < n:
                stack.append(i)
        return result