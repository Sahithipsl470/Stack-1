// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// We use a monotonic decreasing stack to store indices of elements whose next greater element is not yet found.
// We traverse the array twice (using modulo) to simulate the circular nature of the array.
// Whenever the current element is greater than the stack top, we update the result for that index.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                int idx = stack.pop();
                result[idx] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return result;
    }
}
