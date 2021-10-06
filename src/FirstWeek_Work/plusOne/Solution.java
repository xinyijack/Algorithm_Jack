package FirstWeek_Work.plusOne;
//第一周作业第一题 加一 https://leetcode-cn.com/problems/plus-one/
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n - 1;
        while (i >= 0) {
            int j = plusOne(digits[i]);
            digits[i] = j;
            if (j == 0 && i > 0) {
                i--;
            }
            else if (i == 0 && digits[i] == 0) {
                return moveRightOne(digits);
            }
            else break;
        }
        return digits;
    }

    public int plusOne(int x) {
        if (x == 9) return 0;
        return x + 1;
    }

    public int[] moveRightOne(int[] m) {
        int t = m.length;
        int[] l = new int[t + 1];
        for (int i = t - 1; i >= 0; i--) {
            l[i + 1] = m[i];
            if (i == 0) l[i] = 1;
        }
        return l;
    }
}
