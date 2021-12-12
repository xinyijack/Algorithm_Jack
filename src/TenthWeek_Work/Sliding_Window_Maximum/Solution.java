package TenthWeek_Work.Sliding_Window_Maximum;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jack_xin
 * @ClassName Solution
 * @Desc 第十周作业——239. 滑动窗口最大值
 * @date 2021年12月12日 16:35
 * @Version TODO
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> window = new LinkedList<Integer>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            while (!window.isEmpty() && nums[i] >= nums[window.peekLast()]) {
                window.pollLast();
            }
            window.offerLast(i);
        }

        ans[0] = nums[window.peekFirst()];
        for (int j = k; j < n; j++) {
            while (!window.isEmpty() && nums[j] >= nums[window.peekLast()]) {
                window.pollLast();
            }
            window.offerLast(j);

            while (window.peekFirst() <= j - k) {
                window.pollFirst();
            }
            ans[j - k + 1] = nums[window.peekFirst()];
        }
        return ans;
    }
}
