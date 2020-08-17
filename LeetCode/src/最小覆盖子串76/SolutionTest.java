package 最小覆盖子串76;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author LiYang
 * @Project Name: LeetCode
 * @Package Name: 最小覆盖子串76
 * Created by MacBook Air on 2020/05/24.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@SuppressWarnings("all")
public class SolutionTest {
    @Test
    public void testminWindw(){
        Solution solution = new Solution();
        String [][] key = new String[][]{
                {"AaacA", "aA", "Aa"},//错误
                {"ADOBECODEBANC","ABC","BANC"},
                {"ODEBANC","ABC","BANC"},
                {"BECODEBANC","ABC","BANC"},
                {"ADOBECODEB","ABC","BANC"},
                {"Aa", "aA", "Aa"},
                {"acbbaca","aba", "baca"}
        };


        for (int i = 0; i < key.length; i++) {
            System.out.println(key[i][0]+"\t" +key[i][1]);
            Assert.assertEquals(
                    solution.minWindow(key[i][0],key[i][1]),
                    key[i][2]
            );
        }
    }

}
