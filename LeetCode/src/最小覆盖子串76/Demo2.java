package 最小覆盖子串76;

import java.util.HashMap;

/**
 * @author LiYang
 * @Project Name: LeetCode
 * @Package Name: 最小覆盖子串76
 * Created by MacBook Air on 2020/05/24.
 * Copyright © 2020 LiYang. All rights reserved.
 */
class Solution2 {
    public String minWindow(String s, String t) {
        //窗口左右
        int left = 0,right;
        if(s.length() < t.length() || t.length() == 0) {return "";}

        //存储字符标记
        HashMap<Character, Boolean> keys = new HashMap<>();
        for (char c : t.toCharArray()){
            keys.put(c, false);
        }
        char right_char;

        String value = s+s.hashCode();
        while (left < s.length() && keys.get(s.charAt(left)) == null){ left ++;}
        right = left;
        while (right < s.length()){
            //在t中
            right_char = s.charAt(right);
            if(keys.get(right_char) != null){
                //如果被标记
                if(keys.get(right_char)){
                    //前后相同
                    if(s.charAt(right) == s.charAt(left)){
                        left ++;
                        //无
                        while (keys.get(s.charAt(left)) == null){ left ++;}
                    }
                }else{//没有被标记
                    //修改标记
                    keys.remove(right_char);
                    keys.put(right_char, true);
                    //全部被标记
                    if(allTrue(keys)){
                        System.out.println(s.substring(left,right+1));
                        value = value.length() < right+1-left ? value:s.substring(left,right+1);
                        //修改标记
                        keys.remove(s.charAt(left));
                        keys.put(s.charAt(left), false);
                        left ++;
                        while (left < s.length() &&keys.get(s.charAt(left)) == null){
                            left ++;
                        }
                    }
                }

            }
            right ++;
        }
        if (value.equals(s + s.hashCode())){
            return "";
        }else {
            return value;
        }

    }

    public boolean allTrue(HashMap<Character, Boolean> map){
        for (boolean x:map.values()){
            if(!x){return false;}
        }
        return true;
    }
}


