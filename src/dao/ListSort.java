package dao;

import Hash.Hash;
import bean.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class ListSort {

    //新建哈希表对象 int [][]a=new int[3][];
    private final Hash studentHash = new Hash();

    List<Student> object = stu.selectAllStudent();
    public String[][] objects = new String[object.size()][8];

    private static final StudentDaoImp stu = new StudentDaoImp();

    public ListSort() throws SQLException {
        int size = stu.selectAllStudent().size();
        ArrayList<Student> object = stu.selectAllStudent();
        for (int i = 0; i < size; i++) {
            //构造函数时将数据库数据存入哈希表中
            studentHash.addHash(studentHash.getHash(object.get(i).getSname()), object.get(i));
            //System.out.println(studentHash.getSumStudentNum());
        }


    }


    public static void main(String[] args) throws SQLException {
        ListSort listSort = new ListSort();
        listSort.setUpObjects();

    }


    //更新二维数组的方法
    public void setUpObjects() throws SQLException {


        for (int i = 0; i < object.size(); i++) {
            //objects[i][0] = "";
            objects[i][0] = object.get(i).getSname();
            objects[i][1] = object.get(i).getSid();
            objects[i][2] = String.valueOf(object.get(i).getEnglish());
            objects[i][3] = String.valueOf(object.get(i).getHistory());
            objects[i][4] = String.valueOf(object.get(i).getMath());
            objects[i][5] = String.valueOf(object.get(i).getPe());
            objects[i][6] = String.valueOf(object.get(i).getData_structure());
            objects[i][7] = String.valueOf(object.get(i).getTotal_score());

            //System.out.println(objects[i][1]);
        }

        test(objects, 7);
        display(objects);

    }

    //添加功能
    public boolean addStudent(
            String name,
            String sid,
            double English,
            double history,
            double math,
            double pe,

            double data_structure
    ) {
        //判断输入的分数是否符合实际
        if ((English < 0 || English > 100) ||
                (history < 0 || history > 100) ||
                (math < 0 || math > 100) ||
                (pe < 0 || pe > 100) ||
                (data_structure < 0 || data_structure > 100)) {
            return false;
        }
        //计算加权分
        double totalMark = English + history + math + pe;
        //新建student对象
        Student student = new Student(name, sid, English, history, math, pe, data_structure, totalMark);
        //添加
        if (studentHash.addHash(studentHash.getHash(student.getSname()), student)) {
            stu.addStudent(name, sid, English, history, math, pe, data_structure, totalMark);
        }


        return true;
    }

    /**
     * 数组排序
     * @param s
     * @param index 排序的第几个元素
     */
    private void test(String[][] s, int index) {
        for (int j = 0; j < s.length; j++) {
            for (int i = 0; i < s.length - 1; i++) {
                String[] ss;
                if (s[i][index].compareTo(s[i + 1][index]) < 0) {
                    ss = s[i];
                    s[i] = s[i + 1];
                    s[i + 1] = ss;
                }
            }
        }
    }

    /**
     * 输出数组
     * @param s
     */
    private void display(String[][] s) {
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {

                System.out.print(s[i][j] + "  ");
            }
            System.out.println();
        }
    }

    //查找
    public Student findStudent(String name) {
        Student student = studentHash.findHash(name);
        //查找成功返回要查找的student
        if (student != null) {

            //测试用输出
            System.out.println(student.getSname() + "    " + student.getSid() + "    " +
                    student.getEnglish() + "    " + student.getHistory() + "    " +
                    student.getMath() + "    " + student.getPe() + "    " + student.getData_structure()

                    + "    " + student.getTotal_score());
            return student;
        } else {
            System.out.println("查无此人信息");
        }
        return null;
    }

}