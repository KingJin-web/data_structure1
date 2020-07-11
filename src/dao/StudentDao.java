package dao;



import bean.Student;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 数据库中的数据顺序：
 * 姓名	学号
 */
public interface StudentDao {
    /**
     *  往数据库增加数据
     * @param sname 姓名
     * @param sid 学号
     * @param english 英语
     * @param history 历史
     * @param math 数学
     * @param pe 体育
     * @param data_structure;数据结构
     * @return 1 代表添加成功，0 代表添加失败
     */
    int addStudent(String sname, String sid, double english, double history, double math,
                   double pe, double data_structure, double total_score);

    /**
     * 根据学号删除数据库中的学生
     * @param uid 学号
     * @return 返回1：删除成功。返回0删除失败
     */
    int deleteStudent(String uid);

    /**
     * 更新数据库中数据，一次只能更改一项
     * @param sid 学号
     * @param property 更改的科目，只能是科目,输入内容可以是：English + history + math + pe + data_structure
     * @param newMark 这门课新的分数
     * @return 返回1：更新成功，0更新失败
     */
    int updateStudent(String sid, String property, double newMark);


    /**
     *
     * @return 返回一个数组存储所有人的数据
     */
    ArrayList<Student> selectAllStudent() throws SQLException;

    /**
     * 根据学号进行选择
     * @param sid 学号
     * @return 返回一个学生的成绩相关信息
     */
    ArrayList<Student> selectStuBySid(String sid) throws SQLException;

    /**
     * 分页查询
     * @param a
     * @param b
     * @return
     * @throws SQLException
     */
    ArrayList<Student> pagingQuery(int a, int b) throws SQLException;

}
