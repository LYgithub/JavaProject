package leetcode_994;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiYang
    橘子 不新鲜问题

    遍历四周 方法
        dx[] = {1,-1,0,0};
        dy[] = {0,0,1,-1};
        for(int i = 0;i<4;i++){
            x = x + dx[i];
            y = y + dy[i];
        }
    传染
        遍历一遍 将 起始变质的存入队列，一次出队 传染
        传染的橘子 入新的队列  ，方便二次传染。
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int [][] a = {{2,1,1},{0,1,0},{1,0,1}};
        int [][] a = {{0}};


        System.out.println("次数："+solution.orangesRotting(a));
    }
}


/**
 *  定义一个初始队列
 *  定义一个辅助队列
 *  辅助队列获取本次 传染的橘子
 *  结束后 将辅助队列 赋值给 初始队列
 *
 *  全是新鲜的 返回 -1
 *  全是不新鲜 返回 0
 *  一个新鲜 一个不新鲜 返回 1
 *  没有橘子 返回 0
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Point> queue = findNotGood(grid);
        int time = 0;
        //没有不好的 并且 有好的 才是 -1 啊
        if(queue.isEmpty() && isGood(grid)){
            return -1;
        }
        while (!(queue = changeOranges(grid,queue)).isEmpty()){

//            print(grid);
            time ++;
        }
        if (isGood(grid)){
            time = -1;
        }

        return time;
    }

    private void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print("|"+grid[i][j] +"\t");
            }
            System.out.println();
        }

        System.out.println("=========");
    }

    private Queue<Point> changeOranges(int[][] grid, Queue<Point> queue) {
        Queue<Point > points = new LinkedList<>();
        int [] dx = {0,0,1,-1};
        int [] dy = {1,-1,0,0};
        while (!queue.isEmpty()){
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = point.x + dx[i];
                int y = point.y + dy[i];
                if(x>=0 && x< grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1){
                    grid[x][y] = 2;
                    points.add(new Point(x,y));
//                    System.out.println("add" + "<"+x+","+y+">");
                }
            }
        }
        return points;
    }

    private Queue<Point> findNotGood(int [][] grid){

        Queue<Point> points = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2){
                    points.add(new Point(i,j));
                }
            }
        }
        return points;
    }


    private boolean isGood(int [][] args){
        boolean b = false;
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args[0].length; j++) {
                if(args[i][j] == 1){
                    b = true;
                    break;
                }
            }
        }

        return b;
    }
}
