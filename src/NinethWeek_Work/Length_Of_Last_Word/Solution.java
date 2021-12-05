package NinethWeek_Work.Length_Of_Last_Word;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 58.Length of Last Word 最后一个单词的长度
 * @createTime 2021年12月05日 21:44:00
 */
class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
}
