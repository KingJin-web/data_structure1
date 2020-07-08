package bean;

import java.util.Objects;

public class Student {
    // 姓名
    private String sname;
    // 学号
    private String sid;
    // 英语
    private double English;
    // 近代史
    private double history;
    // 高等数学
    private double math;
    // 大学体育
    private double pe;
    //  数据结构
    private double data_structure;
    //
    private double total_score;

    // 有参构造函数
    public Student(String sname, String sid, double english, double history, double math, double pe, double data_structure, double total_score) {
        this.sname = sname;
        this.sid = sid;
        English = english;
        this.history = history;
        this.math = math;
        this.pe = pe;
        this.data_structure = data_structure;
        this.total_score = total_score;
    }

    public Student() {

    }

    public double getTotal_score() {
        return total_score;
    }

    public void setTotal_score(double total_score) {
        this.total_score = total_score;
    }

    @Override
    public String toString() {
        //System.out.println("姓名 学号英语 历史 高数 体育 数据结构 总分");
        return sname + ' ' +
                sid + "  " +
                English +"  " +
                history +"  " +
                math +"  " +
                pe +"  " +
                data_structure +"   " +
                total_score
                ;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Double.compare(student.English, English) == 0 &&
                Double.compare(student.history, history) == 0 &&
                Double.compare(student.math, math) == 0 &&
                Double.compare(student.pe, pe) == 0 &&
                Double.compare(student.data_structure, data_structure) == 0 &&
                Objects.equals(sname, student.sname) &&
                sid.equals(student.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sname, sid, English, history, math, pe, data_structure);
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public double getEnglish() {
        return English;
    }

    public void setEnglish(double english) {
        English = english;
    }

    public double getHistory() {
        return history;
    }

    public void setHistory(double history) {
        this.history = history;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPe() {
        return pe;
    }

    public void setPe(double pe) {
        this.pe = pe;
    }

    public double getData_structure() {
        return data_structure;
    }

    public void setData_structure(double data_structure) {
        this.data_structure = data_structure;
    }
}
