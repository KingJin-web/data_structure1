package dao;


import MySQL.DBHelper;
import MySQL.IOHelper;
import bean.Student;

import java.sql.*;
import java.util.ArrayList;


public class StudentDaoImp implements StudentDao {


    public StudentDaoImp() {
    }


    DBHelper dbHelper = new DBHelper();
    // 每次都会通过open方法获取连接

    Connection conn = dbHelper.openConnection();
    private boolean isAutoCommit = true;

    /**
     * http://39.107.46.233/
     * 获取连接
     *
     * @return
     */
    public Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            RuntimeException re = new RuntimeException("数据库驱动加载失败!", e);
            throw re;
        }
        String url = "jdbc:mysql://rm-bp1by93uevp3655w7uo.mysql.rds.aliyuncs.com/aaa?useUnicode=true&characterEncoding=UTF-8";
        // 数据库的地址
        String user = "student";
        // 数据的用户
        String password = "aaaaaaaa";
        try {
            if (isAutoCommit) {
                return DriverManager.getConnection(url, user, password);
            } else {
                if (conn == null) {
                    // 禁止自动提交
                    conn = DriverManager.getConnection(url, user, password);
                    conn.setAutoCommit(isAutoCommit);
                }
                return conn;
            }
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败!", e);
        }
    }

    @Override
    public ArrayList<Student> selectAllStudent() throws SQLException {

        try {
            conn = openConnection();

            String sql = "select * from db_student where 1=1 ";


            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Student> ret = new ArrayList<>();
            while (rs.next()) {
                Student s = new Student();
                s.setSname(rs.getString("sname"));
                s.setSid(rs.getString("sid"));
                s.setEnglish(rs.getDouble("English"));
                s.setHistory(rs.getDouble("History"));
                s.setMath(rs.getDouble("Math"));
                s.setPe(rs.getDouble("pe"));
                s.setData_structure(rs.getDouble("Data_structure"));
                s.setTotal_score(rs.getDouble("Total_score"));


                ret.add(s);
            }
            return ret;

        } finally {
            IOHelper.close(conn);
        }
    }

    @Override
    public int addStudent(String sname, String sid, double english, double history, double math, double pe, double data_structure, double total_score) {

        String sql = "insert into db_student (sname, sid, english, history, math ,pe, data_structure,cdate,total_score) values(?,?,?,?,?,?,?,NOW(),?)";
        dbHelper.update(sql, sname, sid, english, history, math, pe, data_structure, total_score);
        return 1;
    }


    @Override
    public int deleteStudent(String uid) {
        String sql = "delete from db_student where sid = ?";
        dbHelper.update(sql, uid);
        System.out.println("删除成功");

        return 1;
    }

    @Override
    public int updateStudent(String name, String property, double newMark) {
        return 0;
    }


    @Override
    public ArrayList<Student> selectStuBySid(String sid) throws SQLException {
        try {


            String sql = "select * from db_student where sid = ?";
            ArrayList<Student> list1 = new ArrayList();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setSname(rs.getString("sname"));
                s.setSid(rs.getString("sid"));
                s.setEnglish(rs.getDouble("English"));
                s.setHistory(rs.getDouble("History"));
                s.setMath(rs.getDouble("Math"));
                s.setPe(rs.getDouble("pe"));
                s.setData_structure(rs.getDouble("Data_structure"));
                s.setTotal_score(rs.getDouble("Total_score"));


                list1.add(s);
            }

            return list1;
        } finally {
            IOHelper.close(conn);
        }
    }

    @Override
    public ArrayList<Student> pagingQuery(int a, int b) throws SQLException {
        Connection conn = openConnection();
        try{
            ArrayList<Student> list1 = new ArrayList();
            String sql = "select * from db_student limit ?,?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, a);
            ps.setInt(2, b);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                Student s = new Student();
                s.setSname(rs.getString("sname"));
                s.setSid(rs.getString("sid"));
                s.setEnglish(rs.getDouble("English"));
                s.setHistory(rs.getDouble("History"));
                s.setMath(rs.getDouble("Math"));
                s.setPe(rs.getDouble("pe"));
                s.setData_structure(rs.getDouble("Data_structure"));
                s.setTotal_score(rs.getDouble("Total_score"));


                list1.add(s);
            }
            return list1;
        }finally {
            IOHelper.close(conn);
        }



    }

}

