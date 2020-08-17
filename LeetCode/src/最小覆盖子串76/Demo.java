package 最小覆盖子串76;

/**
 * @author LiYang
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution1 {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {return "";}
        int number = t.length();
        int i = -1, j = 0, index;
        boolean [] keys = new boolean[t.length()];

        //开始遍历
        for( ;j < s.length();j++){
            index = s.indexOf(t.charAt(j));
            System.out.println(t.charAt(j) + " 位置：" + s.indexOf(t.charAt(j)));
            // 含有
            if( index != -1 ){
                //查找过
                if(keys[index]){
                    //前后相同
                    if(s.charAt(i) == s.charAt(j)){
                        i ++ ;
                    }
                    while(in(t, s.charAt(i)) == -1){ i++;}
                }
                else{
                    number-- ;
                    System.out.println(number);
                    if(number == -1){
                        System.out.println("字符串：" + s.substring(i, j));
                        number = t.length();
                        i ++;
                        j = i+1;
                    }
                }
            }
            System.out.println(s.substring(i, j));
        }
        return null;
    }

    public int in(String s, char x){
        for (int i = 0; i < s.length(); i++) {
            if(x == s.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
}
