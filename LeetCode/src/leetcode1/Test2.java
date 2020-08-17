package leetcode1;

/**
 * @Project Name: LeetCode
 * @Package Name: leetcode1
 * Created by MacBook Air on 2020/01/29.
 * Copyright © 2020 KawYang. All rights reserved.
 */


/**
 * 提交内容
 * 0 还尚未解决
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //sum 存储和 p q 哨兵 px 新创建的结点
        ListNode sum = null,p,q,px;
        int in = 0;
        for(p = l1,q = l2; p != null && q != null ;p = p.next,q = q.next){
            int temp = in;
            //计算和
            if(p!= null){
                temp += p.val;
            }
            if(q!=null){
                temp += q.val;
            }
            in = temp/10;
            temp = temp%10;
            //头插法输入数字
            px = sum;
            sum = new ListNode(temp);
            sum.next = px;
        }
        //in 如果不是0 还要插入
        if (in != 0){
            px = sum;
            sum = new ListNode(in);
            sum.next = px;
        }
        return sum;
    }
}

