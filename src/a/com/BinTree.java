//package a.com;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Stack;
//
//
//public class saBinTree {                 //二叉树类
//	private BinTreeNode root;
//	public BinTree()    //构造方法
//	{
//		root=null;     //定义节点的初始值
//	}
//	//将输入的数据插入二叉树
//
//	//学号
//	public void insertByNum(int num,String name,String classnum,int cscore,int mscore,int escore,int avgscore,int sscore) {
//		   BinTreeNode newNode=new BinTreeNode();
//		   newNode.snum=num;
//		   newNode.sname=name;
//		   newNode.sclassnum=classnum;
//		   newNode.chinesescore=cscore;
//		   newNode.mathscore=mscore;
//		   newNode.englishscore=escore;
//		   newNode.averagescore=avgscore;
//		   newNode.sumscore=sscore;
//		   boolean i=true;
//
//		   if(root==null)
//		   {
//			   root=newNode;
//		   }
//		   else
//		   {
//			   BinTreeNode current=root;
//			   BinTreeNode parent;
//			   while(i)
//			   {
//				   parent=current;
//				   if(num<current.snum){     //判断节点的位置
//					   current=current.leftChild;
//					   if(current==null){
//						   parent.leftChild=newNode;
//						   return;
//					   }
//				   }
//				   else
//				   {current=current.rightChild;
//				   if(current==null)
//				   {
//					   parent.rightChild=newNode;
//					   return;
//				   }
//				   }
//			   }
//		   }
//
//	}
//	//语文成绩
//	public void insertByCscore(int num,String name,String classnum,int cscore,int mscore,int escore,int avgscore,int sscore) {
//		   BinTreeNode newNode=new BinTreeNode();
//		   newNode.snum=num;
//		   newNode.sname=name;
//		   newNode.sclassnum=classnum;
//		   newNode.chinesescore=cscore;
//		   newNode.mathscore=mscore;
//		   newNode.englishscore=escore;
//		   newNode.averagescore=avgscore;
//		   newNode.sumscore=sscore;
//		   boolean i=true;
//
//		   if(root==null)
//		   {
//			   root=newNode;
//		   }
//		   else
//		   {
//			   BinTreeNode current=root;
//			   BinTreeNode parent;
//			   while(i)
//			   {
//				   parent=current;
//				   if(cscore<current.chinesescore){     //判断节点的位置
//					   current=current.leftChild;
//					   if(current==null){
//						   parent.leftChild=newNode;
//						   return;
//					   }
//				   }
//				   else
//				   {current=current.rightChild;
//				   if(current==null)
//				   {
//					   parent.rightChild=newNode;
//					   return;
//				   }
//				   }
//			   }
//		   }
//
//	}
//	//数学成绩
//	public void insertByMscore(int num,String name,String classnum,int cscore,int mscore,int escore,int avgscore,int sscore) {
//		   BinTreeNode newNode=new BinTreeNode();
//		   newNode.snum=num;
//		   newNode.sname=name;
//		   newNode.sclassnum=classnum;
//		   newNode.chinesescore=cscore;
//		   newNode.mathscore=mscore;
//		   newNode.englishscore=escore;
//		   newNode.averagescore=avgscore;
//		   newNode.sumscore=sscore;
//		   boolean i=true;
//
//		   if(root==null)
//		   {
//			   root=newNode;
//		   }
//		   else
//		   {
//			   BinTreeNode current=root;
//			   BinTreeNode parent;
//			   while(i)
//			   {
//				   parent=current;
//				   if(mscore<current.mathscore){
//				   	//判断节点的位置
//					   current=current.leftChild;
//					   if(current==null){
//						   parent.leftChild=newNode;
//						   return;
//					   }
//				   }
//				   else
//				   {current=current.rightChild;
//				   if(current==null)
//				   {
//					   parent.rightChild=newNode;
//					   return;
//				   }
//				   }
//			   }
//		   }
//
//	}
//	//英语成绩
//	public void insertByEscore(int num,String name,String classnum,int cscore,int mscore,int escore,int avgscore,int sscore) {
//		   BinTreeNode newNode=new BinTreeNode();
//		   newNode.snum=num;
//		   newNode.sname=name;
//		   newNode.sclassnum=classnum;
//		   newNode.chinesescore=cscore;
//		   newNode.mathscore=mscore;
//		   newNode.englishscore=escore;
//		   newNode.averagescore=avgscore;
//		   newNode.sumscore=sscore;
//		   boolean i=true;
//
//		   if(root==null)
//		   {
//			   root=newNode;
//		   }
//		   else
//		   {
//			   BinTreeNode current=root;
//			   BinTreeNode parent;
//			   while(i)
//			   {
//				   parent=current;
//				   if(escore<current.englishscore){
//					   current=current.leftChild;
//					   if(current==null){
//						   parent.leftChild=newNode;
//						   return;
//					   }
//				   }
//				   else
//				   {current=current.rightChild;
//				   if(current==null)
//				   {
//					   parent.rightChild=newNode;
//					   return;
//				   }
//				   }
//			   }
//		   }
//
//	}
//	//平均成绩
//	public void insertByAvgscore(int num,String name,String classnum,int cscore,int mscore,int escore,int avgscore,int sscore) {
//		   BinTreeNode newNode=new BinTreeNode();
//		   newNode.snum=num;
//		   newNode.sname=name;
//		   newNode.sclassnum=classnum;
//		   newNode.chinesescore=cscore;
//		   newNode.mathscore=mscore;
//		   newNode.englishscore=escore;
//		   newNode.averagescore=avgscore;
//		   newNode.sumscore=sscore;
//		   boolean i=true;
//
//		   if(root==null)
//		   {
//			   root=newNode;
//		   }
//		   else
//		   {
//			   BinTreeNode current=root;
//			   BinTreeNode parent;
//			   while(i)
//			   {
//				   parent=current;
//				   if(avgscore<current.averagescore){     //判断节点的位置
//					   current=current.leftChild;
//					   if(current==null){
//						   parent.leftChild=newNode;
//						   return;
//					   }
//				   }
//				   else
//				   {current=current.rightChild;
//				   if(current==null)
//				   {
//					   parent.rightChild=newNode;
//					   return;
//				   }
//				   }
//			   }
//		   }
//
//	}
//	//总分
//	public void insertBySscore(int num,String name,String classnum,int cscore,int mscore,int escore,int avgscore,int sscore) {
//		   BinTreeNode newNode=new BinTreeNode();
//		   newNode.snum=num;
//		   newNode.sname=name;
//		   newNode.sclassnum=classnum;
//		   newNode.chinesescore=cscore;
//		   newNode.mathscore=mscore;
//		   newNode.englishscore=escore;
//		   newNode.averagescore=avgscore;
//		   newNode.sumscore=sscore;
//		   boolean i=true;
//
//		   if(root==null)
//		   {
//			   root=newNode;
//		   }
//		   else
//		   {
//			   BinTreeNode current=root;
//			   BinTreeNode parent;
//			   while(i)
//			   {
//				   parent=current;
//				   if(sscore<current.sumscore){     //判断节点的位置
//					   current=current.leftChild;
//					   if(current==null){
//						   parent.leftChild=newNode;
//						   return;
//					   }
//				   }
//				   else
//				   {current=current.rightChild;
//				   if(current==null)
//				   {
//					   parent.rightChild=newNode;
//					   return;
//				   }
//				   }
//			   }
//		   }
//
//	}
//
//	public void displayOrder(BinTreeNode r)   //利用中序遍历进行排序
//    {
//		if(r!= null)
//        {
//           displayOrder(r.leftChild);
//            System.out.print(
//            		r.getSnum()+ "   "+
//            		r.getSname()+ "   "+
//            		r.getSclassnum()+ "      "+
//            		r.getChinesescore() + "        "+
//            		r.getMathscore()+ "        "+
//            		r.getEnglishscore()+ "     "+
//            		r.getAveragescore()+ "        "+
//            		r.getSumscore()+ "        ");
//            System.out.println(" ");
//            displayOrder(r.rightChild);
//        }
//    }
//    public void traverse()
//    {
//        //System.out.println("按成绩从小到大排列: ");
//       System.out.println("学号        "+" 姓名        "+"        班级          "+"语文成绩      "+"数学成绩      "+"英语成绩      "+"平均成绩      "+"总成绩");
//        displayOrder(root);
//        System.out.println("");
//    }
//}
//
//
