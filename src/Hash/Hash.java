package Hash;


import bean.Student;

import java.util.ArrayList;

public class Hash {

    //��¼ѧ������
    private int sumStudentNum = 0;
    //���Ϸ�װ�����γɹ�ϣ��
    private ArrayList<DoubleLinkList> doubleLinkLists = new ArrayList<DoubleLinkList>();

    //�õ�����Ϊ�ؼ��ֵĹ�ϣֵ
    public String getHash(String name){
        //ȡ�����ĵ�һ����Ϊ��ϣֵ
        Object firstName = name.subSequence(0,1);
        return firstName.toString();
    }

    //�ӹ�ϣ�����ҵ�Ҫ�ҵĹ�ϣֵ������
    public Student findHash(String name){
        //�õ���ϣֵ
        String firstName = getHash(name);
        //
        for(DoubleLinkList doubleLinkList: doubleLinkLists){
            //��ϣֵƥ��ɹ�
            if(firstName.equals(doubleLinkList.getFirstName())) {
                //�Ӵ�������Ѱ��name
                if(doubleLinkList.findAStudent(name) != null)
                //�ҵ�����Student
                {
                    return doubleLinkList.findAStudent(name).getObj();
                }
            }
        }
        //����ʧ��
        return null;
    }

    //���
    public boolean addHash(String firstName, Student student){
        //��ֵ�жϹ�ϣ���д治���ڴ˹�ϣֵ
        boolean flag = false;
        for(DoubleLinkList doubleLinkList: doubleLinkLists) {
            //��ϣ�������д˹�ϣֵ
            if (firstName.equals(doubleLinkList.getFirstName())) {
                //ֱ������ڴ�������
                doubleLinkList.addANode(student);
                flag = true;
                break;
            }

        }
        //�����ڴ˹�ϣֵ
        if(flag == false) {
            //���½�һ����
            doubleLinkLists.add(new DoubleLinkList(firstName, student));

        }
        //������һ
        sumStudentNum++;
        return true;
    }

    //ɾ��
    public String deleteHash(String name){
        String uid = null;

        //���ҵ�����
        if(findHash(name) != null){
            String firstName = getHash(name);
            for(DoubleLinkList doubleLinkList: doubleLinkLists){
                //�ҵ��˹�ϣֵ
                if(firstName.equals(doubleLinkList.getFirstName())) {
                    //���ý��ɾ������
                    uid = doubleLinkList.deleteANode(name);

                }
            }
            //������һ
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

    //���������Ϣ--������
    public void showAHash(){
        for(DoubleLinkList doubleLinkList: doubleLinkLists) {
            doubleLinkList.showDoubleLinkList();
        }
    }

    //��������
    public int getSumStudentNum(){
        return sumStudentNum;
    }

    //���ع�ϣ��
    public ArrayList<DoubleLinkList> getDoubleLinkLists(){
        return doubleLinkLists;
    }


}
