package file;

import bean.Student;
import dao.StudentDao;
import dao.StudentDaoImp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 12613
 * 保存文件
 */
public class SaveFile {
    private void save() throws SQLException {
        StudentDao studentDao =new StudentDaoImp();
        //ArrayList<Student> list = s.selectAllStudent();
        List<Student> list  = studentDao.selectAllStudent();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
            for (Student s : list) {
                bw.write(String.valueOf(s));
                bw.newLine();
                bw.flush();
            }
            bw.close();
        } catch ( IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        SaveFile saveFile =new SaveFile();
        saveFile.save();
    }
}
