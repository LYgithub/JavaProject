package leetcode1;

/**
 * @Project Name: LeetCode
 * @Package Name: leetcode1
 * Created by MacBook Air on 2020/01/29.
 * Copyright © 2020 KawYang. All rights reserved.
 */

/**
 * Definition for singly-linked list.
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

///**
// * 提交内容
// */
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        //sum 存储和 p q 哨兵 px 新创建的结点
//        ListNode sum = null,p,q,px;
//        int in = 0;
//        for(p = l1,q = l2; p!=null && q!=null ;p = p.next,q = q.next){
//            //头插法输入数字
//            px = sum;
//            sum = new ListNode(p.val+q.val+in);
//            sum.next = px;
//        }
//        //如果 p位数多
//        while (p!=null){
//            px = sum;
//            sum = new ListNode(p.val + in);
//            sum.next = px;
//            p = p.next;
//        }
//        while (q!=null){
//            //头插法输入数字
//            px = sum;
//            sum = new ListNode(q.val + in);
//            sum.next = px;
//            q = q.next;
//        }
//        //in 如果不是0 还要插入
//        if (in != 0){
//            px = sum;
//            sum = new ListNode(in);
//            sum.next = px;
//        }
//        return sum;
//    }
//}


/**
 * @author Mac
 */
public class Test1 {
    public static int x = 5;

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = Creat(x);
        ListNode l2 = Creat(x);

        ListNode sum = solution.addTwoNumbers(l1,l2);
        for (ListNode p = sum ;p != null ;p = p.next){
            System.out.print(p.val);
        }
    }


    /**
     *创建单链表 从0 - x
     */
    static ListNode Creat (int x){
        ListNode l = new ListNode(0);
        //尾插法
        for (int i = 1; i < x ; i++) {
            ListNode p = l.next;
            l.next = new ListNode(i);
            l.next.next = p;
        }
        return l;
    }
}
