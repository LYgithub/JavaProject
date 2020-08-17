package 最小覆盖子串76;

import java.util.HashMap;

/**
 * @author LiYang
 * 滑动窗口
 * 何时右划
 */

@SuppressWarnings("all")
class Solution {
    public String minWindow(String s, String t) {
        System.out.println("-----------");
        if(s.length() < t.length() || t=="") {
            return "";
        }

        //统计t字符出现的次数
        HashMap<Character , Integer> map = new HashMap<>();
        int number_t = t.length();
        for(char ch : t.toCharArray()){
            if(map.containsKey(ch)){
                Integer integer = map.get(ch);
                map.put(ch, ++integer);
            }else{
                map.put(ch, 1);
            }
        }
        int left = 0,right =0, minLen = s.length() +1, start = 0;
        while (left < s.length() && right<s.length()){

            // 在Map中
            if(map.get(s.charAt(right))!= null){
                map.put(s.charAt(right), map.get(s.charAt(right)) -1);
                number_t-- ;
            }
            //含有没有统计的
            if(number_t > 0){
                right ++;
            }


            //
            if(number_t == 0){
                // left 右移




                System.out.println("较短"+left +"\t" +  right);
                minLen = minLen < (right - left)? minLen : right-left;
                start = minLen < (right - left)? start:left;

                // 含有 -> 右移
                //右移


            }
        }
        if(minLen == s.length() + 1){
            return "";
        }else{
            return s.substring(start, minLen+start+1);
        }


     }
}
