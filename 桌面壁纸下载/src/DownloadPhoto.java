import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author LiYang
 * 图片下载程序
 * https://wallpaper.infinitynewtab.com/wallpaper/2352.jpg
 * 1000 - 2244
 */
public class DownloadPhoto {
    public static void main(String[] args)  {
        String  str = "https://wallpaper.infinitynewtab.com/wallpaper/";

        for (int i = 2245; i < 3500; i++) {
            try {
                URL url = new URL(str + i + ".jpg");
                download(url, i);
                System.out.println(url.toString());
            }
            catch (IOException e){
                System.out.println(e.toString());
            }
        }
    }

    private static void download(URL url, int i ) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        InputStream input = conn.getInputStream();
        int n;
        File file = new File("/Users/mac/Desktop/photo/" + i + ".jpg");
        FileOutputStream out = new FileOutputStream(file);
        while ( (n = input.read())!= -1){
            out.write(n);
        }
        out.close();

    }

}

