package Hash;

import bean.Student;

/**
 * @author 12613
 */
public class

DoubleLinkList {

    private Node first = null;          //第一个结点
    private Node last = null;           //最后一个结点
    private int size;                   //链表长度
    private String firstName;           //哈希关键字

    //构造函数
    public DoubleLinkList(String firstName, Student student){
        /*first = new Node();
        first.previous = first.next;
        first = first.next;*/
        this.firstName = firstName;
        addANode(student);
    }
    //添加
    public void addANode(Student obj){
        //新定义一个结点，obj
        Node aNewNode = new Node(obj);
        //若链表为空
        if(first == null) {
            aNewNode.setPrevious(null);         //设置为空
            aNewNode.setNext(null);             //设置后继为空
            aNewNode.setObj(obj);               //设置数据域

            //第一个 = 最后一个
            first = aNewNode;
            last = aNewNode;
        }
        //链表不为空
        else{
            aNewNode.setObj(obj);           //数据域
            aNewNode.setNext(null);         //后继为空，即添加在表尾
            aNewNode.setPrevious(last);     //设置前驱

            //连在表上
            last.setNext(aNewNode);
            last = aNewNode;

        }
        //长度加一
        size++;
    }

    //删除结点
    public String deleteANode(String name){
        String uid = null;
        //从链表头开始遍历
        for(Node n = first; n != null; n = n.next){
            //找到匹配项
            if(name.equals(n.obj.getSname())) {
                //存储要删除学生的学号
                uid = n.obj.getSid();
                //如果要删除的人是表头
                if(n == first) {
                    first = n.next;
                }
                    //如果要删除的人是表尾
                else if(n.next == null) {
                    n.previous.next = null;
                }
                    //如果要删除的人在中间
                else if(n != first && n.next != null){
                    n.previous.next = n.next;
                    n.next.previous = n.previous;
                }

                //释放n结点
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

    //找到要找的结点返回Student
    public Node findAStudent(String name){
        for(Node n = first; n != null; n = n.next){
            if(name.equals(n.obj.getSname())) {
                return n;
            }
        }
        return null;
    }
    //返回链表长度
    public int getSize(){
        return size;
    }
    //返回哈希值
    public String getFirstName(){
        return firstName;
    }

    //显示结点信息--测试用
    public void showDoubleLinkList(){


        for(Node n = first; n != null; n = n.next) {
            System.out.println(n.getObj().getSname() + n.getObj().getSid() +"    "+"    "+
                    String.valueOf(n.getObj().getEnglish()) +"    "+ String.valueOf(n.getObj().getHistory()) +"    "+
                    String.valueOf(n.getObj().getMath()) +"    "+ String.valueOf(n.getObj().getPe()) +"    "+
                    String.valueOf(n.getObj().getData_structure() ));
        }
    }

    //Node内部类
    public static class Node{
        private Node previous = null;           //前驱
        private Node next = null;               //后继
        private Student obj = new Student();    //数据域
        //有参构造函数
        public Node(Student obj){
            this.obj = obj;
        }
        //无参构造函数
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

    //返回第一个结点
    public Node getFirst(){
        return first;
    }



}