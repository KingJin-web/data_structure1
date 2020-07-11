import bean.Student;
import dao.ListSort;
import dao.StudentDao;
import dao.StudentDaoImp;
import file.ReadFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static StudentDao sd = new StudentDaoImp();

    public static void main(String[] args) {
        start();
    }

    public static void menu() {
        System.out.println("1.查询学生信息");
        System.out.println("2.添加学生信息");
        System.out.println("3.修改学生信息");
        System.out.println("4.删除学生信息");
        System.out.println("5.读取信息文件");
    }

    public static void start() {

        while (true) {
            menu();
            System.out.println("请输入您要进行的操作的序号");

            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    selectStudent();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    readStudent();
                    break;
                default:
                    System.out.println("输入错误请重新输入");
                    break;
            }
        }
    }

    private static void selectStudent() {
        ListSort l = null;
        try {
            l = new ListSort();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("你要选用哪种查询方式：");
        System.out.println("1.整体查询");
        System.out.println("2.分页查询");
        System.out.println("3.学号查询");
        System.out.println("4.姓名查询");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                ArrayList<Student> list = null;
                try {
                    list = sd.selectAllStudent();
                    System.out.println("姓名   学号  英语  历史   高数   体育  数据结构 总分");
                    l.setUpObjects();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                for (int i = 0; i < list.size(); i++) {
                    //System.out.println(list.get(i));
                }
                break;
            case 2:
                System.out.println("请输入要分的页数（例如：1-5）：");
                int choose1 = scanner.nextInt();
                int choose2 = scanner.nextInt();
                try {
                    ArrayList<Student> list1 = sd.pagingQuery(choose1, choose2);
                    System.out.println("姓名   学号  英语  历史   高数   体育  数据结构 总分");
                    for (int i = 0; i < list1.size(); i++) {
                        System.out.println(list1.get(i));
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case 3:
                System.out.println("请输入你要查询的学号：");
                String sid = new Scanner(System.in).nextLine();
                try {
                    ArrayList<Student> list2 = sd.selectStuBySid(sid);
                    System.out.println("姓名   学号  英语  历史   高数   体育  数据结构 总分");
                    for (int i = 0; i < list2.size(); i++) {
                        System.out.println(list2.get(i));
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case 4:
                System.out.println("请输入你要查询的学生姓名：");
                String sname = new Scanner(System.in).nextLine();
                l.findStudent(sname);
                break;
            default:
                System.out.println("输入错误请重新输入");
                break;
        }
    }

    private static void readStudent() {
        ReadFile readFile = new ReadFile();
        try {
            readFile.insert2("b.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteStudent() {
        System.out.println("请输入你要删除的学生学号");
        String sid = new Scanner(System.in).nextLine();
        sd.deleteStudent(sid);
    }

    public static void updateStudent() {
        System.out.println("请输入你要修改的学生学号：");
        String sid = new Scanner(System.in).nextLine();

        System.out.println("请输入你要修改的科目序号：");
        System.out.println("1.英语");
        System.out.println("2.历史");
        System.out.println("3.数学");
        System.out.println("4.体育");
        System.out.println("5.数据结构");
        int num = scanner.nextInt();
        String property;
        switch (num) {
            case 1:
                property = "english";
                break;
            case 2:
                property = "history";
                break;
            case 3:
                property = "math";
                break;
            case 4:
                property = "pe";
                break;
            case 5:
                property = "data_structure";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + num);
        }

        System.out.println("请输入你要修改的分数：");
        double score = scanner.nextDouble();
        sd.updateStudent(sid, property, score);
        System.out.println("修改成功");
    }

    public static void addStudent() {
        System.out.println("请输入您要添加的学生姓名");
        String name = new Scanner(System.in).nextLine();

        System.out.println("请输入您要添加的学生学号");
        String sid = new Scanner(System.in).nextLine();

        System.out.println("请输入您要添加的学生成绩（依次为：英语，历史，数学，体育，数据结构）：");
        int english = scanner.nextInt();
        int history = scanner.nextInt();
        int math = scanner.nextInt();
        int pe = scanner.nextInt();
        int data_structure = scanner.nextInt();
        int total_score = (english + history + math + pe + data_structure);
        //scanner.nextLine();

        sd.addStudent(name, sid, english, history, math, pe, data_structure, total_score);
    }
}
