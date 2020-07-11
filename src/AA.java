import java.io.*;
import java.nio.charset.StandardCharsets;

public class AA {
    public static void main(String[] args) throws IOException {
        save("同一个世界 同一个梦想One World One Dream");
        System.out.println(read());
    }

    public static void save(String x) throws IOException {
        FileOutputStream fos = new FileOutputStream("test.txt");

        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        osw.write(x);

        osw.flush();
    }

    public static String read() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        System.out.println("adsdad");
        line = br.readLine();
        return line;
    }
}
