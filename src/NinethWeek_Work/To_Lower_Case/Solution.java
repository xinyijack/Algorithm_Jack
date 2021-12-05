package NinethWeek_Work.To_Lower_Case;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 709.To Lower Case 转换为小写字母
 * @createTime 2021年12月05日 21:43:00
 */
class Solution {
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            // a-z：97-122  A-Z：65-90  0-9：48-57
            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char)(ch + 32));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}





