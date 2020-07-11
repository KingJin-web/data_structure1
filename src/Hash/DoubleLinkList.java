package Hash;

import bean.Student;

/**
 * @author 12613
 */
public class

DoubleLinkList {

    private Node first = null;          //��һ�����
    private Node last = null;           //���һ�����
    private int size;                   //������
    private final String firstName;           //��ϣ�ؼ���

    //���캯��
    public DoubleLinkList(String firstName, Student student){
        /*first = new Node();
        first.previous = first.next;
        first = first.next;*/
        this.firstName = firstName;
        addANode(student);
    }
    //���
    public void addANode(Student obj){
        //�¶���һ����㣬obj
        Node aNewNode = new Node(obj);
        //������Ϊ��
        if(first == null) {
            aNewNode.setPrevious(null);         //����Ϊ��
            aNewNode.setNext(null);             //���ú��Ϊ��
            aNewNode.setObj(obj);               //����������

            //��һ�� = ���һ��
            first = aNewNode;
            last = aNewNode;
        }
        //����Ϊ��
        else{
            aNewNode.setObj(obj);           //������
            aNewNode.setNext(null);         //���Ϊ�գ�������ڱ�β
            aNewNode.setPrevious(last);     //����ǰ��

            //���ڱ���
            last.setNext(aNewNode);
            last = aNewNode;

        }
        //���ȼ�һ
        size++;
    }

    //ɾ�����
    public String deleteANode(String name){
        String uid = null;
        //������ͷ��ʼ����
        for(Node n = first; n != null; n = n.next){
            //�ҵ�ƥ����
            if(name.equals(n.obj.getSname())) {
                //�洢Ҫɾ��ѧ����ѧ��
                uid = n.obj.getSid();
                //���Ҫɾ�������Ǳ�ͷ
                if(n == first) {
                    first = n.next;
                }
                    //���Ҫɾ�������Ǳ�β
                else if(n.next == null) {
                    n.previous.next = null;
                }
                    //���Ҫɾ���������м�
                else if(n != first && n.next != null){
                    n.previous.next = n.next;
                    n.next.previous = n.previous;
                }

                //�ͷ�n���
                n = null;
                return uid;
            }


        }
        return null;
    }
    /*public String deleteANode(String name){
        String uid = null;
        Node node = findAStudent(name);
        if(node != null){
            uid = findAStudent(name).obj.getSid();
            node.previous.next = node.next;
            node.next.previous = node.previous;
            node = null;
        }
        size--;
        return uid;
    }*/

    //�ҵ�Ҫ�ҵĽ�㷵��Student
    public Node findAStudent(String name){
        for(Node n = first; n != null; n = n.next){
            if(name.equals(n.obj.getSname())) {
                return n;
            }
        }
        return null;
    }
    //����������
    public int getSize(){
        return size;
    }
    //���ع�ϣֵ
    public String getFirstName(){
        return firstName;
    }

    //��ʾ�����Ϣ--������
    public void showDoubleLinkList(){


        for(Node n = first; n != null; n = n.next) {
            System.out.println(n.getObj().getSname() + n.getObj().getSid() +"    "+"    "+
                    n.getObj().getEnglish() +"    "+ n.getObj().getHistory() +"    "+
                    n.getObj().getMath() +"    "+ n.getObj().getPe() +"    "+
                    n.getObj().getData_structure());
        }
    }

    //Node�ڲ���
    public static class Node{
        private Node previous = null;           //ǰ��
        private Node next = null;               //���
        private Student obj = new Student();    //������
        //�вι��캯��
        public Node(Student obj){
            this.obj = obj;
        }
        //�޲ι��캯��
        public Node(){this.obj = obj;}

        //
        public void setObj(Student obj) {
            this.obj = obj;
        }

        public Student getObj() {
            return obj;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getPrevious() {
            return previous;
        }
    }

    //���ص�һ�����
    public Node getFirst(){
        return first;
    }



}