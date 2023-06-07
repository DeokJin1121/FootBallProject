package fotballproject;

import java.awt.EventQueue;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class StarterFrame extends JFrame implements ActionListener {

	private JPanel contentPane;

	public static Statement stmt;
	public static Connection conn;

	private ResultSet rs;

	private Vector<String> data;

	private String MainPlayerID, MainPlayerName, MainPlayerAge, MainPlayerFrom, MainPlayerPosition,
			MainPlayerBackNumber;

	private JTable mainPlayerTb;
	
	private Object DBConnect;
	
	private Vector<String> data2;

	private String SubPlayerID, SubPlayerName, SubPlayerAge, SubPlayerFrom, SubPlayerPosition, SubPlayerBackNumber;

	private JTable subPlayerTb;

	private String sql;

	private JPanel starterPanel;

	private JPanel subPanel;
	private JButton btnNewButton;

	private JButton btnSet;
	private JButton btnChange;

	private DefaultTableModel model;

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
		setBounds(100, 100, 1259, 550);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		DBConnect();

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
		JLabel lblLogo2 = new JLabel(
				"<html><body><center>MANCHESTER CITY<br>PLAYER MANAGEMENT<br>PROGRAM</center></body></html>");
		lblLogo2.setFont(new Font("Goudy Stout", Font.PLAIN, 16));
		lblLogo2.setBounds(130, 20, 342, 103);
		contentPane.add(lblLogo2);
		// 로고2 -------------------------------------------------------------------------

		// 선발 선수 패널 ----------------------------------------------------------------
		starterPanel = new JPanel();
		starterPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.BLACK, 1), "선발 선수");
		titledBorder.setTitleFont(new Font("Decodig", Font.PLAIN, 20));
		starterPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0)); // 패널 마진
		starterPanel.setBackground(Color.WHITE);
		starterPanel.setBounds(15, 133, 600, 300);
		starterPanel.setBorder(titledBorder);

		contentPane.add(starterPanel);

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

		// 후보 선수 패널 ----------------------------------------------------------------
		subPanel = new JPanel();
		TitledBorder titledBorder2 = new TitledBorder(new LineBorder(Color.BLACK, 1), "후보 선수");
		titledBorder2.setTitleFont(new Font("Decodig", Font.PLAIN, 20));
		subPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0)); // 패널 마진
		subPanel.setBackground(Color.WHITE);
		subPanel.setBounds(630, 133, 600, 300);
		subPanel.setBorder(titledBorder2);

		contentPane.add(subPanel);

		Vector<String> vectorTitle2 = new Vector<String>(); // 헤더값

		vectorTitle2.addElement("선수 코드");
		vectorTitle2.addElement("이름");
		vectorTitle2.addElement("나이");
		vectorTitle2.addElement("국적");
		vectorTitle2.addElement("포지션");
		vectorTitle2.addElement("등번호");

		DefaultTableModel model2 = new DefaultTableModel(vectorTitle2, 0) { // 테이블의 데이터 변경하려면 모델 사용
			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};

		// DB
		try {
			rs = stmt.executeQuery("SELECT * FROM subplayer_tb"); // stmt 객체를 사용해서 데이터베이스 SQL 쿼리 실행

			while (rs.next()) {
				data2 = new Vector<String>(); // 데이블의 한 행의 데이터를 저장하는 데 사용

				// 각 열의 데이터를 문자열 형태로 가져와서 각 변수에 저장(인덱스는 1부터 시작)
				SubPlayerID = rs.getString(1);
				SubPlayerName = rs.getString(2);
				SubPlayerAge = rs.getString(3);
				SubPlayerFrom = rs.getString(4);
				SubPlayerPosition = rs.getString(5);
				SubPlayerBackNumber = rs.getString(6);

				// data에 각 변수 값을 각 열에 추가
				data2.add(0, SubPlayerID);
				data2.add(1, SubPlayerName);
				data2.add(2, SubPlayerAge);
				data2.add(3, SubPlayerFrom);
				data2.add(4, SubPlayerPosition);
				data2.add(5, SubPlayerBackNumber);

				model2.addRow(data2); // model 객체에 data 벡터를 추가하여 테이블에 새로운 행을 추가
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 테이블
		subPlayerTb = new JTable(model2); // 데이터 변경 시 테이블에 직접 접근하지 않고 변경
		subPlayerTb.getTableHeader().setReorderingAllowed(false); // 테이블 컬럼의 이동을 방지
		subPlayerTb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 테이블 로우를 한개만 선택 가능
		subPlayerTb.setFillsViewportHeight(true); // 스크롤 팬 안에 테이블 꽈차게 표시 -> 이거 없으면 배경색 설정 안됨
		subPlayerTb.setBackground(Color.WHITE); // 테이블 배경색 지정

		JTableHeader tableHeader2 = subPlayerTb.getTableHeader(); // 테이블 헤더 값 가져오기
		tableHeader2.setBackground(new Color(0xB2CCFF)); // 테이블헤더 배경색 지정

		JScrollPane sp2 = new JScrollPane(subPlayerTb, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp2.setPreferredSize(new Dimension(580, 215)); // 테이블 크기를 줄려면 JScrollPane의 크기를 변경

		// 테이블 내용 가운데 정렬
		DefaultTableCellRenderer mpTableCellRenderer2 = new DefaultTableCellRenderer();
		mpTableCellRenderer2.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel mpTableColumnModel2 = subPlayerTb.getColumnModel();

		/*
		 * injuryTableColumnModel에서 인덱스 i에 해당하는 열의 셀 렌더러를 injuryTableCellRenderer로 설정 해당
		 * 열의 모든 셀의 렌더링 방식이 injuryTableCellRenderer로 지정된 방식으로 변경
		 */
		for (int i = 0; i < mpTableColumnModel2.getColumnCount(); i++) {
			mpTableColumnModel2.getColumn(i).setCellRenderer(mpTableCellRenderer2);
		}

		subPanel.add(sp2);

		btnChange = new JButton("교체");
		btnChange.setBounds(569, 450, 112, 40);
		btnChange.addActionListener(this);
		contentPane.add(btnChange);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == btnChange) {
			
			int MainSelect = mainPlayerTb.getSelectedRow();
			int SubSelect = subPlayerTb.getSelectedRow();

			String MainID = null;
			String MainName = null;
			String MainAge = null;
			String MainFrom = null;
			String MainPosition = null;
			String MainBackNumber = null;
			String SubID = null;
			String SubName = null;
			String SubAge = null;
			String SubFrom = null;
			String SubPosition = null;
			String SubBackNumber = null;

			// 선택 안했을 때
			if (MainSelect < 0) {
				JOptionPane.showMessageDialog(this, "선발 선수를 선택해주세요.");
				return;
			}

			if (SubSelect < 0) {
				JOptionPane.showMessageDialog(this, "후보 선수를 선택해주세요.");
				return;
			}

			// 선발 선수 데이터 가져오기
			try {
				rs = stmt.executeQuery("SELECT * FROM mainplayer_tb");

				for (int i = 0; i < MainSelect + 1; i++) {
					rs.next();
					MainID = rs.getString("PLAYER_ID");
					MainName = rs.getString("PLAYER_NAME");
					MainAge = rs.getString("PLAYER_AGE");
					MainFrom = rs.getString("PLAYER_FROM");
					MainPosition = rs.getString("PLAYER_POSITION");
					MainBackNumber = rs.getString("PLAYER_BACKNUMBER");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			// 후보 선수 데이터 가져오기
			try {
				rs = stmt.executeQuery("SELECT * FROM subplayer_tb");

				for (int i = 0; i < SubSelect + 1; i++) {
					rs.next();
					SubID = rs.getString("PLAYER_ID");
					SubName = rs.getString("PLAYER_NAME");
					SubAge = rs.getString("PLAYER_AGE");
					SubFrom = rs.getString("PLAYER_FROM");
					SubPosition = rs.getString("PLAYER_POSITION");
					SubBackNumber = rs.getString("PLAYER_BACKNUMBER");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			if (JOptionPane.showConfirmDialog(this, "선수를 교체하시겠습니까?", "교체", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

				// 선발, 후보 삽입
				try {
					sql = "insert into mainplayer_tb\r\n"
							+ "(PLAYER_ID, PLAYER_NAME, PLAYER_AGE, PLAYER_FROM, PLAYER_POSITION, PLAYER_BACKNUMBER)\r\n"
							+ "VALUES(" + SubID + ", '" + SubName + "', " + SubAge + ", '" + SubFrom + "', '"
							+ SubPosition + "', " + SubBackNumber + ")";
					stmt.executeUpdate(sql);

					sql = "insert into subplayer_tb\r\n"
							+ "(PLAYER_ID, PLAYER_NAME, PLAYER_AGE, PLAYER_FROM, PLAYER_POSITION, PLAYER_BACKNUMBER)\r\n"
							+ "VALUES(" + MainID + ", '" + MainName + "', " + MainAge + ", '" + MainFrom + "', '"
							+ MainPosition + "', " + MainBackNumber + ")";
					stmt.executeUpdate(sql);

					// 선발, 후보 삭제
					sql = "DELETE FROM subplayer_tb\r\n" + "WHERE PLAYER_ID=" + SubID + "";
					stmt.executeUpdate(sql);

					sql = "DELETE FROM mainplayer_tb\r\n" + "WHERE PLAYER_ID=" + MainID + "";
					stmt.executeUpdate(sql);
					
					// 선발 선수 테이블 초기화
					DefaultTableModel mainPlayerModel = (DefaultTableModel) mainPlayerTb.getModel();	// 선발 선수 모델 가져오기
					mainPlayerModel.setRowCount(0); // 기존 행 모두 제거

					try {
						rs = stmt.executeQuery("SELECT * FROM mainplayer_tb");
						while (rs.next()) {
							// 데이터 가져와서 테이블 모델에 추가
							MainPlayerID = rs.getString(1);
							MainPlayerName = rs.getString(2);
							MainPlayerAge = rs.getString(3);
							MainPlayerFrom = rs.getString(4);
							MainPlayerPosition = rs.getString(5);
							MainPlayerBackNumber = rs.getString(6);
							mainPlayerModel.addRow(new Object[] { MainPlayerID, MainPlayerName, MainPlayerAge, MainPlayerFrom,
									MainPlayerPosition, MainPlayerBackNumber });

						}
					} catch (SQLException ex) {
						ex.printStackTrace();
					}

					// 후보 선수 테이블 초기화
					DefaultTableModel subPlayerModel = (DefaultTableModel) subPlayerTb.getModel();  // 후보 선수 모델 가져오기
					subPlayerModel.setRowCount(0); // 기존 행 모두 제거

					try {
						rs = stmt.executeQuery("SELECT * FROM subplayer_tb");
						while (rs.next()) {
							// 데이터 가져와서 테이블 모델에 추가
							SubPlayerID = rs.getString(1);
							SubPlayerName = rs.getString(2);
							SubPlayerAge = rs.getString(3);
							SubPlayerFrom = rs.getString(4);
							SubPlayerPosition = rs.getString(5);
							SubPlayerBackNumber = rs.getString(6);
							subPlayerModel.addRow(new Object[] { SubPlayerID, SubPlayerName, SubPlayerAge, SubPlayerFrom,
									SubPlayerPosition, SubPlayerBackNumber });
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
					}

					JOptionPane.showMessageDialog(this, "선수가 교체되었습니다.");

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}
	}
}
