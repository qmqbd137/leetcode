/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 *
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (50.49%)
 * Likes:    1235
 * Dislikes: 0
 * Total Accepted:    285.9K
 * Total Submissions: 565.4K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        int oneZ = numRows + (numRows-2) * 1;
        int totallen = s.length();
        if(totallen <= numRows || numRows == 1){
            return s;
        } 
        int col = (totallen / oneZ + 1)*(numRows-1);
        char[][] charmartix = new char[numRows][col];
        //将字符串转化为单个字符组成的字符数组，设置idnex作为其坐标记录
        char[] sarray = s.toCharArray();
        int sindex = 0;
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < numRows; i++) {
                if((sindex < totallen) && (j % (numRows -1) == 0 || ( i + j  ) % (numRows - 1) ==0)){
                    charmartix[i][j] = sarray[sindex++];
                }else{
                    charmartix[i][j] = ' ';
                }
            }   
        }
        StringBuffer sbuff = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < col; j++) {
                if(charmartix[i][j] != ' '){
                    sbuff.append(charmartix[i][j]);
                }
            }
        }
        return sbuff.toString();
    }
}
// @lc code=end

