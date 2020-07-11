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
        System.out.println("1.��ѯѧ����Ϣ");
        System.out.println("2.���ѧ����Ϣ");
        System.out.println("3.�޸�ѧ����Ϣ");
        System.out.println("4.ɾ��ѧ����Ϣ");
        System.out.println("5.��ȡ��Ϣ�ļ�");
    }

    public static void start() {

        while (true) {
            menu();
            System.out.println("��������Ҫ���еĲ��������");

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
                    System.out.println("�����������������");
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
        System.out.println("��Ҫѡ�����ֲ�ѯ��ʽ��");
        System.out.println("1.�����ѯ");
        System.out.println("2.��ҳ��ѯ");
        System.out.println("3.ѧ�Ų�ѯ");
        System.out.println("4.������ѯ");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                ArrayList<Student> list = null;
                try {
                    list = sd.selectAllStudent();
                    System.out.println("����   ѧ��  Ӣ��  ��ʷ   ����   ����  ���ݽṹ �ܷ�");
                    l.setUpObjects();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                for (int i = 0; i < list.size(); i++) {
                    //System.out.println(list.get(i));
                }
                break;
            case 2:
                System.out.println("������Ҫ�ֵ�ҳ�������磺1-5����");
                int choose1 = scanner.nextInt();
                int choose2 = scanner.nextInt();
                try {
                    ArrayList<Student> list1 = sd.pagingQuery(choose1, choose2);
                    System.out.println("����   ѧ��  Ӣ��  ��ʷ   ����   ����  ���ݽṹ �ܷ�");
                    for (int i = 0; i < list1.size(); i++) {
                        System.out.println(list1.get(i));
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case 3:
                System.out.println("��������Ҫ��ѯ��ѧ�ţ�");
                String sid = new Scanner(System.in).nextLine();
                try {
                    ArrayList<Student> list2 = sd.selectStuBySid(sid);
                    System.out.println("����   ѧ��  Ӣ��  ��ʷ   ����   ����  ���ݽṹ �ܷ�");
                    for (int i = 0; i < list2.size(); i++) {
                        System.out.println(list2.get(i));
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case 4:
                System.out.println("��������Ҫ��ѯ��ѧ��������");
                String sname = new Scanner(System.in).nextLine();
                l.findStudent(sname);
                break;
            default:
                System.out.println("�����������������");
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
        System.out.println("��������Ҫɾ����ѧ��ѧ��");
        String sid = new Scanner(System.in).nextLine();
        sd.deleteStudent(sid);
    }

    public static void updateStudent() {
        System.out.println("��������Ҫ�޸ĵ�ѧ��ѧ�ţ�");
        String sid = new Scanner(System.in).nextLine();

        System.out.println("��������Ҫ�޸ĵĿ�Ŀ��ţ�");
        System.out.println("1.Ӣ��");
        System.out.println("2.��ʷ");
        System.out.println("3.��ѧ");
        System.out.println("4.����");
        System.out.println("5.���ݽṹ");
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

        System.out.println("��������Ҫ�޸ĵķ�����");
        double score = scanner.nextDouble();
        sd.updateStudent(sid, property, score);
        System.out.println("�޸ĳɹ�");
    }

    public static void addStudent() {
        System.out.println("��������Ҫ��ӵ�ѧ������");
        String name = new Scanner(System.in).nextLine();

        System.out.println("��������Ҫ��ӵ�ѧ��ѧ��");
        String sid = new Scanner(System.in).nextLine();

        System.out.println("��������Ҫ��ӵ�ѧ���ɼ�������Ϊ��Ӣ���ʷ����ѧ�����������ݽṹ����");
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
