package liu;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java.io.OutputStream
 * @author LiYang
 */
public class DemoOutputStream {
    public static void main(String[] args) throws IOException {
        //创建一个FileOutputStream对象
        FileOutputStream fos = new FileOutputStream("src/liu/a.txt");
        //调用写方法
        fos.write(97);
        //关闭释放资源
        fos.close();
    }
}
