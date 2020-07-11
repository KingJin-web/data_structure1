package Hash;


import bean.Student;

import java.util.ArrayList;

public class Hash {

    //记录学生人数
    private int sumStudentNum = 0;
    //集合封装链表形成哈希表
    private final ArrayList<DoubleLinkList> doubleLinkLists = new ArrayList<DoubleLinkList>();

    //得到以姓为关键字的哈希值
    public String getHash(String name){
        //取姓名的第一个字为哈希值
        Object firstName = name.subSequence(0,1);
        return firstName.toString();
    }

    //从哈希表中找到要找的哈希值的链表
    public Student findHash(String name){
        //得到哈希值
        String firstName = getHash(name);
        //
        for(DoubleLinkList doubleLinkList: doubleLinkLists){
            //哈希值匹配成功
            if(firstName.equals(doubleLinkList.getFirstName())) {
                //从此链表中寻找name
                if(doubleLinkList.findAStudent(name) != null)
                //找到返回Student
                {
                    return doubleLinkList.findAStudent(name).getObj();
                }
            }
        }
        //查找失败
        return null;
    }

    //添加
    public boolean addHash(String firstName, Student student){
        //介值判断哈希表中存不存在此哈希值
        boolean flag = false;
        for(DoubleLinkList doubleLinkList: doubleLinkLists) {
            //哈希表中已有此哈希值
            if (firstName.equals(doubleLinkList.getFirstName())) {
                //直接添加在此链表中
                doubleLinkList.addANode(student);
                flag = true;
                break;
            }

        }
        //不存在此哈希值
        if(flag == false) {
            //则新建一链表
            doubleLinkLists.add(new DoubleLinkList(firstName, student));

        }
        //人数加一
        sumStudentNum++;
        return true;
    }

    //删除
    public String deleteHash(String name){
        String uid = null;

        //若找到此人
        if(findHash(name) != null){
            String firstName = getHash(name);
            for(DoubleLinkList doubleLinkList: doubleLinkLists){
                //找到此哈希值
                if(firstName.equals(doubleLinkList.getFirstName())) {
                    //引用结点删除函数
                    uid = doubleLinkList.deleteANode(name);

                }
            }
            //人数减一
            sumStudentNum --;
            return uid;
        }
        return null;
    }

    /*public void setHash(String oldName){
        if(findHash(oldName) != null){
            Student student = findHash(oldName);

        }
    }*/

    //输出所有信息--测试用
    public void showAHash(){
        for(DoubleLinkList doubleLinkList: doubleLinkLists) {
            doubleLinkList.showDoubleLinkList();
        }
    }

    //返回人数
    public int getSumStudentNum(){
        return sumStudentNum;
    }

    //返回哈希表
    public ArrayList<DoubleLinkList> getDoubleLinkLists(){
        return doubleLinkLists;
    }


}
