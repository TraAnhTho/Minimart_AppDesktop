package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import KetNoiJDBC.JDBC_KetNoi;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuanLi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm;
	private javax.swing.JPanel panel_2;
	private javax.swing.JPanel panel_2_1;
	private javax.swing.JPanel panel_1_1;
	private javax.swing.JPanel panel_1;
	private JTextField masp;
	private JTextField tensp;
	private JTextField nhasx;
	private JTextField soluongnhap;
	private JTextField giasp;
	
	private JTextField ma1;
	private JTextField ten1;
	private JTextField nha1;
	private JTextField so1;
	private JTextField gia1;
	QuanLi QuanLi;
	private JTextField idcu;
	private JTextField mkcu;
	private JTextField idmoi;
	private JTextField mkmoi;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLi frame = new QuanLi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public QuanLi() throws Exception {
		this.setVisible(true);
		setBackground(new Color(118, 203, 33));
		setTitle("QuanLi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		panel_1.setVisible(true);
//		panel_2.setVisible(false);
//		panel_2_1.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 194, 408);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trang Chủ");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(false);
				panel_2_1.setVisible(false);
				panel_1.setVisible(true);			
				}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(118, 203, 33));
		lblNewLabel.setIcon(new ImageIcon(QuanLi.class.getResource("/Hinh_Anh/icons8-home-64.png")));
		lblNewLabel.setBounds(0, 0, 194, 110);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thêm");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(false);
				panel_2_1.setVisible(false);
				panel_2.setVisible(true);
				panel_1_1.setVisible(false);
				
//				ThemSP();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(QuanLi.class.getResource("/Hinh_Anh/icons8-add-50.png")));
		lblNewLabel_1.setBounds(0, 109, 194, 43);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Xóa");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					DefaultTableModel model_table = (DefaultTableModel) table.getModel();
				     int i_row =table.getSelectedRow();
				     String masp = model_table.getValueAt(i_row, 1)+"";
				     String tensp =   model_table.getValueAt(i_row, 2)+"";
				     String nhasx =   model_table.getValueAt(i_row, 3)+"";
				     int soluongnhap = Integer.valueOf(model_table.getValueAt(i_row, 4)+"");
				     double giasp = Double.valueOf(model_table.getValueAt(i_row, 5)+"");
					
					// Bước 1: Tạo kết nối
					Connection c = JDBC_KetNoi.getConnection();
					// Bước 2: Tạo ra đối tượng statement
					Statement st = c.createStatement();
					// Bước 3: Thực thi một câu lệnh SQL
					String sql = "DELETE FROM SanPham WHERE MaSP='"+ masp +"'";
					int check = st.executeUpdate(sql);

					c.close();
//					Clear();				
					dispose();
					JOptionPane.showMessageDialog(new QuanLi(), "Đã Xóa");
					
					
				} catch (Exception e2) {
					try {
						dispose();
						JOptionPane.showMessageDialog(new QuanLi(), "Chọn Sản Phảm Cần Xóa");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace(); 
					}
			}
			
				
//				JOptionPane.showMessageDialog(new ChinhSuaSP(), "Đã Xóa");;
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(QuanLi.class.getResource("/Hinh_Anh/icons8-delete-50.png")));
		lblNewLabel_2.setBounds(0, 153, 194, 43);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Chỉnh Sửa");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				try {
					DefaultTableModel model_table = (DefaultTableModel) table.getModel();
					int i_row = table.getSelectedRow();
					String masp = model_table.getValueAt(i_row, 1) + "";
					String tensp = model_table.getValueAt(i_row, 2) + "";
					String nhasx = model_table.getValueAt(i_row, 3) + "";
					int soluongnhap = Integer.valueOf(model_table.getValueAt(i_row, 4) + "");
					double giasp = Double.valueOf(model_table.getValueAt(i_row, 5) + "");
					                  
					ma1.setText(masp);
			        ten1.setText(tensp);
			        nha1.setText(nhasx);
			        so1.setText(soluongnhap+"");	
			        gia1.setText(giasp+"");
			        panel_2_1.setVisible(true);
	                panel_1.setVisible(false);
	        		panel_2.setVisible(false);
	        		panel_1_1.setVisible(false);
					
				} catch (Exception e2) {
					try {
						dispose();
						JOptionPane.showMessageDialog(new QuanLi(), "Chọn Sản Phẩm Cần Chỉnh");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(QuanLi.class.getResource("/Hinh_Anh/icons8-edit-property-50.png")));
		lblNewLabel_3.setBounds(0, 198, 194, 43);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Đăng Xuất");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc là muốn đăng xuất?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
    				dispose();
                    new Dang_Nhap();
                }
			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setForeground(new Color(118, 203, 33));
		lblNewLabel_4.setIcon(new ImageIcon(QuanLi.class.getResource("/Hinh_Anh/icons8-logout-64.png")));
		lblNewLabel_4.setBounds(0, 345, 194, 63);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("Đổi Mật Khẩu");
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2_1.setVisible(false);
                panel_1.setVisible(false);
        		panel_2.setVisible(false);
        		panel_1_1.setVisible(true);
			}
		});
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setIcon(new ImageIcon(QuanLi.class.getResource("/Hinh_Anh/icons8-autograph-50.png")));
		lblNewLabel_3_1.setBounds(0, 302, 194, 43);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(QuanLi.class.getResource("/Hinh_Anh/anhnayduoc.png")));
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(0, 0, 194, 408);
		panel.add(lblNewLabel_5);
		
		panel_1 = new JPanel();
		panel_1.setBounds(193, 0, 538, 408);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		 String[]header={"STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Nhà Sản Xuất",
	        		"Số Lượng Nhập","Giá Sản Phẩm"};

	        dtm=new DefaultTableModel(header, 0){
	        	
	       };
//	        getContentPane()
	        panel_1.add(new JScrollPane(table=new JTable(dtm)));
	        table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
	        table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	        table.setBackground(new Color(255, 255, 255));
	        table.setForeground(new Color(118, 203, 33));
//	        table.setEditingColumn(null);
	        table.setRowHeight(30);
	        table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
	        JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(29, 32, 474, 345);
			panel_1.add(scrollPane);
//		chèn dữ liệu vào
	       LoadDBData2JTable();
	       
	       
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(QuanLi.class.getResource("/Hinh_Anh/anhnayduoc - Copy.png")));
		lblNewLabel_6.setBounds(0, 0, 538, 408);
		panel_1.add(lblNewLabel_6);
		
		panel_2 = new JPanel();
		panel_2.setBounds(193, 0, 538, 408);
		contentPane.add(panel_2);
		panel_2.setVisible(false);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_00 = new JLabel("Mã Sản Phẩm:");
		lblNewLabel_00.setForeground(new Color(118, 203, 33));
		lblNewLabel_00.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_00.setBounds(117, 114, 139, 24);
		panel_2.add(lblNewLabel_00);
		
		JLabel lblNewLabel_01 = new JLabel("Tên Sản Phẩm:");
		lblNewLabel_01.setForeground(new Color(118, 203, 33));
		lblNewLabel_01.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_01.setBounds(117, 144, 139, 24);
		panel_2.add(lblNewLabel_01);
		
		JLabel lblNewLabel_02 = new JLabel("Nhà Sản Xuất");
		lblNewLabel_02.setForeground(new Color(118, 203, 33));
		lblNewLabel_02.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_02.setBounds(117, 179, 139, 24);
		panel_2.add(lblNewLabel_02);
		
		JLabel lblNewLabel_03 = new JLabel("Số Lượng SP:");
		lblNewLabel_03.setForeground(new Color(118, 203, 33));
		lblNewLabel_03.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_03.setBounds(117, 214, 139, 24);
		panel_2.add(lblNewLabel_03);
		
		JLabel lblNewLabel_06 = new JLabel("Giá Sản Phẩm:");
		lblNewLabel_06.setForeground(new Color(118, 203, 33));
		lblNewLabel_06.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_06.setBounds(117, 249, 139, 24);
		panel_2.add(lblNewLabel_06);
		
		masp = new JTextField();
		masp.setBounds(227, 114, 139, 24);
		panel_2.add(masp);
		masp.setColumns(10);
		
		tensp = new JTextField();
		tensp.setColumns(10);
		tensp.setBounds(227, 146, 139, 24);
		panel_2.add(tensp);
		
		nhasx = new JTextField();
		nhasx.setColumns(10);
		nhasx.setBounds(227, 181, 139, 24);
		panel_2.add(nhasx);
		
		soluongnhap = new JTextField();
		soluongnhap.setColumns(10);
		soluongnhap.setBounds(227, 214, 139, 24);
		panel_2.add(soluongnhap);
		
		giasp = new JTextField();
		giasp.setColumns(10);
		giasp.setBounds(227, 249, 139, 24);
		panel_2.add(giasp);
		
		JButton themmotSP = new JButton("Lưu");
		themmotSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		themmotSP.setForeground(new Color(255, 255, 255));
		themmotSP.setBackground(new Color(118, 203, 33));
		themmotSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Bước 1: Tạo kết nối
					Connection c = JDBC_KetNoi.getConnection();
					
					// Bước 2: Tạo ra đối tượng statement
					Statement st = c.createStatement();
					
					// Bước 3: Thực thi một câu lệnh SQL
					String sql = "INSERT INTO hethongminimart.`sanpham` (STT,`MaSP`, TenSP, NhaSanXuat, SoLuongNhapKho,`GiaSP`)"
							+ "VALUES ("+null
							+", '"+ masp.getText()
							+"','"+ tensp.getText()
							+"','"+ nhasx.getText()
							+"','"+ soluongnhap.getText()
							+"', '"+ giasp.getText()
							+"')";
					int check = st.executeUpdate(sql);
			
					c.close();
//					Clear();				
					dispose();
					JOptionPane.showMessageDialog(new QuanLi(), "Đã Lưu");
					
					
				} catch (Exception e2) {
					dispose();
					try {
						JOptionPane.showMessageDialog(new QuanLi(), "Lỗi!");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			}
		});
		themmotSP.setBounds(227, 309, 66, 24);
		panel_2.add(themmotSP);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(QuanLi.class.getResource("/Hinh_Anh/anhnayduoc - Copy.png")));
		lblNewLabel_7.setBounds(0, 0, 538, 408);
		panel_2.add(lblNewLabel_7);
		
		panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(193, 0, 538, 408);
		contentPane.add(panel_2_1);
		panel_2_1.setVisible(false);
		
		JLabel lblNewLabel_00_1 = new JLabel("Mã Sản Phẩm:");
		lblNewLabel_00_1.setForeground(new Color(118, 203, 33));
		lblNewLabel_00_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_00_1.setBounds(116, 113, 139, 24);
		panel_2_1.add(lblNewLabel_00_1);
		
		JLabel lblNewLabel_01_1 = new JLabel("Tên Sản Phẩm:");
		lblNewLabel_01_1.setForeground(new Color(118, 203, 33));
		lblNewLabel_01_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_01_1.setBounds(116, 144, 139, 24);
		panel_2_1.add(lblNewLabel_01_1);
		
		JLabel lblNewLabel_02_1 = new JLabel("Nhà Sản Xuất:");
		lblNewLabel_02_1.setForeground(new Color(118, 203, 33));
		lblNewLabel_02_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_02_1.setBounds(116, 179, 139, 24);
		panel_2_1.add(lblNewLabel_02_1);
		
		JLabel lblNewLabel_03_1 = new JLabel("Số Lượng SP:");
		lblNewLabel_03_1.setForeground(new Color(118, 203, 33));
		lblNewLabel_03_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_03_1.setBounds(116, 214, 139, 24);
		panel_2_1.add(lblNewLabel_03_1);
		
		JLabel lblNewLabel_06_1 = new JLabel("Giá Sản Phẩm:");
		lblNewLabel_06_1.setForeground(new Color(118, 203, 33));
		lblNewLabel_06_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_06_1.setBounds(116, 249, 139, 24);
		panel_2_1.add(lblNewLabel_06_1);
		
		ma1 = new JTextField();
		ma1.setBackground(new Color(192, 192, 192));
		ma1.setColumns(10);
		ma1.setBounds(228, 113, 139, 24);
		panel_2_1.add(ma1);
		
		ten1 = new JTextField();
		ten1.setColumns(10);
		ten1.setBounds(228, 146, 139, 24);
		panel_2_1.add(ten1);
		
		nha1 = new JTextField();
		nha1.setColumns(10);
		nha1.setBounds(228, 181, 139, 24);
		panel_2_1.add(nha1);
		
		so1 = new JTextField();
		so1.setColumns(10);
		so1.setBounds(228, 214, 139, 24);
		panel_2_1.add(so1);
		
		gia1 = new JTextField();
		gia1.setColumns(10);
		gia1.setBounds(228, 249, 139, 24);
		panel_2_1.add(gia1);
		
		JButton capnhatSP = new JButton("Lưu");
		capnhatSP.setBackground(new Color(118, 203, 33));
		capnhatSP.setForeground(new Color(255, 255, 255));
		capnhatSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Bước 1: Tạo kết nối
					Connection c = JDBC_KetNoi.getConnection();
					
					// Bước 2: Tạo ra đối tượng statement
					Statement st = c.createStatement();
					
					// Bước 3: Thực thi một câu lệnh SQL
					String sql = "UPDATE sanpham "
							+ "SET TenSP='"+ ten1.getText()
							+"', NhaSanXuat = '"+ nha1.getText()
							+"', SoLuongNhapKho = "+ so1.getText()
							+", GiaSP = "+ gia1.getText()
							+" WHERE MaSP ='"+ ma1.getText()+"'";
					
					int check = st.executeUpdate(sql);

				    dispose();
					JOptionPane.showMessageDialog(new QuanLi(), "Đã Cập Nhật");
					c.close();			

					
				} catch (Exception e2) {
					dispose();
					try {
						JOptionPane.showMessageDialog(new QuanLi(), "Không Tìm Thấy Sản Phẩm!");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			
			}
		});
		capnhatSP.setBounds(228, 304, 72, 24);
		panel_2_1.add(capnhatSP);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setIcon(new ImageIcon(QuanLi.class.getResource("/Hinh_Anh/anhnayduoc - Copy.png")));
		lblNewLabel_7_1.setBounds(0, 0, 538, 408);
		panel_2_1.add(lblNewLabel_7_1);
		
		panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(193, 0, 538, 408);
		contentPane.add(panel_1_1);
		panel_1_1.setVisible(false);
		
		JLabel lblNewLabel_8 = new JLabel("ID Cũ:");
		lblNewLabel_8.setForeground(new Color(118, 203, 33));
		lblNewLabel_8.setBackground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(140, 128, 111, 25);
		panel_1_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("Mật Khẩu Cũ:");
		lblNewLabel_8_1.setForeground(new Color(118, 203, 33));
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8_1.setBackground(Color.WHITE);
		lblNewLabel_8_1.setBounds(140, 164, 111, 25);
		panel_1_1.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_2 = new JLabel("ID Mới:");
		lblNewLabel_8_2.setForeground(new Color(118, 203, 33));
		lblNewLabel_8_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8_2.setBackground(Color.WHITE);
		lblNewLabel_8_2.setBounds(140, 200, 111, 25);
		panel_1_1.add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_8_3 = new JLabel("Mật Khẩu Mới:");
		lblNewLabel_8_3.setForeground(new Color(118, 203, 33));
		lblNewLabel_8_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8_3.setBackground(Color.WHITE);
		lblNewLabel_8_3.setBounds(140, 236, 111, 25);
		panel_1_1.add(lblNewLabel_8_3);
		
		idcu = new JTextField();
		idcu.setBounds(261, 132, 111, 20);
		panel_1_1.add(idcu);
		idcu.setColumns(10);
		
		mkcu = new JTextField();
		mkcu.setColumns(10);
		mkcu.setBounds(261, 168, 111, 20);
		panel_1_1.add(mkcu);
		
		idmoi = new JTextField();
		idmoi.setColumns(10);
		idmoi.setBounds(261, 204, 111, 20);
		panel_1_1.add(idmoi);
		
		mkmoi = new JTextField();
		mkmoi.setColumns(10);
		mkmoi.setBounds(261, 240, 111, 20);
		panel_1_1.add(mkmoi);
		
		JButton btnNewButton_2 = new JButton("Bán Hàng");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc là muốn đổi mật khẩu?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
    				
				try {
					// Bước 1: Tạo kết nối
					Connection c = JDBC_KetNoi.getConnection();
					
					// Bước 2: Tạo ra đối tượng statement
					Statement st = c.createStatement();
					
					// Bước 3: Thực thi một câu lệnh SQL
					String sql = "UPDATE quanli "
							+ "SET MK='"+ mkmoi.getText()
							+"', ID = '"+ idmoi.getText()
							+" WHERE MK ='"+ mkcu.getText()+"'"
							+"AND ID ='"+ idcu.getText()+"'"
							+ "AND PhanLoai='BanHang'";
					
					int check = st.executeUpdate(sql);

				    dispose();
					JOptionPane.showMessageDialog(new QuanLi(), "Đã Cập Nhật");
					c.close();			

					
				} catch (Exception e2) {
					dispose();
					try {
						JOptionPane.showMessageDialog(new QuanLi(), "Lỗi!");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
					}
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(118, 203, 33));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(393, 166, 100, 23);
		panel_1_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Quản Lí");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc là muốn đổi mật khẩu?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
    				
				try {
					// Bước 1: Tạo kết nối
					Connection c = JDBC_KetNoi.getConnection();
					
					// Bước 2: Tạo ra đối tượng statement
					Statement st = c.createStatement();
					
					// Bước 3: Thực thi một câu lệnh SQL
					String sql = "UPDATE quanli "
							+ "SET MK='"+ mkmoi.getText()
							+"', ID = '"+ idmoi.getText()
							+" WHERE MK ='"+ mkcu.getText()+"'"
							+"AND ID ='"+ idcu.getText()+"'"
							+ "AND PhanLoai='QuanLi'";
					
					int check = st.executeUpdate(sql);

				    dispose();
					JOptionPane.showMessageDialog(new QuanLi(), "Đã Cập Nhật");
					c.close();			

					
				} catch (Exception e2) {
					dispose();
					try {
						JOptionPane.showMessageDialog(new QuanLi(), "Lỗi!");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
					}
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBackground(new Color(118, 203, 33));
		btnNewButton_3.setBounds(393, 130, 100, 23);
		panel_1_1.add(btnNewButton_3);
		
		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setIcon(new ImageIcon(QuanLi.class.getResource("/Hinh_Anh/anhnayduoc - Copy.png")));
		lblNewLabel_6_1.setBounds(0, 0, 538, 408);
		panel_1_1.add(lblNewLabel_6_1);
		
		
	}
	
	
	public void LoadDBData2JTable() throws Exception{
        Connection conn=getConnection();
        String sql="select *from sanpham";
        ResultSet rs=conn.createStatement().executeQuery(sql);
    	int q1=1;
        while(rs.next()){
//            int name = rs.getInt(1);
            String q2 = rs.getString(2);
            String q3 = rs.getString(3);
            String q4 = rs.getString(4);
            int q5 = rs.getInt(5);
           double q6 = rs.getDouble(6);

            Object []row={q1++,q2,q3,q4,q5,q6};
            dtm.addRow(row);
        }
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
			}
