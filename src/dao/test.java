package dao;

import bean.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        StudentDao s = new StudentDaoImp();
        ArrayList<Student> list = s.selectAllStudent();
        System.out.println("姓名   学号  英语  历史   高数   体育  数据结构 总分");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //输出全部成绩
//        System.out.println("姓名   学号  英语   历史  高数   体育  数据结构 总分");
//        ListSort L = new ListSort();
//        L.addStudent("张三丰", "0006", 99, 85, 98, 36, 89);
        // 插入学生成绩

//        ListSort l = new ListSort();
//        l.setUpObjects();
//        //学生成绩排序（总分排序）

//        l.findStudent("许如愿");
//        //查找 姓名查找


//        ArrayList<Student> list1 = s.pagingQuery(1, 3);
//        //分页查询
//        System.out.println("姓名   学号  英语  历史   高数   体育  数据结构 总分");
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println(list1.get(i));
//        }

//        ArrayList<Student> list2 = s.selectStuBySid("00011");
//        //学号查询
//        if (list2.size() == 0){
//            System.out.println("抱歉查无此人");
//
//        }else {
//            System.out.println(list2);
//        }
            s.updateStudent("0001","english",86);
        //成绩的修改


    }


}

