package dao;

import bean.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        ArrayList<Student> list = s.selectAllStudent();
//        System.out.println("姓名   学号  英语  历史   高数   体育  数据结构 总分");
//        for(int i = 0 ; i<list.size();i++){
//            System.out.println(list.get(i));
//        }
//        System.out.println("姓名   学号  英语   历史  高数   体育  数据结构 总分");
//        ListSort L = new ListSort();
//        L.addStudent("张  三", "0005", 99, 56, 98, 36, 18);
        // 插入学生成绩
        ListSort l = new ListSort();
        l.setUpObjects();
        //学生成绩排序（总分排序）
        l.findStudent("许如愿");
        //查找 姓名查找



    }
}
