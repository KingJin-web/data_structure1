package file;

import MySQL.DBHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {
    /**
     * 一次性导入全部
     */
    public void insert2(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line ;
        String sql = "insert into db_student (sname, sid, english, history, math ,pe, data_structure,cdate,total_score) " +
                "values(?,?,?,?,?,?,?,NOW(),?)";

        DBHelper dbHelper = new DBHelper();
        StringBuilder sb = new StringBuilder("insert into db_student  values");
        List<Object> param = new ArrayList<>();
        while (bufferedReader.readLine() != null&& (line = bufferedReader.readLine()).length() !=0){
            sb.append("(?,?,?,?,?,?,?,NOW(),?),");
            String[] arr = line.split("\\s+");
//            for (String s:arr){
//                param.add(s);
//            }
            param.addAll(Arrays.asList(arr));

        }
        dbHelper.update(sb.toString().substring(0,sb.length() - 1) ,param.toArray());
        System.out.println("导入完成 ");
        bufferedReader.close();
    }

    /**
     * StudentSystem
     */
    public static void main(String[] args) throws IOException {
        ReadFile readFile = new ReadFile();
        System.out.println(System.getProperty("user.dir"));
        readFile.insert2(System.getProperty("user.dir")+"\\b.txt");
    }
}
