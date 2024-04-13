package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import KetNoiJDBC.JDBC_KetNoi;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BanHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField masp;
	private JTextField tensp;
	private JTextField ngaynhap;
	private JTextField soluongnhap;
	private JTextField sodaban;
	private JTextField soconlai;
	private JTextField giasp;
	private JTextField timkiem;
	private JTextField soluong;
	private DefaultTableModel dtm;
	private JTable table;
	private JTable table2;
	private DefaultTableModel dtm2;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanHang frame = new BanHang();
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
	public BanHang() throws Exception {
		this.setVisible(true);
		setBackground(new Color(118, 203, 33));
		setTitle("BanHang");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm Kiếm:");
		lblNewLabel.setForeground(new Color(118, 203, 33));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 100, 22);
		panel.add(lblNewLabel);
		
		timkiem = new JTextField();
		timkiem.setBounds(114, 11, 153, 22);
		panel.add(timkiem);
		timkiem.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(118, 203, 33));
		btnNewButton.setIcon(new ImageIcon(BanHang.class.getResource("/Hinh_Anh/icons8-search-26.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoadDBData2JTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(288, 11, 46, 33);
		panel.add(btnNewButton);
		
		
		String[]header={"STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Sản Phẩm"};

        dtm=new DefaultTableModel(header, 0){
        	
       };
//        getContentPane()
        panel.add(new JScrollPane(table = new JTable(dtm)));
        table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
        table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        table.setBackground(new Color(255, 255, 255));
        table.setForeground(new Color(118, 203, 33));
//        table.setEditingColumn(null);
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
        JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 55, 340, 283);
		panel.add(scrollPane);
//		panel_1.add(table);
//	 chèn dữ liệu vào
//       LoadDBData2JTable();
		
		JLabel lblNewLabel_1 = new JLabel("Số Lượng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(118, 203, 33));
		lblNewLabel_1.setBounds(52, 348, 80, 39);
		panel.add(lblNewLabel_1);
		
		soluong = new JTextField();
		soluong.setBounds(142, 348, 46, 39);
		panel.add(soluong);
		soluong.setColumns(10);
		
		JLabel tongtien = new JLabel("0");
		tongtien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		tongtien.setForeground(new Color(255, 0, 0));
		tongtien.setBounds(129, 348, 155, 39);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(BanHang.class.getResource("/Hinh_Anh/icons8-thumbs-up-24.png")));
		btnNewButton_1.setBackground(new Color(118, 203, 33));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model_table = (DefaultTableModel) table.getModel();
				int i_row = table.getSelectedRow();
				String masp = model_table.getValueAt(i_row, 1) + "";
				String tensp = model_table.getValueAt(i_row, 2) + "";
				double giasp = Double.valueOf(model_table.getValueAt(i_row, 3) + "");

				    		int q1=1;
				            String q2 = masp;
				            String q3 = tensp;
				            String q4 = soluong.getText();
				            int q5 = Integer.valueOf(q4);
				            double q6 = giasp;
				            Object []row2={q1++,q2,q3,q4,q6,q5*q6};
				            dtm2.addRow(row2);
				            double TongTien =q5*q6;
				            TongTien+=Double.valueOf(tongtien.getText());
				    		tongtien.setText(TongTien+"");
				    		
			}
		});
		btnNewButton_1.setBounds(215, 348, 53, 39);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(BanHang.class.getResource("/Hinh_Anh/caro1.png")));
		lblNewLabel_4.setBounds(0, 0, 360, 398);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		String[]header2={"STT", "Mã Sản Phẩm", "Tên Sản Phẩm","Số Lượng", "Giá Sản Phẩm", "Thành Tiền"};

        dtm2=new DefaultTableModel(header2, 0){
        	
       };
        panel_1.add(new JScrollPane(table2 = new JTable(dtm2)));
        table2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
        table2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        table2.setBackground(new Color(255, 255, 255));
        table2.setForeground(new Color(118, 203, 33));
        table2.setRowHeight(30);
        table2.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
        JScrollPane scrollPane2 = new JScrollPane(table2);
		scrollPane2.setBounds(10, 54, 340, 283);
		panel_1.add(scrollPane2);
//		DefaultTableModel model_table2 = (DefaultTableModel) table2.getModel();
//		double TongTien =0;
//		 for(int i=0; i< table2.getRowCount(); i++) {
//		 TongTien+=(double)table2.getValueAt(i, 5);
//	 }	
			panel_1.add(tongtien);

		
		
		JLabel lblNewLabel_2 = new JLabel("Tổng Tiền:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(118, 203, 33));
		lblNewLabel_2.setBounds(10, 350, 121, 35);
		panel_1.add(lblNewLabel_2);
		
		
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(BanHang.class.getResource("/Hinh_Anh/icons8-print-26.png")));
		btnNewButton_2.setBackground(new Color(118, 203, 33));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(294, 351, 56, 39);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Đăng \r\nXuất");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
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
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setForeground(new Color(118, 203, 33));
		lblNewLabel_3.setIcon(new ImageIcon(BanHang.class.getResource("/Hinh_Anh/icons8-logout-64.png")));
		lblNewLabel_3.setBounds(218, 0, 132, 54);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(BanHang.class.getResource("/Hinh_Anh/caro1.png")));
		lblNewLabel_4_1.setBounds(0, 0, 360, 398);
		panel_1.add(lblNewLabel_4_1);
	}
	

public void LoadDBData2JTable() throws Exception{
        
        Connection conn=getConnection();
        String sql="select STT,`MaSP`, TenSP, GiaSP from sanpham"
        		+ " WHERE TenSP LIKE '%"+timkiem.getText()+"%'OR MaSP LIKE'%"+timkiem.getText()+"%'";
        ResultSet rs=conn.createStatement().executeQuery(sql);
    	int q1=1;
        while(rs.next()){
//            int name = rs.getInt(1);
            String q2 = rs.getString(2);
            String q3 = rs.getString(3);
//            String q4 = rs.getString(4);
//            int q5 = rs.getInt(5);
           double q6 = rs.getDouble(4);

            Object []row={q1++,q2,q3,q6};
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
//	 public double TinhTongTien(JTable jtb) {
//		 double TongTien =0;
//		 for(int i=0; i< jtb.getRowCount(); i++) {
//			 TongTien+=(double)jtb.getValueAt(i, 5);
//		 }		 
//		 return TongTien;
//	 }
}
