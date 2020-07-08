//package a.com;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.StringTokenizer;
//
//import a.dao.DBBean;
//
//
//public class BinTreeApp {
//	public static void main(String[]args) throws IOException,SQLException
//  {
//		int num;
//		String name;
//		String classnum;
//		int cscore,mscore,escore,avgscore,sscore;
//		boolean i=true;
//		DBBean db=new DBBean();
//		ResultSet rs=null;
//		String sql="select * from stuinfo";
//		rs=db.executeQuery(sql);
//		BinTreeApp bina=new BinTreeApp();
//		BinTree   bintr=new BinTree();
//
//		while(i)
//		{
//
//
//			System.out.println("                                学       生      成       绩      管      理     系     统\n");
//			System.out.println(" 欢迎使用本系统！\n");
//			System.out.println(" 请选择以下所需要进行管理项的编号【备注：有(->>)表示后有选项】\n");
//			System.out.print(
//					"1.增加学生信息\n"+
//            	    "2.修改学生信息\n"+
//            		"3.删除学生信息\n"+
//            		"4.查询学生信息管理 ->>\n"+
//            		"5.对学生信息排序管理 ->>\n"+
//            	    "6.显示全部学生信息\n"+
//            		"7.查询成绩项的单科最高成绩\n"+
//            		"8.查询成绩项的单科最低成绩\n"+
//            		"9.查询成绩比例情况\n"+
//            		"\n"+
//            		"请输入数字:");
//			int choice=getInt();
//			switch(choice)
//			{
//			case 1:
//            	System.out.print("请依次输入 :学号     姓名     班级  语文成绩    数学成绩     英语成绩\n每项数据请用空格隔开:");
//            	try{
//        			BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
//        			String inputLine = in.readLine();
//        			StringTokenizer str = new StringTokenizer(inputLine," ");//接收的数据用空格隔开,这个类用来提取每个字符串
//        			num = Integer.valueOf(str.nextToken());//学号
//        		    name= (String)str.nextToken(); //姓名
//        			classnum = (String)str.nextToken(); //班级
//        			cscore = Integer.valueOf(str.nextToken());//语文成绩
//        			mscore = Integer.valueOf(str.nextToken());//数学成绩
//        			escore = Integer.valueOf(str.nextToken());//英语成绩
//        			sscore=cscore+mscore+escore;
//        			avgscore=sscore/3;
//        			bina.insert(num, name,classnum,cscore,mscore,escore,avgscore,sscore);
//        		}
//        		catch (IOException e){}
//                break;
//
//            case 2:
//            	System.out.print("请输入要修改的学生的学号：");
//            	num=getInt();
//            	bina.findById(num);
//            	System.out.println("请依次输入要修改的学生的姓名、班级、语文成绩、数学成绩、英语成绩，中间以空格隔开：");
//            	BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
//    			String inputLine = in.readLine();
//    			StringTokenizer str = new StringTokenizer(inputLine," ");//接收的数据用空格隔开,这个类用来提取每个字符串
//    			name = (String)str.nextToken(); //姓名
//    			classnum = (String)str.nextToken(); //班级
//    			cscore = Integer.valueOf(str.nextToken());//语文成绩
//    			mscore = Integer.valueOf(str.nextToken());//数学成绩
//    			escore = Integer.valueOf(str.nextToken());//英语成绩
//    			sscore=cscore+mscore+escore;
//    			avgscore=sscore/3;
//    			bina.update(num, name,classnum,cscore,mscore,escore,avgscore,sscore);
//				break;
//            case 3:
//            	System.out.print("请输入要删除的学生的学号：");
//            	try {
//					num=getInt();
//					bina.delete(num);
//				} catch (IOException e5) {
//					// TODO Auto-generated catch block
//					e5.printStackTrace();
//				}
//
//            	break;
//            case 4:
//            	System.out.print("查询学生信息：a.按学生学号b.按学生姓名c.按学生班级d.按学生语文成绩e.按学生数学成绩f.按学生英语成绩\n");
//
//            	char inputchar=getChar();
//            	switch(inputchar){
//            	    case 'a':
//            	    System.out.print("请输入需要查询的学生学号: ");
//            		num=getInt();
//                	bina.findById(num );
//                	break;
//            	    case 'b':
//            	    System.out.print("请输入需要查询的学生姓名：");
//                    name=getString();
//                    bina.findByName(name);
//                    break;
//            		case 'c':
//            		System.out.print("请输入需要查询的学生班级：");
//            		classnum=getString();  //按字符串返回
//                    bina.findByClass(classnum);
//                    break;
//            		case 'd':
//            		System.out.print("请输入需要查询的学生语文成绩：");
//            		cscore=getInt();
//                    bina.findByC_grade(cscore);
//                    break;
//            		case 'e':
//            		System.out.print("请输入需要查询的学生数学成绩：");
//            		mscore=getInt();
//                    bina.findByM_grade(mscore);
//                    break;
//            		case 'f':
//            		System.out.print("请输入需要查询的学生英语成绩：");
//            		escore=getInt();
//                    bina.findByE_grade(escore);
//                    break;
//            		}
//            	break;
//            case 5:
//            	System.out.print("排序学生信息：a.按学号升序排列b.按语文成绩升序排列c.按数学成绩升序排列d.按英语成绩升序排列e.按平均成绩升序排列f.按总成绩升序排列\n");
//            	char intputchar=getChar();
//            	switch(intputchar){
//            	case 'a':
//            		try {
//    					while(rs.next())
//    					{
//
//    						num=rs.getInt(1); //获取num列
//    						name=rs.getString(2); //获取name列
//    						classnum=rs.getString(3); //获取classnum列
//    						cscore=rs.getInt(4);//获取 cscore列
//    						mscore=rs.getInt(5);//获取mscore列
//    						escore=rs.getInt(6);//获取escore列
//    						avgscore=rs.getInt(7);//获取avgscore列
//    						sscore=rs.getInt(8);//获取sscore列
//
//    						bintr.insertByNum(num, name,classnum,cscore,mscore,escore,avgscore,sscore);
//    					}
//    						bintr.traverse();
//    				} catch (SQLException e4) {
//    					// TODO Auto-generated catch block
//    					e4.printStackTrace();
//    				}
//
//            	break;
//            	case 'b':
//            		try {
//    					while(rs.next())
//            			{
//
//             				num=rs.getInt(1); //获取num列
//            				name=rs.getString(2); //获取name列
//            				classnum=rs.getString(3); //获取classnum列
//            				cscore=rs.getInt(4);//获取 cscore列
//            				mscore=rs.getInt(5);//获取mscore列
//            				escore=rs.getInt(6);//获取escore列
//            				avgscore=rs.getInt(7);//获取avgscore列
//            				sscore=rs.getInt(8);//获取sscore列
//
//            				bintr.insertByCscore(num, name,classnum,cscore,mscore,escore,avgscore,sscore);
//            			}
//    						bintr.traverse();
//    				} catch (SQLException e2) {
//    					// TODO Auto-generated catch block
//    					e2.printStackTrace();
//    				}
//    				break;
//            	case 'c':
//            		try {
//    					while(rs.next())
//    					{
//
//    						num=rs.getInt(1); //获取num列
//    						name=rs.getString(2); //获取name列
//    						classnum=rs.getString(3); //获取classnum列
//    						cscore=rs.getInt(4);//获取 cscore列
//    						mscore=rs.getInt(5);//获取mscore列
//    						escore=rs.getInt(6);//获取escore列
//    						avgscore=rs.getInt(7);//获取avgscore列
//    						sscore=rs.getInt(8);//获取sscore列
//
//    						bintr.insertByMscore(num, name,classnum,cscore,mscore,escore,avgscore,sscore);
//    					}
//    						bintr.traverse();
//    				} catch (SQLException e1) {
//    					// TODO Auto-generated catch block
//    					e1.printStackTrace();
//    				}
//
//                break;
//            	case 'd':
//            		try {
//    					while(rs.next())
//    					{
//
//
//    							num=rs.getInt(1); //获取num列
//    							name=rs.getString(2); //获取name列
//    							classnum=rs.getString(3);
//    							cscore=rs.getInt(4);//获取 cscore列
//    							mscore=rs.getInt(5);//获取mscore列
//    							escore=rs.getInt(6);//获取escore列
//    							avgscore=rs.getInt(7);//获取avgscore列
//    							sscore=rs.getInt(8);//获取sscore列
//
//    							bintr.insertByEscore(num, name,classnum,cscore,mscore,escore,avgscore,sscore);
//    					}
//    						//	bintr.traverse();
//    					}
//        			catch (SQLException e) {
//    					// TODO Auto-generated catch block
//    					e.printStackTrace();
//    				} //获取classnum列
//
//        			break;
//            	case 'e':
//            		try {
//    					while(rs.next())
//    					{
//
//                            num=rs.getInt(1); //获取num列
//    						name=rs.getString(2); //获取name列
//    						classnum=rs.getString(3); //获取classnum列
//    						cscore=rs.getInt(4);//获取 cscore列
//    						mscore=rs.getInt(5);//获取mscore列
//    						escore=rs.getInt(6);//获取escore列
//    						avgscore=rs.getInt(7);//获取avgscore列
//    						sscore=rs.getInt(8);//获取sscore列
//
//    						bintr.insertByAvgscore(num, name,classnum,cscore,mscore,escore,avgscore,sscore);
//    					}
//    						bintr.traverse();
//    				} catch (SQLException e) {
//    					// TODO Auto-generated catch block
//    					e.printStackTrace();
//    				}
//
//                break;
//            	case 'f':
//            		try {
//    					while(rs.next())
//    					{
//
//    						num=rs.getInt(1); //获取num列
//    						name=rs.getString(2); //获取name列
//    						classnum=rs.getString(3); //获取classnum列
//    						cscore=rs.getInt(4);//获取 cscore列
//    						mscore=rs.getInt(5);//获取mscore列
//    						escore=rs.getInt(6);//获取escore列
//    						avgscore=rs.getInt(7);//获取avgscore列
//    						sscore=rs.getInt(8);//获取sscore列
//
//    						bintr.insertBySscore(num, name,classnum,cscore,mscore,escore,avgscore,sscore);
//    					}
//    						bintr.traverse();
//    				} catch (SQLException e1) {
//    					// TODO Auto-generated catch block
//    					e1.printStackTrace();
//    				}
//
//                break;
//            	}
//            	break;
//
//          case 6:
//            	BinTreeApp m16=new BinTreeApp();
//            	m16.findAllStudents();
//            	break;
//          case 7:
//            System.out.println("请输入要查询的最高分的项目：chinese,math,english,sum,avg_grade,sum_grade");
//            String course=getString();
//            System.out.println();
//            System.out.println(course+"该项成绩最高的是：");
//            bina.findByMax_grade(course);
//            System.out.println();
//            break;
//          case 8:
//        	  System.out.println("请输入要查询的最低分的项目：chinese,math,english,sum,avg_grade,sum_grade");
//              String course2=getString();
//              System.out.println();
//              System.out.println(course2+"该项成绩最低的是：");
//              bina.findByMin_grade(course2);
//              System.out.println();
//              break;
//          case 9:
//
//          	System.out.print("请输入要查询的班级：");
//          	classnum=getString();
//          	System.out.print("请输入要查询的课程<可输入的课程有：chinese,math,english>：");
//          	String grade=getString();
//          	System.out.println();
//          	bina.findByPercent(classnum,grade);
//          	System.out.println();
//          	break;
//
//           }
//		}
//     }
//	public static String getString() throws IOException
//    {
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(isr);
//        String s = br.readLine();
//        return s;
//    }
//    public static char getChar() throws IOException
//    {
//        String s = getString();
//        return s.charAt(0);
//    }
//    public static int getInt() throws IOException
//    {
//        String s = getString();
//        return Integer.parseInt(s);
//    }
//   public int insert(int num,String name,String classnum,int cscore,int mscore,int escore,int avgscore,int sscore){
//	    	DBBean db=new DBBean();
//	    	int i=0;
//	    	String sql="insert into stuinfo values ("+num+",'"+name+"','"+classnum+"',"+cscore+","+mscore+","+escore+","+avgscore+","+sscore+")";
//	    	i=db.executeUpdate(sql);
//	    	if(i==1)
//				{
//					System.out.println("添加成功！");
//				}
//				else
//				{
//					System.out.println("添加失败！");
//				}
//	    	db.close();
//	    	return i;
//	    }
//	    public int update(int num,String name,String classnum,int cscore,int mscore,int escore,int avgscore,int sscore){
//	    	DBBean db=new DBBean();
//	    	int i=0;
//	    	String sql="update stuinfo set name='"+name+"',class='"+classnum+"',chinese="+cscore+",math="+mscore
//	    	+",english="+escore+",avg_grade="+avgscore+",sum_grade="+sscore+" where id="+num;
//	    	i=db.executeUpdate(sql);
//	    	if(i==1)
//			{
//				System.out.println("修改成功！");
//			}
//			else
//			{
//				System.out.println("修改失败！");
//			}
//		db.close();
//	    	return i;
//	    }
//	    public int delete(int num){
//	    	DBBean db=new DBBean();
//	    	int i=0;
//	    	String sql="delete from stuinfo where id="+num;
//	    	i=db.executeUpdate(sql);
//	    	if(i==1)
//			{
//				System.out.println("删除成功！");
//			}
//			else
//			{
//				System.out.println("删除失败！");
//			}
//		db.close();
//	    	return i;
//	    }
//	    public void findAllStudents()
//		{
//			DBBean db=new DBBean();
//			ResultSet rs=null;
//			//建立sql语句
//			String sql="select * from stuinfo order by id asc";//按照升序排列
//			rs=db.executeQuery(sql);
//			System.out.println("学号               "+"      姓名        "+"       班级          "+"    语文成绩      "+"  数学成绩      "+
//    				"    英语成绩      "+"   平均成绩      "+"   总成绩");
//			try {
//
//				while(rs.next())
//				{
//
//					int num=rs.getInt(1); //获取num列
//    				String name=rs.getString(2); //获取name列
//    				String classnum=rs.getString(3); //获取classnum列
//    				int cscore=rs.getInt(4);//获取 cscore列
//    				int mscore=rs.getInt(5);//获取mscore列
//    				int escore=rs.getInt(6);//获取escore列
//    				int avgscore=rs.getInt(7);//获取avgscore列
//    				int sscore=rs.getInt(8);//获取sscore列
//
//    				System.out.println(num+"      "+name+"      "+classnum+"        "+cscore+"       "+mscore
//							+"       "+escore+"         "+avgscore+"          "+sscore);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			finally
//			{
//				db.close();
//			}
//		}
//	   /* public void test(int checkType)
//	    {
//	    	switch(checkType)
//	    	{
//	    	case 'a':
//	    		System.out.print("查询结果为：");
//	    		findById(num );
//
//	    	}
//	    }*/
//	    public void findById(int id)
//		{
//			DBBean db=new DBBean();
//			ResultSet rs=null;
//			//建立sql语句
//			String sql="select * from stuinfo where id="+id;
//			rs=db.executeQuery(sql);
//			System.out.println("学号               "+"      姓名        "+"       班级          "+"    语文成绩      "+"  数学成绩      "+
//    				"    英语成绩      "+"   平均成绩      "+"   总成绩");
//			try {
//
//				while(rs.next())
//				{
//
//
//					int num=rs.getInt(1); //获取num列
//    				String name=rs.getString(2); //获取name列
//    				String classnum=rs.getString(3); //获取classnum列
//    				int cscore=rs.getInt(4);//获取 cscore列
//    				int mscore=rs.getInt(5);//获取mscore列
//    				int escore=rs.getInt(6);//获取escore列
//    				int avgscore=rs.getInt(7);//获取avgscore列
//    				int sscore=rs.getInt(8);//获取sscore列
//
//    				System.out.println(num+"      "+name+"      "+classnum+"        "+cscore+"       "+mscore
//							+"       "+escore+"         "+avgscore+"          "+sscore);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			finally
//			{
//				db.close();
//			}
//		}
//	    public void findByName(String sname)
//		{
//			DBBean db=new DBBean();
//			ResultSet rs=null;
//			//建立sequel语句
//			String sql="select * from stuinfo where name='"+sname+"'";
//			rs=db.executeQuery(sql);
//			System.out.println("学号               "+"      姓名        "+"       班级          "+"    语文成绩      "+"  数学成绩      "+
//    				"    英语成绩      "+"   平均成绩      "+"   总成绩");
//			try {
//
//				while(rs.next())
//				{
//
//					int num=rs.getInt(1); //获取num列
//    				String name=rs.getString(2); //获取name列
//    				String classnum=rs.getString(3); //获取classnum列
//    				int cscore=rs.getInt(4);//获取 cscore列
//    				int mscore=rs.getInt(5);//获取mscore列
//    				int escore=rs.getInt(6);//获取escore列
//    				int avgscore=rs.getInt(7);//获取avgscore列
//    				int sscore=rs.getInt(8);//获取sscore列
//
//    				System.out.println(num+"      "+name+"      "+classnum+"        "+cscore+"       "+mscore
//							+"       "+escore+"         "+avgscore+"          "+sscore);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			finally
//			{
//				db.close();
//			}
//		}
//	    public void findByClass(String class_id)
//		{
//			DBBean db=new DBBean();
//			ResultSet rs=null;
//			//建立sequel语句
//			String sql="select * from stuinfo where class='"+class_id+"'";
//			rs=db.executeQuery(sql);
//			System.out.println("学号               "+"      姓名        "+"       班级          "+"    语文成绩      "+"  数学成绩      "+
//    				"    英语成绩      "+"   平均成绩      "+"   总成绩");
//			try {
//
//				while(rs.next())
//				{
//
//					int num=rs.getInt(1); //获取num列
//    				String name=rs.getString(2); //获取name列
//    				String classnum=rs.getString(3); //获取classnum列
//    				int cscore=rs.getInt(4);//获取 cscore列
//    				int mscore=rs.getInt(5);//获取mscore列
//    				int escore=rs.getInt(6);//获取escore列
//    				int avgscore=rs.getInt(7);//获取avgscore列
//    				int sscore=rs.getInt(8);//获取sscore列
//
//    				System.out.println(num+"      "+name+"      "+classnum+"        "+cscore+"       "+mscore
//							+"       "+escore+"         "+avgscore+"          "+sscore);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			finally
//			{
//				db.close();
//			}
//		}
//	    public void findByC_grade(int chinese_grade)
//		{
//			DBBean db=new DBBean();
//			ResultSet rs=null;
//			//建立sequel语句
//			String sql="select * from stuinfo where chinese="+chinese_grade;
//			rs=db.executeQuery(sql);
//			System.out.println("学号               "+"      姓名        "+"       班级          "+"    语文成绩      "+"  数学成绩      "+
//    				"    英语成绩      "+"   平均成绩      "+"   总成绩");
//			try {
//
//				while(rs.next())
//				{
//
//					int num=rs.getInt(1); //获取num列
//    				String name=rs.getString(2); //获取name列
//    				String classnum=rs.getString(3); //获取classnum列
//    				int cscore=rs.getInt(4);//获取 cscore列
//    				int mscore=rs.getInt(5);//获取mscore列
//    				int escore=rs.getInt(6);//获取escore列
//    				int avgscore=rs.getInt(7);//获取avgscore列
//    				int sscore=rs.getInt(8);//获取sscore列
//
//    				System.out.println(num+"      "+name+"      "+classnum+"        "+cscore+"       "+mscore
//							+"       "+escore+"         "+avgscore+"          "+sscore);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			finally
//			{
//				db.close();
//			}
//		}
//	    public void findByM_grade(int math_grade)
//	    {
//			DBBean db=new DBBean();
//			ResultSet rs=null;
//			//建立sequel语句
//			String sql="select * from stuinfo where math="+math_grade;
//			rs=db.executeQuery(sql);
//			System.out.println("学号               "+"      姓名        "+"       班级          "+"    语文成绩      "+"  数学成绩      "+
//    				"    英语成绩      "+"   平均成绩      "+"   总成绩");
//			try {
//
//				while(rs.next())
//				{
//
//					int num=rs.getInt(1); //获取num列
//    				String name=rs.getString(2); //获取name列
//    				String classnum=rs.getString(3); //获取classnum列
//    				int cscore=rs.getInt(4);//获取 cscore列
//    				int mscore=rs.getInt(5);//获取mscore列
//    				int escore=rs.getInt(6);//获取escore列
//    				int avgscore=rs.getInt(7);//获取avgscore列
//    				int sscore=rs.getInt(8);//获取sscore列
//
//    				System.out.println(num+"      "+name+"      "+classnum+"        "+cscore+"       "+mscore
//							+"       "+escore+"         "+avgscore+"          "+sscore);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			finally
//			{
//				db.close();
//			}
//		}
//	    public void findByE_grade(int english_grade)
//	    {
//			DBBean db=new DBBean();
//			ResultSet rs=null;
//			//建立sequel语句
//			String sql="select * from stuinfo where english="+english_grade;
//			rs=db.executeQuery(sql);
//			System.out.println("学号               "+"      姓名        "+"       班级          "+"    语文成绩      "+"  数学成绩      "+
//    				"    英语成绩      "+"   平均成绩      "+"   总成绩");
//			try {
//
//				while(rs.next())
//				{
//
//					int num=rs.getInt(1); //获取num列
//    				String name=rs.getString(2); //获取name列
//    				String classnum=rs.getString(3); //获取classnum列
//    				int cscore=rs.getInt(4);//获取 cscore列
//    				int mscore=rs.getInt(5);//获取mscore列
//    				int escore=rs.getInt(6);//获取escore列
//    				int avgscore=rs.getInt(7);//获取avgscore列
//    				int sscore=rs.getInt(8);//获取sscore列
//
//    				System.out.println(num+"      "+name+"      "+classnum+"        "+cscore+"       "+mscore
//							+"       "+escore+"         "+avgscore+"          "+sscore);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			finally
//			{
//				db.close();
//			}
//		}
//	    public void findByMax_grade(String course)
//	    {
//	    	DBBean db=new DBBean();
//	    	ResultSet rs=null;
//	    	String sql="select * from stuinfo where "+course+"=(select max("+course+") from stuinfo)";
//
//	    	rs=db.executeQuery(sql);
//
//	    	System.out.println("学号               "+"      姓名        "+"       班级          "+"    语文成绩      "+"  数学成绩      "+
//    				"    英语成绩      "+"   平均成绩      "+"   总成绩");
//	    		try {
//					while(rs.next())
//					{
//						int num=rs.getInt(1); //获取num列
//						String name=rs.getString(2); //获取name列
//						String classnum=rs.getString(3); //获取classnum列
//						int cscore=rs.getInt(4);//获取 cscore列
//						int mscore=rs.getInt(5);//获取mscore列
//						int escore=rs.getInt(6);//获取escore列
//						int avgscore=rs.getInt(7);//获取avgscore列
//						int sscore=rs.getInt(8);//获取sscore列
//						System.out.println(num+"      "+name+"      "+classnum+"        "+cscore+"       "+mscore
//								+"       "+escore+"         "+avgscore+"          "+sscore);
//					}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				finally
//				{
//					db.close();
//				}
//
//	    }
//	    public void findByMin_grade(String course2)
//	    {
//	    	DBBean db=new DBBean();
//	    	ResultSet rs=null;
//	    	String sql="select * from stuinfo where "+course2+"=(select min("+course2+") from stuinfo)";
//
//	    	rs=db.executeQuery(sql);
//
//	    	System.out.println("学号               "+"      姓名        "+"       班级          "+"    语文成绩      "+"  数学成绩      "+
//    				"    英语成绩      "+"   平均成绩      "+"   总成绩");
//	    		try {
//					while(rs.next())
//					{
//						int num=rs.getInt(1); //获取num列
//						String name=rs.getString(2); //获取name列
//						String classnum=rs.getString(3); //获取classnum列
//						int cscore=rs.getInt(4);//获取 cscore列
//						int mscore=rs.getInt(5);//获取mscore列
//						int escore=rs.getInt(6);//获取escore列
//						int avgscore=rs.getInt(7);//获取avgscore列
//						int sscore=rs.getInt(8);//获取sscore列
//						System.out.println(num+"      "+name+"      "+classnum+"        "+cscore+"       "+mscore
//								+"       "+escore+"         "+avgscore+"          "+sscore);
//					}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				finally
//				{
//					db.close();
//				}
//
//	    }
//	    public void findByPercent(String classnum,String grade) throws IOException,SQLException  //grade 是成绩项的名称
//	    {
//			DBBean db=new DBBean();
//			ResultSet rs1=null;
//			ResultSet rs2=null;
//			ResultSet rs3=null;
//			String sql1="select count(id) from stuinfo where "+grade+" >=90 and class='"+classnum+"'";
//			String sql2="select count(id) from stuinfo where "+grade+" <60 and class='"+classnum+"'";
//			String sql3="select count(id) from stuinfo where class='"+classnum+"'";
//			rs1=db.executeQuery(sql1);
//			rs2=db.executeQuery(sql2);
//			rs3=db.executeQuery(sql3);
//			try {
//              while(rs1.next()&&rs2.next())
//				{
//					float excellent=(float)rs1.getInt(1);
//					float fail=(float)rs2.getInt(1);
//					while(rs3.next()){
//						int sum_person=(int)rs3.getInt(1);
//						float excellent_p=(float)(excellent/sum_person)*100;
//						float fail_p=(float)(fail/sum_person)*100;
//						System.out.println(classnum+"班总人数："+sum_person);
//						System.out.println(grade+"成绩在90分以上的人数："+excellent);
//						System.out.println(grade+"成绩不及格的人数："+fail);
//						System.out.println("该班该课程的优秀率是："+excellent_p+"%");
//						System.out.println("该班该课程的不及格率是："+fail_p+"%");
//					}
//				}
//
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			finally
//			{
//				db.close();
//			}
//		}
//	  }
//
//
//
