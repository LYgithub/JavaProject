import com.company.Main;

/**
 * @author LiYang
 */
public class arr {
    public static void main(final String[] args) {
        final int[] arr1 = new int[] { 1, 2, 3, 4, 5 };
        Main.print_arr(arr1);
        final int[] arr2 = arr1;
        Main.InsertionSortWithPiquet(arr2);
        Main.print_arr(arr1);

        // Test test1 = new Test();
        final Test test2 = new Test();
        Test.x = 20;
        test2.print_x();
    }
}

class Test {

    public static int x = 10;

    public static void set_x(final int x) {
        Test.x = x;
    }
    public void print_x(){
        System.out.println(x);
    }

}