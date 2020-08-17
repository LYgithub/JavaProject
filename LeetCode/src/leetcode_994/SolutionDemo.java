package leetcode_994;

/**
 *  @author LiYang
    在给定的网格中，每个单元格可以有以下三个值之一：

    值 0 代表空单元格；
    值 1 代表新鲜橘子；
    值 2 代表腐烂的橘子。
    每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。

    返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/rotting-oranges
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    分析：
        设置一个 int 变量 表示 含有 多少 新鲜的橘子  int  number = ? (方法)
        设置一个时间 数 int time = 0;
        遍历一遍全部 橘子，对烂橘子 的四周 依次判断
        如果有新鲜的橘子 -> 变成不新鲜 -> 新鲜橘子数 -1

        当 遍历一遍 新鲜橘子数不变时，表示 不新鲜橘子 最大情况
            这时如果 含有新鲜的橘子 ，返回 -1
            否则 返回  时间数

 */
public class SolutionDemo {
    public static int orangesRotting(int[][] grid) {
        int number = findNumber(grid);
        int time = 0;
        if (number == 0){
            return time;
        }
        //开始 变质
        while (number > 0){
            int number1 = number;
            //变质一次
            for (int i = 0; i < grid[0].length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    if(grid[i][j] == 2){
                        //变质四方
                        if( i+1 <grid[i].length && grid[i+1][j] == 1){
                            grid[i+1][j] =2;
                            number --;
                        }
                        if( i-1 >= 0 && grid[i-1][j] == 1){
                            grid[i-1][j] =2;
                            number --;
                        }
                        if( j-1 >= 0&& grid[i][j-1] == 1){
                            grid[i][j-1] =2;
                            number --;
                        }
                        if( j+1 < grid.length && grid[i][j +1] == 1){
                            grid[i][j+1] =2;
                            number --;
                        }
                    }

                }
            }

            print(grid);

            if(number1==number ){
                break;
            }else{
                time++;
            }
        }
        return time;


    }

    public static int findNumber(int [][] grid){
        int number = 0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j] == 1) {
                    number ++;
                }
            }
        }

        return number;
    }


    public static void print(int [][] a){
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();

        }
    }
    public static void main(String[] args) {
        int [][] a = {{2,1,1},{1,1,0},{0,1,1}};




        System.out.println(orangesRotting(a));
    }
}
