

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
	
	
	private JComboBox jtf_user=new JComboBox();
	private	JPasswordField jtf_pass=new JPasswordField(); 
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
		
		
		
		setcerten();//设置主界面的主要布局
		
		adduser();//记住登录的用户名
	
		main_panel=new JPanel(new BorderLayout());/*{
			@Override
			public void paintComponent(Graphics g) {
				Graphics2D g2=(Graphics2D)g; 
				super.paintComponents(g);
				Image image=Toolkit.getDefaultToolkit().getImage("F:\\JavaMedia\\landing2.jpg");
				g2.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
			}
				};*/
				//通过重写这个方法设置这个主见的背景图片，有很多实现方法，这是比较简单的方法吧，可以通过查阅api得到。
		
				
		main_panel.add(top,BorderLayout.NORTH);
		main_panel.add(jb_base,BorderLayout.SOUTH);
		main_panel.add(certen,BorderLayout.CENTER);
		
	
		
			top.setPreferredSize(new Dimension(main_frame.getWidth(),30));
			jb_base.setPreferredSize(new Dimension(main_frame.getWidth(),25));
			//通过设置两个空白面板来调整整个布局的位置
	
		main_frame.setContentPane(main_panel);
		main_frame.setSize(700,400);
		
		Dimension scrp=Toolkit.getDefaultToolkit().getScreenSize();
		main_frame.setLocation((scrp.width-main_frame.getWidth())/2,(scrp.height-main_frame.getHeight())/2);
		/*设置它的位置的常用方法吧，先得到它整个屏幕的宽高，然后用这种方法，不管在什么屏幕中都能显示在中间的
		位置吧*/
		
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
		/*if(e.getSource()==jb_zhuce){
			zhuce();
		}*/
		if(e.getSource()==lookup){
			denglu();
		}
		
	}
	
	
	

	public void quit(){
		int flag=0;
		String mesg="你确定要退出此登录系统？";
		flag=JOptionPane.showConfirmDialog(main_frame,mesg,"提示",JOptionPane.YES_NO_OPTION);	
		if(flag==JOptionPane.YES_OPTION){
			System.exit(0);
		}
			}
	
	
/*	public void itemStateChanged(ItemEvent e){
		if(e.getSource()==snumber_select){
			getpass();
		}
		
		if(e.getSource()==sname_select){
			denglu();
		}
		
	}*/
	
	
	
	public void setcerten(){
		certen.setOpaque(false);  //这个方法很重要，一定要设置false，才能显示出完整的背景图片
		snumber.setBounds(80,15,60,20);
		sname.setBounds(80,55,60,20);
		age_from.setBounds(80, 95, 60, 20);
		age_from_i.setBounds(130, 90, 60, 30);
		age_to.setBounds(200, 95, 60, 20);
		age_to_i.setBounds(220, 90, 60, 30);
		jtf_user.setBounds(130,10,150,30);
		jtf_pass.setBounds(130,50,150,30);
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
		lookup.setBounds(600,0,80,150);
		
		certen.add(snumber);
		//snumber.setForeground(Color.red);
		
		certen.add(jtf_user);
		jtf_user.setEditable(true);
		certen.add(sname);
		//sname.setForeground(Color.red);
		
		certen.add(age_from);
		//age_from.setForeground(Color.red);

		certen.add(snumber_select);
		certen.add(sname_select);
		certen.add(jtf_pass);
		certen.add(lookup);
		certen.add(age_from_i);
		certen.add(age_to_i);
		certen.add(age_to);
		certen.add(sex_i);
		certen.add(sex);
		//certen.add(jb_zhuce);
		}
	//主要的布局程序类
	
	
	/*public void zhuce(){
		String z_user=String.valueOf(jtf_user.getSelectedItem());
		String z_pass=String.valueOf(jtf_pass.getPassword());
		String sql;
		if(z_user.trim().equals("")||z_pass.equals(""))
		{
			JOptionPane.showMessageDialog(main_frame,"账号或密码不能为空！！！","提醒",JOptionPane.INFORMATION_MESSAGE);
		}else
		{
			
			
			Connection conn=null;
			PreparedStatement psta=null;
			ResultSet rs=null;
		
		
		  try { sql="select j_user from denglu where j_user=?";
		  	
				conn=DriverManager.getConnection(url,user,pass);
				psta=conn.prepareStatement(sql);
				//prepareStatement比Statement强大啦很多
				psta.setString(1,z_user);
				rs=psta.executeQuery();
				if(rs.next()){
				JOptionPane.showMessageDialog(main_frame, "该用户已注册，请重新输入用户名！！",
						"提醒！",JOptionPane.INFORMATION_MESSAGE);
			}else{
				 if(z_pass.length()>=6)
				{sql="insert into denglu(j_user,j_pass) values(?,?)";
					psta.setString(1,z_user);
					psta.setString(2,z_pass);
					conn=DriverManager.getConnection(url,user,pass);
					psta=conn.prepareStatement(sql);
					psta.executeUpdate();
					JOptionPane.showMessageDialog(main_frame,"注册成功，请登录！！！");}
				 else{
					 JOptionPane.showMessageDialog(main_frame,"密码须大于六位!!!","提醒!",JOptionPane.INFORMATION_MESSAGE);
				 }
			}
		 } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		  finally{
			  try {
				  if(rs!=null){
					rs.close();
					rs=null;}
				  
				  if(psta!=null){
					  psta.close();
					  psta=null;
				  }
				  
				  if(conn!=null){
					  conn.close();
					  conn=null;
				  }
				  
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				 
				   }
		  }
		  }
		  }*/
	//实现注册功能的类，通过使用insert into语句把数据加入到数据库中，实现注册功能
	
		 
		
			public void adduser(){
					String a_user=String.valueOf(jtf_user.getSelectedItem());
					String a_pass=String.valueOf(jtf_pass.getPassword());
					String sql="select j_user from denglu;";
					
					try {
						Connection conn=DriverManager.getConnection(url,user,pass);
						PreparedStatement sta=conn.prepareStatement(sql);
						ResultSet rs=sta.executeQuery();
						rs.afterLast();
						int i=0;
						String s=null;
						while(rs.previous()&&i<4){
							i++;
							s=rs.getString("j_user");
							jtf_user.addItem(s);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}//通过查找数据库来实现的记住前四个用户名的功能
				
	
	/*		public void getpass(){
				String g_user=String.valueOf(jtf_user.getSelectedItem());
				String g_pass=String.valueOf(jtf_pass.getPassword());
				String sql="select j_user,j_pass from denglu where j_user=?";
				
				Connection conn=null;
				PreparedStatement  psta=null;
				ResultSet	rs=null;
				try {
					 conn=DriverManager.getConnection(url,user,pass);
					 psta=conn.prepareStatement(sql);
					 psta.setString(1,g_user);
					 rs=psta.executeQuery();
					String s=null;
					while(rs.next()){
						s=rs.getString("j_pass");
					}
					jtf_user.addItem(s);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
				try{
					if(rs!=null){
					rs.close();
					rs=null;
					}
					
					
					if(psta!=null){
					psta.close();
					psta=null;}
				
					
					if(conn!=null){
					conn.close();
					conn=null;}
				}catch (SQLException e){
					e.printStackTrace();}
				}
}*/
	
			
	public void denglu(){
		String d_user=String.valueOf(jtf_user.getSelectedItem());	
		String d_pass=String.valueOf(jtf_pass.getPassword());
		String sql="select j_user,j_pass from denglu where j_user=?";
				
		if(d_user.equals("")||d_pass.equals("")){
			JOptionPane.showMessageDialog(main_frame,"登录密码或账户不能为空!!!!","警告,提醒!!!",JOptionPane.INFORMATION_MESSAGE);
		}else{		Connection conn=null;
					PreparedStatement psta=null;
					ResultSet rs=null;
					
					try {
						conn=DriverManager.getConnection(url,user,pass);
						psta=conn.prepareStatement(sql);
						psta.setString(1,d_user);
						rs=psta.executeQuery();
						if(rs.next()){
							if(d_pass.equals(rs.getString(2)))
							{
								JOptionPane.showMessageDialog(main_frame,"登录成功");
								System.exit(0);
							}else{
								JOptionPane.showMessageDialog(main_frame,"密码输入错误!!!","提醒!!警告!!!",JOptionPane.ERROR_MESSAGE);
							}
							}
						else{
								JOptionPane.showMessageDialog(main_frame,"用户名不存在,请重新输入或注册一个账户！！！","提醒!!!",JOptionPane.INFORMATION_MESSAGE);
							}
						
					}
					catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
						 }	}}	}				 		
								 				
	
	
	
	public static void main(String[] args) {
		new MysqlDemo().LandingWindows();
		
	}

}

