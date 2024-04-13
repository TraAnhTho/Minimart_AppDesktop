package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import KetNoiJDBC.JDBC_KetNoi;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Dang_Nhap extends JFrame {

//	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id_dn;
	private JTextField pass_dn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dang_Nhap frame = new Dang_Nhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dang_Nhap() {
		this.setVisible(true);
		setBackground(new Color(118, 203, 33));
		setTitle("DangNhap");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(118, 203, 33));
		lblNewLabel_1.setBounds(398, 108, 245, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tài Khoản: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setForeground(new Color(118, 203, 33));
		lblNewLabel_2.setBounds(378, 174, 110, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mật Khẩu: ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setForeground(new Color(118, 203, 33));
		lblNewLabel_2_1.setBounds(378, 221, 110, 23);
		contentPane.add(lblNewLabel_2_1);
		
		id_dn = new JTextField();
		id_dn.setForeground(new Color(118, 203, 33));
		id_dn.setBounds(498, 176, 172, 23);
		contentPane.add(id_dn);
		id_dn.setColumns(10);
		
		pass_dn = new JPasswordField();
		pass_dn.setForeground(new Color(118, 203, 33));
		pass_dn.setColumns(10);
		pass_dn.setBounds(498, 223, 172, 23);
		contentPane.add(pass_dn);
		
		
		
		JButton btnNewButton = new JButton("Quản Lí");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id_dn.getText().equals( QuanLi_1())) {
					if(pass_dn.getText().equals( QuanLi_2()) ) {
			    try {
					new QuanLi();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
					}else { dispose(); JOptionPane.showMessageDialog(new Dang_Nhap(),"Sai Mật Khẩu");}
				}else { dispose(); JOptionPane.showMessageDialog(new Dang_Nhap(),"Lỗi");}
			    dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(118, 203, 33));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(593, 270, 77, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBnHng = new JButton("Bán Hàng");
		btnBnHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id_dn.getText().equals( BanHang_1())) {
					if(pass_dn.getText().equals( BanHang_2()) ) {
			    try {
					new BanHang();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
					}else { dispose(); JOptionPane.showMessageDialog(new Dang_Nhap(),"Sai Mật Khẩu");}
				}else { dispose(); JOptionPane.showMessageDialog(new Dang_Nhap(),"Lỗi");}
			    dispose();
			}
		});
		btnBnHng.setForeground(Color.WHITE);
		btnBnHng.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBnHng.setBackground(new Color(118, 203, 33));
		btnBnHng.setBounds(498, 270, 96, 23);
		contentPane.add(btnBnHng);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Dang_Nhap.class.getResource("/Hinh_Anh/nendep.png")));
		lblNewLabel.setBounds(0, 0, 731, 408);
		contentPane.add(lblNewLabel);
	}
	public void LoadDBDataJTable() throws Exception{
	    
	    Connection conn=getConnection();
	    String sql="select *from quanli";
	    ResultSet rs=conn.createStatement().executeQuery(sql);
	    conn.close();
	}
	 private Connection getConnection()throws Exception{
	    	String url = "jdbc:mySQL://localhost:3306/hethongminimart";
			String username = "root";
			String password = "081105";
			// Tạo kết nối
			Connection con = DriverManager.getConnection(url, username, password);
	       return con;
	 }

	 public String QuanLi_1() {
			String ten="";
			try {
				String url = "jdbc:mySQL://localhost:3306/hethongminimart";
				String username = "root";
				String password = "081105";
				// Tạo kết nối
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement ps = con.prepareStatement("select ID from quanli where PhanLoai = ?;");
				ps.setString(1,"QuanLi");
				ResultSet Rs = ps.executeQuery();
				if(Rs.next()) {
					ten = Rs.getString("ID");				
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return ten;
		}
	 public String QuanLi_2() {
			String ten="";
			try {
				String url = "jdbc:mySQL://localhost:3306/hethongminimart";
				String username = "root";
				String password = "081105";
				// Tạo kết nối
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement ps = con.prepareStatement("select MK from quanli where PhanLoai = ?;");
				ps.setString(1,"QuanLi");
				ResultSet Rs = ps.executeQuery();
				if(Rs.next()) {
					ten = Rs.getString("MK");				
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return ten;
		}
	 public String BanHang_1() {
			String ten="";
			try {
				String url = "jdbc:mySQL://localhost:3306/hethongminimart";
				String username = "root";
				String password = "081105";
				// Tạo kết nối
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement ps = con.prepareStatement("select ID from quanli where PhanLoai = ?;");
				ps.setString(1,"BanHang");
				ResultSet Rs = ps.executeQuery();
				if(Rs.next()) {
					ten = Rs.getString("ID");				
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return ten;
		}
	 public String BanHang_2() {
			String ten="";
			try {
				String url = "jdbc:mySQL://localhost:3306/hethongminimart";
				String username = "root";
				String password = "081105";
				// Tạo kết nối
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement ps = con.prepareStatement("select MK from quanli where PhanLoai = ?;");
				ps.setString(1,"BanHang");
				ResultSet Rs = ps.executeQuery();
				if(Rs.next()) {
					ten = Rs.getString("MK");				
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return ten;
		}
	 
}