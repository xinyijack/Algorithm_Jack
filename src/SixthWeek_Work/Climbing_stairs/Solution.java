package SixthWeek_Work.Climbing_stairs;

/**
 * 学号：G20210760020092
 * 第六周作业第一题：70.爬楼梯
 */
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
