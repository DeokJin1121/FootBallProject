package fotballproject;

import java.awt.EventQueue;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class StarterFrame extends JFrame implements MouseListener {

	private JPanel contentPane;
	
	public static Statement stmt;
	public static Connection conn;
	
	private ResultSet rs;

	private Vector<String> data;

	private String MAINPLAYER_ID, MAINPLAYER_NAME, MAINPLAYER_AGE,
	MAINPLAYER_FROM, MAINPLAYER_POSITHON, MAINPLAYER_BACKNUMBER ;
	
	private JTable mainPlayerTb;

	private Object DBConnect;

	private Vector<String> data2;

	private String SUBPLAYER_ID, SUBPLAYER_NAME, SUBPLAYER_AGE,
    SUBPLAYER_FROM, SUBPLAYER_POSITHON, SUBPLAYER_BACKNUMBER;

	private JTable subPlayerTb;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StarterFrame frame = new StarterFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	private static void DBConnect() {
		// DB 연결
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/footballprojectdb", "root", "1234");
			
			stmt = conn.createStatement();
			
//			System.out.println("OK");
			
		} catch (ClassNotFoundException e) {
			System.out.println("해당 드라이버가 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("접속 오류 / SQL 오류");
			e.printStackTrace();
		}
	}

	public StarterFrame() {
		setTitle("선발/후보 선수 관리");
		setBounds(100, 100, 1259, 696);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DBConnect();
		
		// DB 연결
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/footballprojectdb", "root", "1234");
					
					stmt = conn.createStatement();
					
//					System.out.println("OK");
					
				} catch (ClassNotFoundException e) {
					System.out.println("해당 드라이버가 없습니다.");
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("접속 오류 / SQL 오류");
					e.printStackTrace();
				}
				
		// 로고 -------------------------------------------------------------------------- 
		JLabel lblLogo = new JLabel();
		lblLogo.setBounds(0, 2, 135, 125);
		contentPane.add(lblLogo);
		
		ImageIcon daicon1 = new ImageIcon("image/mancity6.png");
		Image daimage1 = daicon1.getImage();
		Image daimage3 = daimage1.getScaledInstance(110, 103, Image.SCALE_SMOOTH);
		ImageIcon daicon3 = new ImageIcon(daimage3);
		lblLogo.setIcon(daicon3);
		
		// 로고 -------------------------------------------------------------------------- 
		
		// 로고2 ------------------------------------------------------------------------- 
		JLabel lblLogo2 = new JLabel("<html><body><center>MANCHESTER CITY<br>PLAYER MANAGEMENT<br>PROGRAM</center></body></html>");
		lblLogo2.setFont(new Font("Goudy Stout", Font.PLAIN, 16));
		lblLogo2.setBounds(130, 20, 342, 103);
		contentPane.add(lblLogo2);
		// 로고2 ------------------------------------------------------------------------- 
		
		// 선발 선수 패널 ----------------------------------------------------------------
		JPanel starterPanel = new JPanel();
		starterPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.BLACK,1), "선발 선수");
		titledBorder.setTitleFont(new Font("Decodig", Font.PLAIN, 20));
		starterPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));	// 패널 마진
		starterPanel.setBackground(Color.WHITE);
		starterPanel.setBounds(15, 133, 600, 270);
		starterPanel.setBorder(titledBorder);
	
		contentPane.add(starterPanel);	
		
		Vector<String> vectorTitle = new Vector<String>();		// 헤더값
		
		vectorTitle.addElement("선수 코드");
		vectorTitle.addElement("이름");
		vectorTitle.addElement("나이");
		vectorTitle.addElement("국적");
		vectorTitle.addElement("포지션");
		vectorTitle.addElement("등번호");
		
		DefaultTableModel model = new DefaultTableModel(vectorTitle, 0) {		// 테이블의 데이터 변경하려면 모델 사용
			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};
		
		// DB
		try {
			rs = stmt.executeQuery("SELECT * FROM mainplayer_tb");
			
			while(rs.next()) {
				data = new Vector<String>();
				
				MAINPLAYER_ID = rs.getString(1);
				MAINPLAYER_NAME = rs.getString(2);
				MAINPLAYER_AGE = rs.getString(3);
				MAINPLAYER_FROM = rs.getString(4);
				MAINPLAYER_POSITHON = rs.getString(5);
				MAINPLAYER_BACKNUMBER = rs.getString(6);
				
				data.add(0,MAINPLAYER_ID);
				data.add(1,MAINPLAYER_NAME);
				data.add(2,MAINPLAYER_AGE);
				data.add(3,MAINPLAYER_FROM);
				data.add(4,MAINPLAYER_POSITHON);
				data.add(5,MAINPLAYER_BACKNUMBER);
				
				model.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 테이블
		mainPlayerTb = new JTable(model);   // 데이터 변경 시 테이블에 직접 접근하지 않고 변경
		mainPlayerTb.getTableHeader().setReorderingAllowed(false);	// 테이블 컬럼의 이동을 방지
		mainPlayerTb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    // 테이블 로우를 한개만 선택 가능
		mainPlayerTb.setFillsViewportHeight(true);	// 스크롤 팬 안에 테이블 꽈차게 표시 -> 이거 없으면 배경색 설정 안됨
		mainPlayerTb.setBackground(Color.WHITE);  // 테이블 배경색 지정
		
		mainPlayerTb.addMouseListener(this);
		JTableHeader tableHeader = mainPlayerTb.getTableHeader(); 	// 테이블 헤더 값 가져오기
		tableHeader.setBackground(new Color(0xB2CCFF));   // 테이블헤더 배경색 지정
		
		JScrollPane sp = new JScrollPane(mainPlayerTb, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(580, 200));	// 테이블 크기를 줄려면 JScrollPane의 크기를 변경
		
		starterPanel.add(sp);
		
		// 테이블 내용 가운데 정렬
		DefaultTableCellRenderer mpTableCellRenderer = new DefaultTableCellRenderer();
		mpTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel mpTableColumnModel = mainPlayerTb.getColumnModel();
		
		for(int i = 0; i < mpTableColumnModel.getColumnCount(); i++) {
			mpTableColumnModel.getColumn(i).setCellRenderer(mpTableCellRenderer);
		}
		
		// 후보 선수 패널 ----------------------------------------------------------------
		JPanel subPanel = new JPanel();
		TitledBorder titledBorder2 = new TitledBorder(new LineBorder(Color.BLACK,1), "후보 선수");
		titledBorder2.setTitleFont(new Font("Decodig", Font.PLAIN, 20));
		subPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));	// 패널 마진
		subPanel.setBackground(Color.WHITE);
		subPanel.setBounds(630, 133, 600, 270);
		subPanel.setBorder(titledBorder2);
		
		Vector<String> vectorTitle2 = new Vector<String>();		// 헤더값
		
		vectorTitle2.addElement("선수 코드");
		vectorTitle2.addElement("이름");
		vectorTitle2.addElement("나이");
		vectorTitle2.addElement("국적");
		vectorTitle2.addElement("포지션");
		vectorTitle2.addElement("등번호");
		
		DefaultTableModel model2 = new DefaultTableModel(vectorTitle, 0) {		// 테이블의 데이터 변경하려면 모델 사용
			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};
		
		contentPane.add(subPanel);
		
		// DB
				try {
					rs = stmt.executeQuery("SELECT * FROM subplayer_tb");
					
					while(rs.next()) {
						data2 = new Vector<String>();
						
						SUBPLAYER_ID = rs.getString(1);
						SUBPLAYER_NAME = rs.getString(2);
						SUBPLAYER_AGE = rs.getString(3);
						SUBPLAYER_FROM = rs.getString(4);
						SUBPLAYER_POSITHON = rs.getString(5);
						SUBPLAYER_BACKNUMBER = rs.getString(6);
						
						data2.add(0,SUBPLAYER_ID);
						data2.add(1,SUBPLAYER_NAME);
						data2.add(2,SUBPLAYER_AGE);
						data2.add(3,SUBPLAYER_FROM);
						data2.add(4,SUBPLAYER_POSITHON);
						data2.add(5,SUBPLAYER_BACKNUMBER);
						
						model2.addRow(data2);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				// 테이블
				subPlayerTb = new JTable(model2);   // 데이터 변경 시 테이블에 직접 접근하지 않고 변경
				subPlayerTb.getTableHeader().setReorderingAllowed(false);	// 테이블 컬럼의 이동을 방지
				subPlayerTb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    // 테이블 로우를 한개만 선택 가능
				subPlayerTb.setFillsViewportHeight(true);	// 스크롤 팬 안에 테이블 꽈차게 표시 -> 이거 없으면 배경색 설정 안됨
				subPlayerTb.setBackground(Color.WHITE);  // 테이블 배경색 지정
				
				subPlayerTb.addMouseListener(this);
				JTableHeader tableHeader2 = subPlayerTb.getTableHeader(); 	// 테이블 헤더 값 가져오기
				tableHeader2.setBackground(new Color(0xB2CCFF));   // 테이블헤더 배경색 지정
				
				JScrollPane sp2 = new JScrollPane(subPlayerTb, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				sp2.setPreferredSize(new Dimension(580, 215));	// 테이블 크기를 줄려면 JScrollPane의 크기를 변경
				
				// 테이블 내용 가운데 정렬
				DefaultTableCellRenderer mpTableCellRenderer2 = new DefaultTableCellRenderer();
				mpTableCellRenderer2.setHorizontalAlignment(SwingConstants.CENTER);
				TableColumnModel mpTableColumnModel2 = subPlayerTb.getColumnModel();
				
				for(int i = 0; i < mpTableColumnModel2.getColumnCount(); i++) {
					mpTableColumnModel2.getColumn(i).setCellRenderer(mpTableCellRenderer2);
				}
				
				subPanel.add(sp2);
		
		JButton btnNewButton = new JButton("교체");
		btnNewButton.setBounds(555, 425, 112, 40);
		contentPane.add(btnNewButton);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
