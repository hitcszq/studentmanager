

import javax.swing.*;

import java.net.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class MysqlDemo extends JFrame implements ActionListener{
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://127.0.0.1:3306/landing";
	private String user="admin";
	private String pass="123456";
	//数据库的连接信息
	private JFrame main_frame=new JFrame("学生信息管理系统");
	private JLabel snumber=new JLabel("学号");
	private JLabel sname=new JLabel("姓名");
	private JLabel age_from=new JLabel("年龄自");
	private JLabel sex=new JLabel("性别");
	private JTextField age_from_i=new JTextField();
	private JTextField sex_i=new JTextField();
	private JLabel classes=new JLabel("班级");
	private JTextField classes_i=new JTextField();
	private JLabel dept=new JLabel("系别");
	private JTextField dept_i=new JTextField();
	private JLabel addr=new JLabel("地址");
	private JTextField addr_i=new JTextField();
	
	private JLabel age_to =new JLabel("到");
	private JTextField age_to_i=new JTextField();
	//private JButton jb_zhuce=new JButton("注册");
	private JButton lookup=new JButton("查询");
	
	
	private JTextField snumber_i=new JTextField();
	private	JTextField sname_i=new JTextField(); 
	private JPanel certen=new JPanel(null);
	private JPanel main_panel;
	private JLabel top=new JLabel();
	private JLabel jb_base=new JLabel();
	
	private JCheckBox snumber_select=new JCheckBox();
	private JCheckBox sname_select=new JCheckBox();
	private JCheckBox age_select=new JCheckBox();
	private JCheckBox sex_select=new JCheckBox();
	private JCheckBox classes_select=new JCheckBox();
	private JCheckBox dept_select=new JCheckBox();	
	private JCheckBox addr_select=new JCheckBox();	
	//一些定义以及实现这个登录功能的组件
	
	public void LandingWindows(){
				try {
					Class.forName(driver);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		lookup.addActionListener(this);
		//jb_zhuce.addActionListener(this);
		
		
		
		setcerten();
	
		main_panel=new JPanel(new BorderLayout());
		
				
		main_panel.add(top,BorderLayout.NORTH);
		main_panel.add(jb_base,BorderLayout.SOUTH);
		main_panel.add(certen,BorderLayout.CENTER);
		
	
		
			top.setPreferredSize(new Dimension(main_frame.getWidth(),30));
			jb_base.setPreferredSize(new Dimension(main_frame.getWidth(),25));
			//通过设置两个空白面板来调整整个布局的位置
	
		main_frame.setContentPane(main_panel);
		main_frame.setSize(900,500);
		
		Dimension scrp=Toolkit.getDefaultToolkit().getScreenSize();
		main_frame.setLocation((scrp.width-main_frame.getWidth())/2,(scrp.height-main_frame.getHeight())/2);
		/*设置它的位置的常用方法吧，先得到它整个屏幕的宽高，然后用这种方法，不管在什么屏幕中都能显示在中间的
		位置*/
		
		main_frame.addWindowListener(new WindowAdapter(){
			
			//@Override
			public void windowClosing(WindowEvent arg0) {
			quit();
			}
			//退出ui的实现程序
		
			
		});
		main_frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		main_frame.setResizable(false);
		main_frame.setVisible(true);
		
	}

	
	//@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==lookup){
			chaxun();
		}
		
	}
	
	
	

	public void quit(){
		int flag=0;
		String mesg="你确定要退出查询系统？";
		flag=JOptionPane.showConfirmDialog(main_frame,mesg,"提示",JOptionPane.YES_NO_OPTION);	
		if(flag==JOptionPane.YES_OPTION){
			System.exit(0);
		}
			}
	

	
	
	
	public void setcerten(){
		certen.setOpaque(false);  
		snumber.setBounds(80,15,60,20);
		sname.setBounds(80,55,60,20);
		age_from.setBounds(80, 95, 60, 20);
		age_from_i.setBounds(130, 90, 60, 30);
		age_to.setBounds(200, 95, 60, 20);
		age_to_i.setBounds(220, 90, 60, 30);
		snumber_i.setBounds(130,10,150,30);
		sname_i.setBounds(130,50,150,30);
		sex.setBounds(80,135,60,20);
		sex_i.setBounds(130, 130, 90, 30);
		
		classes.setBounds(320,15,60,20);
		classes_i.setBounds(370, 10, 90, 30);
		classes_select.setBounds(300, 10, 20, 20);
		certen.add(classes_select);
		certen.add(classes);
		certen.add(classes_i);
		
		dept.setBounds(320,55,60,20);
		dept_i.setBounds(370, 50, 90, 30);
		dept_select.setBounds(300, 50, 20, 20);
		certen.add(dept_select);
		certen.add(dept);
		certen.add(dept_i);
		
		addr.setBounds(320,95,60,20);
		addr_i.setBounds(370, 90, 90, 30);
		addr_select.setBounds(300, 90, 20, 20);
		certen.add(addr_select);
		certen.add(addr);
		certen.add(addr_i);
		
		snumber_select.setBounds(50, 10, 20, 20);
		//snumber_select.addItemListener(this);
		age_select.setBounds(50, 90, 20, 20);
		certen.add(age_select);
		
		sname_select.setBounds(50,50,20,20);
		//snumber_select.addItemListener(this);
		sex_select.setBounds(50,130,20,20);
		certen.add(sex_select);
		//jb_zhuce.setBounds(230,120,70,30);
		lookup.setBounds(600,0,150,150);
		
		certen.add(snumber);
		//snumber.setForeground(Color.red);
		
		certen.add(snumber_i);
		//sname_i.setEditable(true);
		certen.add(sname);
		//sname.setForeground(Color.red);
		
		certen.add(age_from);
		//age_from.setForeground(Color.red);

		certen.add(snumber_select);
		certen.add(sname_select);
		certen.add(sname_i);
		certen.add(lookup);
		certen.add(age_from_i);
		certen.add(age_to_i);
		certen.add(age_to);
		certen.add(sex_i);
		certen.add(sex);

		}

	
			
	public void chaxun(){
		String snumber=String.valueOf(snumber_i.getText());	
		String sname=String.valueOf(sname_i.getText());
		String age_from=String.valueOf(age_from_i.getText());
		String age_to=String.valueOf(age_to_i.getText());
		String sex=String.valueOf(sex_i.getText());
		String sclass=String.valueOf(classes_i.getText());
		String sdept=String.valueOf(dept_i.getText());
		String addr=String.valueOf(addr_i.getText());
		String sql="select * from students where true";
		int i=0;		
     	Connection conn=null;
		PreparedStatement psta=null;
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(url,user,pass);
			Statement stmt=conn.createStatement();
			if(snumber_select.isSelected())
				sql =sql+" and snumber="+"'"+snumber+"'";
			if(sname_select.isSelected())
				sql =sql+" and sname="+"'"+sname+"'";
			if(age_select.isSelected()){
				sql =sql+" and sage >="+age_from;
				sql =sql+" and sage <="+age_to;
			}
			if(sex_select.isSelected())
					sql =sql+" and ssex="+"'"+sex+"'";
			if(classes_select.isSelected())
				sql =sql+" and sclass="+"'"+sclass+"'";
			if(dept_select.isSelected())
				sql =sql+" and sdepth="+"'"+sdept+"'";
			if(addr_select.isSelected())
				sql =sql+" and saddr="+"'"+addr+"'";
			sql=sql+";";
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
			if(rs.wasNull())
			{
				JOptionPane.showMessageDialog(main_frame,"查询的结果为空","提醒!!!",JOptionPane.INFORMATION_MESSAGE);
			}
			while(rs.next()){
				JLabel addto=new JLabel("姓名:"+rs.getString(1)+" 学号："+rs.getString(2)+" 年龄："+rs.getString(3)+" 性别："+rs.getString(4)+" 班级："+rs.getString(5)+" 系别："+rs.getString(6)+" 住址："+rs.getString(7));
				addto.setBounds(80, 175+i,700, 20);
				certen.add(addto);
				main_panel.add(certen,BorderLayout.CENTER);
				main_frame.setContentPane(main_panel);
				i=i+40;
			}}
		
		catch (SQLException e) {
			
			JLabel addto=new JLabel("查询条件错误，性别只能取male或female,年龄只能取1到50");
			certen.add(addto);
			main_panel.add(certen,BorderLayout.CENTER);
			main_frame.setContentPane(main_panel);
		}
		finally{
			try{
			 if(rs!=null){
				 rs.close();
				 rs=null;
				 }
			 
			 if(psta!=null){
				 psta.close();
				 psta=null;
			 }
			 
			 if(conn!=null){
				 conn.close();
				 conn=null;
			 }
			
			}
			 
			  
			 catch(SQLException e){
				 e.printStackTrace();
			 }	
			}
		}
		 		
								 				
	
	public static void main(String[] args) {
		new MysqlDemo().LandingWindows();
		
	}

}

