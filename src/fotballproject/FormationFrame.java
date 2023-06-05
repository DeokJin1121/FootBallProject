package fotballproject;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class FormationFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblFormation;
	private JButton btnFormation;
	private JButton btnFormation2;
	private JButton btnFomation3;
	private int Jang = 0;
	private int Byeon = 0;
	private int Park = 0;

	public static Statement stmt;
	public static Connection conn;

	private ResultSet rs;

	private Vector<String> data;

	private String MainPlayerID, MainPlayerName, MainPlayerAge, MainPlayerFrom, MainPlayerPosition,
			MainPlayerBackNumber;

	private JTable mainPlayerTb;

	private Object DBConnect;

	JLabel[] lbl = new JLabel[34];
	JLabel[] lblname = new JLabel[34];
	JLabel[] lblnumber = new JLabel[34];

	private JButton btninsert;
	private JComboBox<String> combo;
	private int x;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormationFrame frame = new FormationFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormationFrame() {
		setTitle("포메이션");
		setBounds(300, 50, 1162, 830);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(3, 0, 130, 119);
		contentPane.add(lblLogo);

		ImageIcon daicon1 = new ImageIcon("image/mancity6.png");
		Image daimage1 = daicon1.getImage();
		Image daimage3 = daimage1.getScaledInstance(130, 120, Image.SCALE_SMOOTH);
		ImageIcon daicon3 = new ImageIcon(daimage3);
		lblLogo.setIcon(daicon3);

		JLabel lblLogo2 = new JLabel(
				"<html><body><center>MANCHESTER CITY<br>PLAYER MANAGEMENT<br>PROGRAM</center></body></html>");
		lblLogo2.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblLogo2.setBounds(145, 10, 330, 103);
		contentPane.add(lblLogo2);

		// 포메이션 패널
		JPanel inputPanel = new JPanel();
		TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.BLACK, 1), "포메이션");
		titledBorder.setTitleFont(new Font("Decodig", Font.PLAIN, 20));
		inputPanel.setBackground(new Color(255, 255, 255));
		inputPanel.setBounds(32, 123, 429, 660);
		inputPanel.setBorder(titledBorder);

		lblFormation = new JLabel();
		lblFormation.setBounds(12, 33, 400, 572);
		inputPanel.add(lblFormation);

		ImageIcon daicon = new ImageIcon("image/fomation5.jpg");
		Image daimage = daicon.getImage();
		Image daimage2 = daimage.getScaledInstance(480, 754, Image.SCALE_SMOOTH);

		lblFormation.setIcon(daicon);

		for (int i = 1; i <= 33; i++) {
			lbl[i] = new JLabel();
			lblFormation.add(lbl[i]);
		}
		;
		for (int i = 1; i <= 33; i++) {
			lblname[i] = new JLabel();
			lblFormation.add(lblname[i]);
		}
		;
		for (int i = 1; i <= 33; i++) {
			lblnumber[i] = new JLabel();
			lblFormation.add(lblnumber[i]);
		}
		;

		contentPane.add(inputPanel);

		inputPanel.setLayout(null);

		btnFormation = new JButton("4-2-3-1");
		btnFormation.addActionListener(this);
		btnFormation.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnFormation.setBounds(12, 615, 109, 35);
		inputPanel.add(btnFormation);

		btnFormation2 = new JButton("4-1-2-3");
		btnFormation2.addActionListener(this);
		btnFormation2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnFormation2.setBounds(150, 615, 119, 35);
		inputPanel.add(btnFormation2);

		btnFomation3 = new JButton("4-2-2-2");
		btnFomation3.addActionListener(this);
		btnFomation3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnFomation3.setBounds(297, 615, 119, 35);
		inputPanel.add(btnFomation3);

		// 선발 선수 테이블 패널
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(null);
		tablePanel.setBackground(Color.WHITE);
		tablePanel.setBounds(488, 123, 634, 660);
		contentPane.add(tablePanel);

		TitledBorder titledBorder2 = new TitledBorder(new LineBorder(Color.BLACK, 1), "선발 선수 테이블");
		titledBorder2.setTitleFont(new Font("Decoding", Font.PLAIN, 20));
		tablePanel.setBorder(titledBorder2);

		String[] str = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" };
		combo = new JComboBox<String>(str);
		combo.setBounds(150, 400, 60, 30);
		tablePanel.add(combo);
		btninsert = new JButton("넣기");
		btninsert.setBounds(220, 400, 60, 30);
		tablePanel.add(btninsert);

		// 선발 선수 테이블 만들기
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
				
		JPanel starterPanel = new JPanel();
		starterPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		starterPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0)); // 패널 마진
		starterPanel.setBackground(new Color(255, 255, 255));
		starterPanel.setBounds(12, 28, 596, 368);
		tablePanel.add(starterPanel);

		Vector<String> vectorTitle = new Vector<String>(); // 헤더값

		vectorTitle.addElement("선수 코드");
		vectorTitle.addElement("이름");
		vectorTitle.addElement("나이");
		vectorTitle.addElement("국적");
		vectorTitle.addElement("포지션");
		vectorTitle.addElement("등번호");

		DefaultTableModel model = new DefaultTableModel(vectorTitle, 0) { // 테이블의 데이터 변경하려면 모델 사용
			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};

		// DB
		try {
			rs = stmt.executeQuery("SELECT * FROM mainplayer_tb"); // stmt 객체를 사용해서 데이터베이스 SQL 쿼리 실행

			while (rs.next()) {
				data = new Vector<String>(); // 데이블의 한 행의 데이터를 저장하는 데 사용

				// 각 열의 데이터를 문자열 형태로 가져와서 각 변수에 저장(인덱스는 1부터 시작)
				MainPlayerID = rs.getString(1);
				MainPlayerName = rs.getString(2);
				MainPlayerAge = rs.getString(3);
				MainPlayerFrom = rs.getString(4);
				MainPlayerPosition = rs.getString(5);
				MainPlayerBackNumber = rs.getString(6);

				// data에 각 변수 값을 각 열에 추가
				data.add(0, MainPlayerID);
				data.add(1, MainPlayerName);
				data.add(2, MainPlayerAge);
				data.add(3, MainPlayerFrom);
				data.add(4, MainPlayerPosition);
				data.add(5, MainPlayerBackNumber);

				model.addRow(data); // model 객체에 data 벡터를 추가하여 테이블에 새로운 행을 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 테이블
		mainPlayerTb = new JTable(model); // 데이터 변경 시 테이블에 직접 접근하지 않고 변경
		mainPlayerTb.getTableHeader().setReorderingAllowed(false); // 테이블 컬럼의 이동을 방지
		mainPlayerTb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 테이블 로우를 한개만 선택 가능
		mainPlayerTb.setFillsViewportHeight(true); // 스크롤 팬 안에 테이블 꽈차게 표시 -> 이거 없으면 배경색 설정 안됨
		mainPlayerTb.setBackground(Color.WHITE); // 테이블 배경색 지정

		JTableHeader tableHeader = mainPlayerTb.getTableHeader(); // 테이블 헤더 값 가져오기
		tableHeader.setBackground(new Color(0xB2CCFF)); // 테이블헤더 배경색 지정

		JScrollPane sp = new JScrollPane(mainPlayerTb, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(580, 199)); // 테이블 크기를 줄려면 JScrollPane의 크기를 변경

		starterPanel.add(sp);

		// 테이블 내용 가운데 정렬
		DefaultTableCellRenderer mpTableCellRenderer = new DefaultTableCellRenderer();
		mpTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel mpTableColumnModel = mainPlayerTb.getColumnModel();

		/*
		 * injuryTableColumnModel에서 인덱스 i에 해당하는 열의 셀 렌더러를 injuryTableCellRenderer로 설정 해당
		 * 열의 모든 셀의 렌더링 방식이 injuryTableCellRenderer로 지정된 방식으로 변경
		 */
		for (int i = 0; i < mpTableColumnModel.getColumnCount(); i++) {
			mpTableColumnModel.getColumn(i).setCellRenderer(mpTableCellRenderer);
		}

		btninsert.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		x = combo.getSelectedIndex();
		Object obj = e.getSource();
		if (obj == btnFormation) {
			Jang = 1;
			Byeon = 0;
			Park = 0;
			for (int i = 1; i <= 11; i++) {
				lbl[i].setBackground(Color.red);
				lbl[i].setOpaque(true);
			}
			for (int i = 1; i <= 11; i++) {
				lblname[i].setBackground(Color.yellow);
				lblname[i].setOpaque(true);
			}
			for (int i = 1; i <= 11; i++) {

				lblnumber[i].setOpaque(false);
			}
//----------------------------------골키퍼 위치 ------------

			lbl[1].setBounds(175, 510, 50, 50);
			lblname[1].setBounds(152, 560, 90, 15);
			lblnumber[1].setBounds(196, 495, 15, 15);
			lblnumber[1].setText("1");

//------------------------------------------------4   
			lbl[2].setBounds(30, 430, 50, 50);
			lblname[2].setBounds(9, 480, 90, 15);
			lblnumber[2].setBounds(51, 415, 15, 15);
			lblnumber[2].setText("2");

			lbl[3].setBounds(130, 430, 50, 50);
			lblname[3].setBounds(106, 480, 90, 15);
			lblnumber[3].setBounds(150, 415, 15, 15);
			lblnumber[3].setText("3");

			lbl[4].setBounds(220, 430, 50, 50);
			lblname[4].setBounds(200, 480, 90, 15);
			lblnumber[4].setBounds(244, 415, 15, 15);
			lblnumber[4].setText("4");

			lbl[5].setBounds(320, 430, 50, 50);
			lblname[5].setBounds(300, 480, 90, 15);
			lblnumber[5].setBounds(344, 415, 15, 15);
			lblnumber[5].setText("5");
//------------------------------------------------2                  
			lbl[6].setBounds(100, 340, 50, 50);
			lblname[6].setBounds(80, 390, 90, 15);
			lblnumber[6].setBounds(119, 325, 15, 15);
			lblnumber[6].setText("6");

			lbl[7].setBounds(247, 340, 50, 50);
			lblname[7].setBounds(227, 390, 90, 15);
			lblnumber[7].setBounds(266, 325, 15, 15);
			lblnumber[7].setText("7");
//-----------------------------------------------3            
			lbl[8].setBounds(60, 230, 50, 50);
			lblname[8].setBounds(40, 280, 90, 15);
			lblnumber[8].setBounds(79, 215, 15, 15);
			lblnumber[8].setText("8");

			lbl[9].setBounds(290, 230, 50, 50);
			lblname[9].setBounds(270, 280, 90, 15);
			lblnumber[9].setBounds(309, 215, 15, 15);
			lblnumber[9].setText("9");

			lbl[10].setBounds(175, 230, 50, 50);
			lblname[10].setBounds(155, 280, 90, 15);
			lblnumber[10].setBounds(194, 215, 15, 15);
			lblnumber[10].setText("10");
//------------------------------------------------1            
			lbl[11].setBounds(175, 140, 50, 50);
			lblname[11].setBounds(155, 190, 90, 15);
			lblnumber[11].setBounds(194, 125, 15, 15);
			lblnumber[11].setText("11");
//------------------------------------------------   

			for (int i = 1; i <= 11; i++) {
				lbl[i].setVisible(true);
			}
			for (int i = 12; i <= 23; i++) {
				lbl[i].setVisible(false);
			}
			for (int i = 24; i <= 33; i++) {
				lbl[i].setVisible(false);
			}
//         ------------------------------------------
			for (int i = 1; i <= 11; i++) {
				lblname[i].setVisible(true);
			}
			for (int i = 12; i <= 23; i++) {
				lblname[i].setVisible(false);
			}
			for (int i = 24; i <= 33; i++) {
				lblname[i].setVisible(false);

			}
			for (int i = 1; i <= 11; i++) {
				lblnumber[i].setVisible(true);
			}
			for (int i = 12; i <= 23; i++) {
				lblnumber[i].setVisible(false);
			}
			for (int i = 24; i <= 33; i++) {
				lblnumber[i].setVisible(false);
			}

		} else if (obj == btnFormation2) {
			Jang = 0;
			Byeon = 1;
			Park = 0;
			for (int i = 11; i <= 22; i++) {
				lbl[i].setBackground(Color.red);
				lbl[i].setOpaque(true);
			}
			for (int i = 11; i <= 22; i++) {
				lblname[i].setBackground(Color.yellow);
				lblname[i].setOpaque(true);
			}
			for (int i = 11; i <= 22; i++) {
				lblnumber[i].setOpaque(false);
			}

			lbl[12].setBounds(175, 510, 50, 50);
			lblname[12].setBounds(152, 560, 90, 15);
			lblnumber[12].setBounds(196, 495, 15, 15);
			lblnumber[12].setText("1");
//-----------------------------------------------4
			lbl[13].setBounds(30, 430, 50, 50);
			lblname[13].setBounds(9, 480, 90, 15);
			lblnumber[13].setBounds(51, 415, 15, 15);
			lblnumber[13].setText("2");

			lbl[14].setBounds(130, 430, 50, 50);
			lblname[14].setBounds(106, 480, 90, 15);
			lblnumber[14].setBounds(150, 415, 15, 15);
			lblnumber[14].setText("3");

			lbl[15].setBounds(220, 430, 50, 50);
			lblname[15].setBounds(200, 480, 90, 15);
			lblnumber[15].setBounds(244, 415, 15, 15);
			lblnumber[15].setText("4");

			lbl[16].setBounds(320, 430, 50, 50);
			lblname[16].setBounds(300, 480, 90, 15);
			lblnumber[16].setBounds(344, 415, 15, 15);
			lblnumber[16].setText("5");

//-----------------------------------------------1      
			lbl[17].setBounds(175, 340, 50, 50);
			lblname[17].setBounds(155, 390, 90, 15);
			lblnumber[17].setBounds(199, 325, 15, 15);
			lblnumber[17].setText("6");
//---------------------------   2               
			lbl[18].setBounds(100, 230, 50, 50);
			lblname[18].setBounds(80, 280, 90, 15);
			lblnumber[18].setBounds(124, 215, 15, 15);
			lblnumber[18].setText("7");

			lbl[19].setBounds(247, 230, 50, 50);
			lblname[19].setBounds(227, 280, 90, 15);
			lblnumber[19].setBounds(271, 215, 15, 15);
			lblnumber[19].setText("8");
//-----------------------------------------------3                  
			lbl[20].setBounds(60, 140, 50, 50);
			lblname[20].setBounds(40, 190, 90, 15);
			lblnumber[20].setBounds(84, 125, 15, 15);
			lblnumber[20].setText("9");

			lbl[21].setBounds(175, 140, 50, 50);
			lblname[21].setBounds(155, 190, 90, 15);
			lblnumber[21].setBounds(194, 125, 15, 15);
			lblnumber[21].setText("10");

			lbl[22].setBounds(290, 140, 50, 50);
			lblname[22].setBounds(270, 190, 90, 15);
			lblnumber[22].setBounds(309, 125, 15, 15);
			lblnumber[22].setText("11");

			for (int i = 1; i <= 11; i++) {
				lbl[i].setVisible(false);
			}
			for (int i = 12; i <= 22; i++) {
				lbl[i].setVisible(true);
			}
			for (int i = 24; i <= 33; i++) {
				lbl[i].setVisible(false);
			}
//----------------------------------------------
			for (int i = 1; i <= 11; i++) {
				lblname[i].setVisible(false);
			}
			for (int i = 12; i <= 23; i++) {
				lblname[i].setVisible(true);
			}
			for (int i = 24; i <= 33; i++) {
				lblname[i].setVisible(false);
			}
			// -------------------------------------
			for (int i = 1; i <= 11; i++) {
				lblnumber[i].setVisible(false);
			}
			for (int i = 12; i <= 22; i++) {
				lblnumber[i].setVisible(true);
			}
			for (int i = 23; i <= 33; i++) {
				lblnumber[i].setVisible(false);
			}

		} else if (obj == btnFomation3) {
			Jang = 0;
			Byeon = 0;
			Park = 1;
			for (int i = 23; i <= 33; i++) {
				lbl[i].setBackground(Color.red);
				lbl[i].setOpaque(true);
			}
			for (int i = 23; i <= 33; i++) {
				lblname[i].setBackground(Color.yellow);
				lblname[i].setOpaque(true);
			}

			for (int i = 23; i <= 33; i++) {
				lblnumber[i].setOpaque(false);
			}

			lbl[23].setBounds(175, 510, 50, 50);
			lblname[23].setBounds(152, 560, 90, 15);
			lblnumber[23].setBounds(196, 495, 15, 15);
			lblnumber[23].setText("1");
//---------------------------------------------4         
			lbl[24].setBounds(30, 430, 50, 50);
			lblname[24].setBounds(9, 480, 90, 15);
			lblnumber[24].setBounds(51, 415, 15, 15);
			lblnumber[24].setText("2");

			lbl[25].setBounds(130, 430, 50, 50);
			lblname[25].setBounds(106, 480, 90, 15);
			lblnumber[25].setBounds(150, 415, 15, 15);
			lblnumber[25].setText("3");

			lbl[26].setBounds(220, 430, 50, 50);
			lblname[26].setBounds(200, 480, 90, 15);
			lblnumber[26].setBounds(244, 415, 15, 15);
			lblnumber[26].setText("4");

			lbl[27].setBounds(320, 430, 50, 50);
			lblname[27].setBounds(300, 480, 90, 15);
			lblnumber[27].setBounds(344, 415, 15, 15);
			lblnumber[27].setText("5");

//----------------------------------------------2         
			lbl[28].setBounds(100, 340, 50, 50);
			lblname[28].setBounds(80, 390, 90, 15);
			lblnumber[28].setBounds(121, 325, 15, 15);
			lblnumber[28].setText("6");

			lbl[29].setBounds(247, 340, 50, 50);
			lblname[29].setBounds(227, 390, 90, 15);
			lblnumber[29].setBounds(268, 325, 15, 15);
			lblnumber[29].setText("7");
//----------------------------------------------2
			lbl[30].setBounds(60, 230, 50, 50);
			lblname[30].setBounds(40, 280, 90, 15);
			lblnumber[30].setBounds(81, 215, 15, 15);
			lblnumber[30].setText("8");

			lbl[31].setBounds(290, 230, 50, 50);
			lblname[31].setBounds(270, 280, 90, 15);
			lblnumber[31].setBounds(311, 215, 15, 15);
			lblnumber[31].setText("9");
//----------------------------------------------2   
			lbl[32].setBounds(100, 140, 50, 50);
			lblname[32].setBounds(80, 190, 90, 15);
			lblnumber[32].setBounds(119, 125, 15, 15);
			lblnumber[32].setText("10");

			lbl[33].setBounds(247, 140, 50, 50);
			lblname[33].setBounds(227, 190, 90, 15);
			lblnumber[33].setBounds(266, 125, 15, 15);
			lblnumber[33].setText("11");

			for (int i = 1; i <= 11; i++) {
				lbl[i].setVisible(false);
			}
			for (int i = 12; i <= 22; i++) {
				lbl[i].setVisible(false);
			}
			for (int i = 23; i <= 33; i++) {
				lbl[i].setVisible(true);
			}
//-------------------------------------------         
			for (int i = 1; i <= 11; i++) {
				lblname[i].setVisible(false);
			}
			for (int i = 12; i <= 22; i++) {
				lblname[i].setVisible(false);
			}
			for (int i = 23; i <= 33; i++) {
				lblname[i].setVisible(true);
			}
			for (int i = 1; i <= 11; i++) {
				lblnumber[i].setVisible(false);
			}
			for (int i = 12; i <= 22; i++) {
				lblnumber[i].setVisible(false);
			}
			for (int i = 23; i <= 33; i++) {
				lblnumber[i].setVisible(true);
			}
		} else if (obj == btninsert && Jang == 1) {
			if (x <= 10) {
				lbl[x + 1].setIcon(new ImageIcon("forimage/" + "고메스" + ".jpg"));
				lblname[x + 1].setText("");
				lblnumber[x + 1].setText("");
			}
		} else if (obj == btninsert && Byeon == 1) {
			if (x <= 10) {
				lbl[x + 11].setIcon(new ImageIcon("forimage/고메스.jpg"));
				lblname[x + 11].setText("");
				lblnumber[x + 11].setText("");
			}
		} else if (obj == btninsert && Park == 1) {
			if (x <= 10) {
				lbl[x + 21].setIcon(new ImageIcon("forimage/고메스.jpg"));
				lblname[x + 21].setText("");
				lblnumber[x + 21].setText("");
			}
		} else if (obj == btninsert && Jang == 0 && Byeon == 0 && Park == 0) {
			JOptionPane.showMessageDialog(this, "포메이션을 선택하세요.", "에러", JOptionPane.ERROR_MESSAGE);
		}
	}
}
