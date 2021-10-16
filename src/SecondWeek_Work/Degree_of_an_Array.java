package SecondWeek_Work;

import java.util.HashMap;
import java.util.Map;

/*
第二周作业：697. Degree of an Array 数组的度
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums == null) return 0;
        Map<Integer, int[]> require = new HashMap<>();
        int len = nums.length, res;
        int right = len - 1;
        for (int i = 0; i < len; i++) {
            if (require.containsKey(nums[i])) {
                require.get(nums[i])[0]++;
                require.get(nums[i])[2] = i;
            }
            else {
                require.put(nums[i], new int[]{1, i, i});
            }
        }
        int minLen = require.get(nums[0])[2] - require.get(nums[0])[1] + 1;
        int val = require.get(nums[0])[0];
        for (int[] list : require.values()) {
            if (list[0] == val) {
                if (list[2] - list[1] + 1 < minLen) {
                    minLen = list[2] - list[1] + 1;
                }
            }
            else if (list[0] > val) {
                val = list[0];
                minLen = list[2] - list[1] + 1;
            }
            else {
                continue;
            }
        }
        return minLen;
    }
}
