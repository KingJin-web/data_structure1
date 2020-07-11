package cn.hanquan.file;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * --------------------�Զ�ˢCSDN���ͷ���������--------------------
 *
 * ��Ҫˢ�������Ĳ���id��д��24�еı���userId�У��������
 * ��������ʸò������û�ID���������в�������
 *
 * ����ѧϰ����ʹ�ã���Ҫ�������ˢ������~
 */
public class aaa {

    static String userId = "qq_44737094";

    public static void main(String urlstr[]) throws IOException, InterruptedException {

        Set<String> urls = new HashSet<String>();

        // ----------------------------------------------����ÿһҳ ��ȡ��������----------------------------------------------
        final String homeUrl = "https://blog.csdn.net/" + userId + "/article/list/";// �����pageNum����
        int totalPage = 0;
        InputStream is;
        String pageStr;
        StringBuilder curUrl = null;
        for (int i = 1; i < 100; i++) {
            Thread.sleep(1000);
            System.out.println("finding page " + i);
            curUrl = new StringBuilder(homeUrl);
            curUrl.append(i);
            System.out.println(curUrl);
            is = doGet(curUrl.toString());
            pageStr = inputStreamToString(is, "UTF-8");// һ��ҳ��htmlԴ��

            List<String> list = getMatherSubstrs(pageStr, "(?<=href=\")https://blog.csdn.net/" + userId + "/article/details/[0-9]{8,9}(?=\")");
            urls.addAll(list);

            if (pageStr.lastIndexOf("�տ���Ҳ") != -1) {
                System.out.println("No This Page!");
                break;
            } else {
                System.out.println("Success~");
            }
            totalPage = i;
        }
        System.out.println("��ҳ��Ϊ: " + totalPage);

        // ---------------------------------------------------��ӡÿ������---------------------------------------------------
        System.out.println("��ӡÿ������");
        for (String s:urls) {
            System.out.println(s);
        }
        System.out.println("��ӡÿ���������");

        // ---------------------------------------------------����ÿ������---------------------------------------------------
        int i=0;
        for (String s:urls) {

            doGet(s);
            System.out.println("�ɹ����ʵ�" + (++i) + "������,��" + urls.size() + "��:" + s);
        }

        // ---------------------------------------------------�������---------------------------------------------------
        System.out.println("������ϣ��ɹ����ӷ�������" + urls.size());
    }

    public static InputStream doGet(String urlstr) throws IOException {
        URL url = new URL(urlstr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        InputStream inputStream = conn.getInputStream();
        return inputStream;
    }

    public static String inputStreamToString(InputStream is, String charset) throws IOException {
        byte[] bytes = new byte[1024];
        int byteLength = 0;
        StringBuffer sb = new StringBuffer();
        while ((byteLength = is.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, byteLength, charset));
        }
        return sb.toString();
    }

    // ����ƥ��
    public static List<String> getMatherSubstrs(String str, String regex) {
        List<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while (m.find()) {
            list.add(m.group());
        }
        return list;
    }
}
