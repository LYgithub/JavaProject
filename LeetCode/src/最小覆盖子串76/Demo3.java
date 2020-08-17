package 最小覆盖子串76;

import java.util.HashMap;

/**
 * @author LiYang
 */
@SuppressWarnings("all")
class Solution3 {
    public String minWindow(String s, String t) {
        //窗口左右
        int left = 0,right;
        if(s.length() < t.length() || t.length() == 0) {return "";}

        //存储字符标记
        HashMap<Character, Integer> keys = new HashMap<>();
        for (char c : t.toCharArray()){
            if(keys.containsKey(c)){
                Integer value = keys.get(c);
                keys.put(c, ++value);
            }else {
                keys.put(c, 1);
            }
        }
        char right_char;

        String value = s+s.hashCode();
        while (left < s.length() && keys.get(s.charAt(left)) == null){ left ++;}
        right = left;
        while (right < s.length()){
            //在t中
            right_char = s.charAt(right);
            if(keys.get(right_char) != null){
                //标记完了
                if(keys.get(right_char) == 0){
                    //前后相同
                    if(s.charAt(right) == s.charAt(left)){
                        left ++;
                        //无
                        while (keys.get(s.charAt(left)) == null){ left ++;}
                    }
                }else{//没有被标记
                    //修改标记
                    Integer integer = keys.get(right_char);
                    keys.put(right_char, --integer);
                    //全部被标记
                    if(allTrue(keys)){
                        value = value.length() < right+1-left ? value:s.substring(left,right+1);
                        //修改标记
                        Integer integer1 = keys.get(s.charAt(left));
                        keys.put(s.charAt(left), ++integer1);
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

    public boolean allTrue(HashMap<Character, Integer> map){
        for (Integer x:map.values()){
            if(x != 0){return false;}
        }
        return true;
    }
}