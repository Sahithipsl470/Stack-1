# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# We use a monotonic decreasing stack to store indices of days with unresolved warmer temperatures.
# As we iterate through the array, we pop indices when a warmer temperature is found and compute the day difference.
# Each index is pushed and popped at most once, resulting in linear time complexity.

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = deque()
        stack.append([temperatures[0],0])
        result = [0]*len(temperatures)
        for i in range(1,len(temperatures)):
            k = temperatures[i]
            while stack:
                latest = stack.pop()
                if latest[0] < k:
                    result[latest[1]] = i-latest[1]
                else:
                    stack.append(latest)
                    break 
            stack.append([k,i])
        return result