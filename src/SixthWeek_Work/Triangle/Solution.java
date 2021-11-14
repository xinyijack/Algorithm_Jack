package SixthWeek_Work.Triangle;

/**
 * 学号：G20210760020092
 * 第六周作业第二题：120. 三角形最小路径和
 * 复杂度分析
 * 时间复杂度：O(n^2) 其中n是三角形的行数。
 * 空间复杂度：O(n)
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }
}