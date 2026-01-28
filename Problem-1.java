// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// We use a monotonic decreasing stack to store indices of days with unresolved warmer temperatures.
// As we iterate through the array, we pop indices when a warmer temperature is found and compute the day difference.
// Each index is pushed and popped at most once, resulting in linear time complexity.

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> elem = new Stack<>();
        int[] result = new int[temperatures.length];
        elem.add(0);
        for (int i = 1; i < temperatures.length; i++){
            while (!elem.isEmpty()){
                int latest = elem.pop();
                if (temperatures[i] > temperatures[latest]){
                    result[latest] = i- latest;
                }else{
                    elem.add(latest);
                    break;
                }
            }
            elem.add(i);
        }
        return result;
        
    }
}