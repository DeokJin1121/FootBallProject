package fo0tballproject_package;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InjuryFrame extends JFrame implements ActionListener {

	private JPanel contentPane;

	private ResultSet rs;

	private Vector<String> data;

	private String INJURYPLAYER_ID, INJURYPLAYER_NAME, INJURYPLAYER_AGE, INJURYPLAYER_POSITION,
			INJURYPLAYER_INJUREDPART;

	private JTable injuryPlayerTb;

	private Vector<String> data2;

	private String PLAYER_ID, PLAYER_NAME, PLAYER_AGE, PLAYER_POSITION, PLAYER_FROM, PLAYER_BACKNUMBER;

	private JTable PlayerTb;

	private JPanel playerPanel;
	private JPanel injuryPanel;

	private JButton btninjuryAdd;
	private JButton btninjuryDelete;

	private String playerID;
	private String playerName;
	private String playerAge;
	private String playerFrom;
	private String playerPosition;
	private String playerBackNumber;

	private String sql;

	private String INJURYPLAYER_FROM;

	private String INJURYPLAYER_BACKNUMBER;

	private DefaultTableModel model2;

	private DefaultTableModel model;

	private JButton btnSet;

	public static Statement stmt;
	public static Connection conn;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InjuryFrame frame = new InjuryFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InjuryFrame() {
		setTitle("부상 선수 추가/삭제");
		setBounds(100, 100, 1259, 696);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setResizable(false);

		setContentPane(contentPane);

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

		// 부상자 패널(부상자 명단)
		injuryPanel = new JPanel();
		injuryPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.BLACK, 1), "부상 선수 명단");
		titledBorder.setTitleFont(new Font("Decodig", Font.PLAIN, 20));
		injuryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0)); // 패널 마진
		injuryPanel.setBackground(Color.WHITE);
		injuryPanel.setBounds(15, 133, 600, 450);
		injuryPanel.setBorder(titledBorder);

		contentPane.add(injuryPanel);

		Vector<String> vectorTitle = new Vector<String>(); // 헤더값

		vectorTitle.addElement("선수 코드");
		vectorTitle.addElement("이름");
		vectorTitle.addElement("나이");
		vectorTitle.addElement("포지션");
		vectorTitle.addElement("부상 부위");

		model = new DefaultTableModel(vectorTitle, 0) { // 테이블의 데이터 변경하려면 모델 사용
			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};

		// DB
		try {
			rs = stmt.executeQuery("SELECT * FROM injuryplayer_tb"); // stmt 객체를 사용해서 데이터베이스 SQL 쿼리 실행

			while (rs.next()) {
				data = new Vector<String>(); // 데이블의 한 행의 데이터를 저장하는 데 사용

				// 각 열의 데이터를 문자열 형태로 가져와서 각 변수에 저장(인덱스는 1부터 시작)
				INJURYPLAYER_ID = rs.getString(1);
				INJURYPLAYER_NAME = rs.getString(2);
				INJURYPLAYER_AGE = rs.getString(3);
				INJURYPLAYER_POSITION = rs.getString(4);
				INJURYPLAYER_INJUREDPART = rs.getString(5);

				// data에 각 변수 값을 각 열에 추가
				data.add(0, INJURYPLAYER_ID);
				data.add(1, INJURYPLAYER_NAME);
				data.add(2, INJURYPLAYER_AGE);
				data.add(3, INJURYPLAYER_POSITION);
				data.add(4, INJURYPLAYER_INJUREDPART);

				model.addRow(data); // model 객체에 data 벡터를 추가하여 테이블에 새로운 행을 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 테이블
		injuryPlayerTb = new JTable(model); // 데이터 변경 시 테이블에 직접 접근하지 않고 변경
		injuryPlayerTb.getTableHeader().setReorderingAllowed(false); // 테이블 컬럼의 이동을 방지
		injuryPlayerTb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 테이블 로우를 한개만 선택 가능
		injuryPlayerTb.setFillsViewportHeight(true); // 스크롤 팬 안에 테이블 꽈차게 표시 -> 이거 없으면 배경색 설정 안됨
		injuryPlayerTb.setBackground(Color.WHITE); // 테이블 배경색 지정

		JTableHeader tableHeader = injuryPlayerTb.getTableHeader(); // 테이블 헤더 값 가져오기
		tableHeader.setBackground(new Color(0xB2CCFF)); // 테이블헤더 배경색 지정

		JScrollPane sp = new JScrollPane(injuryPlayerTb, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(580, 391)); // 테이블 크기를 줄려면 JScrollPane의 크기를 변경

		injuryPanel.add(sp);

		// 테이블 내용 가운데 정렬
		DefaultTableCellRenderer injuryTableCellRenderer = new DefaultTableCellRenderer(); // 테이블의 셀을 렌더링하는 역할
		injuryTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // 수평 정렬 방식, 테이블의 셀 내용이 가운데로 정렬
		TableColumnModel injuryTableColumnModel = injuryPlayerTb.getColumnModel(); // 테이블의 열 관련 정보를 관리하는 모델

		/*
		 * injuryTableColumnModel에서 인덱스 i에 해당하는 열의 셀 렌더러를 injuryTableCellRenderer로 설정 해당
		 * 열의 모든 셀의 렌더링 방식이 injuryTableCellRenderer로 지정된 방식으로 변경
		 */
		for (int i = 0; i < injuryTableColumnModel.getColumnCount(); i++) { // 열의 개수만큼 반복하는 반복문
			injuryTableColumnModel.getColumn(i).setCellRenderer(injuryTableCellRenderer);
		}

		// 선수 패널(선수 명단)
		playerPanel = new JPanel();
		TitledBorder titledBorder2 = new TitledBorder(new LineBorder(Color.BLACK, 1), "선수 명단");
		titledBorder2.setTitleFont(new Font("Decodig", Font.PLAIN, 20));
		playerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0)); // 패널 마진
		playerPanel.setBackground(Color.WHITE);
		playerPanel.setBounds(630, 133, 600, 450);
		playerPanel.setBorder(titledBorder2);

		contentPane.add(playerPanel);

		Vector<String> vectorTitle2 = new Vector<String>(); // 헤더값

		vectorTitle2.addElement("선수 코드");
		vectorTitle2.addElement("이름");
		vectorTitle2.addElement("나이");
		vectorTitle2.addElement("국적");
		vectorTitle2.addElement("포지션");
		vectorTitle2.addElement("등번호");

		model2 = new DefaultTableModel(vectorTitle2, 0) { // 테이블의 데이터 변경하려면 모델 사용
			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};

		// DB
		try {
			rs = stmt.executeQuery("SELECT * FROM player_tb"); // stmt 객체를 사용해서 데이터베이스 SQL 쿼리 실행

			while (rs.next()) {
				data2 = new Vector<String>(); // 데이블의 한 행의 데이터를 저장하는 데 사용

				// 각 열의 데이터를 문자열 형태로 가져와서 각 변수에 저장(인덱스는 1부터 시작)
				PLAYER_ID = rs.getString(1);
				PLAYER_NAME = rs.getString(2);
				PLAYER_AGE = rs.getString(3);
				PLAYER_FROM = rs.getString(4);
				PLAYER_POSITION = rs.getString(5);
				PLAYER_BACKNUMBER = rs.getString(6);

				// data에 각 변수 값을 각 열에 추가
				data2.add(0, PLAYER_ID);
				data2.add(1, PLAYER_NAME);
				data2.add(2, PLAYER_AGE);
				data2.add(3, PLAYER_FROM);
				data2.add(4, PLAYER_POSITION);
				data2.add(5, PLAYER_BACKNUMBER);

				model2.addRow(data2); // model 객체에 data 벡터를 추가하여 테이블에 새로운 행을 추가
			}

			// 테이블
			PlayerTb = new JTable(model2); // 데이터 변경 시 테이블에 직접 접근하지 않고 변경
			PlayerTb.getTableHeader().setReorderingAllowed(false); // 테이블 컬럼의 이동을 방지
			PlayerTb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 테이블 로우를 한개만 선택 가능
			PlayerTb.setFillsViewportHeight(true); // 스크롤 팬 안에 테이블 꽉차게 표시 -> 이거 없으면 배경색 설정 안됨
			PlayerTb.setBackground(Color.WHITE); // 테이블 배경색 지정

			JTableHeader tableHeader2 = PlayerTb.getTableHeader(); // 테이블 헤더 값 가져오기
			tableHeader2.setBackground(new Color(0xB2CCFF)); // 테이블헤더 배경색 지정

			JScrollPane sp2 = new JScrollPane(PlayerTb, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			sp2.setPreferredSize(new Dimension(580, 391)); // 테이블 크기를 줄려면 JScrollPane의 크기를 변경

			playerPanel.add(sp2);

			// 테이블 내용 가운데 정렬
			DefaultTableCellRenderer playerTableCellRenderer = new DefaultTableCellRenderer(); // 테이블의 셀을 렌더링하는 역할
			playerTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // 수평 정렬 방식, 테이블의 셀 내용이 가운데로 정렬
			TableColumnModel playerTableColumnModel = PlayerTb.getColumnModel(); // 테이블의 열 관련 정보를 관리하는 모델

			/*
			 * injuryTableColumnModel에서 인덱스 i에 해당하는 열의 셀 렌더러를 injuryTableCellRenderer로 설정 해당
			 * 열의 모든 셀의 렌더링 방식이 injuryTableCellRenderer로 지정된 방식으로 변경
			 */
			for (int i = 0; i < playerTableColumnModel.getColumnCount(); i++) { // 열의 개수만큼 반복하는 반복문
				playerTableColumnModel.getColumn(i).setCellRenderer(playerTableCellRenderer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		btninjuryAdd = new JButton("부상 추가");
		btninjuryAdd.setBounds(886, 593, 109, 40);
		btninjuryAdd.addActionListener(this);
		contentPane.add(btninjuryAdd);

		btninjuryDelete = new JButton("부상 삭제");
		btninjuryDelete.setBounds(244, 593, 109, 40);
		btninjuryDelete.addActionListener(this);
		contentPane.add(btninjuryDelete);

		btnSet = new JButton();
		btnSet.addActionListener(this);
		btnSet.setBackground(new Color(255, 255, 255));
		btnSet.setBorderPainted(false);
		btnSet.setBounds(605, 105, 32, 32);
		contentPane.add(btnSet);

		ImageIcon daicon2 = new ImageIcon("image/새로고침.png");
		Image daimage2 = daicon2.getImage();
		Image daimage4 = daimage2.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		ImageIcon daicon4 = new ImageIcon(daimage4);
		btnSet.setIcon(daicon4);

		ImageIcon daicon6 = new ImageIcon("image/새로고침2.png");
		Image daimag3 = daicon6.getImage();
		Image daimage5 = daimage3.getScaledInstance(32, 32, Image.SCALE_SMOOTH);

		btnSet.setPressedIcon(daicon2); // 눌렀을 때
		btnSet.setRolloverIcon(daicon6); // 올려 놨을 때

	}

	private void DBConnect() {
		// DB 연결
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/footballprojectdb", "root", "1234");

			stmt = conn.createStatement();

//         System.out.println("OK");

		} catch (ClassNotFoundException e) {
			System.out.println("해당 드라이버가 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("접속 오류 / SQL 오류");
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// 새로고침 버튼 눌렀을 때
		if (obj == btnSet) {
			// 테이블 새로고침
			model2 = (DefaultTableModel) PlayerTb.getModel();
			model2.setRowCount(0); // 기존 행 모두 제거

			try {
				rs = stmt.executeQuery("SELECT * FROM player_tb");
				while (rs.next()) {
					// 데이터 가져와서 테이블 모델에 추가
					PLAYER_ID = rs.getString(1);
					PLAYER_NAME = rs.getString(2);
					PLAYER_AGE = rs.getString(3);
					PLAYER_FROM = rs.getString(4);
					PLAYER_POSITION = rs.getString(5);
					PLAYER_BACKNUMBER = rs.getString(6);
					model2.addRow(new Object[] { PLAYER_ID, PLAYER_NAME, PLAYER_AGE, PLAYER_FROM, PLAYER_POSITION,
							PLAYER_BACKNUMBER });

				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

			model = (DefaultTableModel) injuryPlayerTb.getModel();
			model.setRowCount(0); // 기존 행 모두 제거

			try {
				rs = stmt.executeQuery("SELECT * FROM injuryplayer_tb");
				while (rs.next()) {
					// 데이터 가져와서 테이블 모델에 추가
					INJURYPLAYER_ID = rs.getString(1);
					INJURYPLAYER_NAME = rs.getString(2);
					INJURYPLAYER_AGE = rs.getString(3);
					INJURYPLAYER_FROM = rs.getString(4);
					INJURYPLAYER_POSITION = rs.getString(5);
					INJURYPLAYER_BACKNUMBER = rs.getString(6);
					model.addRow(new Object[] { INJURYPLAYER_ID, INJURYPLAYER_NAME, INJURYPLAYER_AGE, INJURYPLAYER_FROM,
							INJURYPLAYER_POSITION, INJURYPLAYER_BACKNUMBER });
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		// 부상 추가 버튼 눌렀을 때
		if (obj == btninjuryAdd) {

			int select = PlayerTb.getSelectedRow(); // 선택된 행의 값을 int 값으로 select에 저장

			if (select == -1) {
				JOptionPane.showMessageDialog(null, "선수 명단에서 선수를 선택하세요", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				new InjuredPart(select);
			}
		}

		// 부상 삭제 버튼을 눌렀을 때
		if (obj == btninjuryDelete) {
			int select2 = injuryPlayerTb.getSelectedRow(); // 선택된 행의 값을 int 값으로 select에 저장

			if (select2 >= 0
					&& JOptionPane.showConfirmDialog(this, "부상 선수를 삭제 하시겠습니까?", "부상 삭제", JOptionPane.YES_NO_OPTION, // 행이
																													// 선택되고
																													// Yes
																													// 옵션을
																													// 눌렀을
																													// 때
																													// 실행
							JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

				try {
					rs = stmt.executeQuery("SELECT * FROM injuryplayer_tb");

					for (int i = 0; i < select2 + 1; i++) {
						rs.next();
						playerID = rs.getString("PLAYER_ID");
						playerName = rs.getString("PLAYER_NAME");
						playerAge = rs.getString("PLAYER_AGE");
						playerFrom = rs.getString("PLAYER_FROM");
						playerPosition = rs.getString("PLAYER_POSITION");
						playerBackNumber = rs.getString("PLAYER_BACKNUMBER");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				try {
					sql = "DELETE FROM injuryplayer_tb\r\n" + "WHERE PLAYER_ID = " + playerID + "";
					stmt.executeUpdate(sql);

					sql = "INSERT INTO player_tb\r\n"
							+ "(PLAYER_ID, PLAYER_NAME, PLAYER_AGE, PLAYER_FROM, PLAYER_POSITION, PLAYER_BACKNUMBER)\r\n"
							+ "VALUES(" + playerID + ", '" + playerName + "', " + playerAge + ", '" + playerFrom
							+ "', '" + playerPosition + "', " + playerBackNumber + ")";
					stmt.executeUpdate(sql);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(this, "부상 선수 삭제 되었습니다.\n(새로고침 버튼을 눌러주세요)");

			} else if (select2 < 0) {
				JOptionPane.showMessageDialog(null, "부상 선수 명단에서 선수를 선택하세요", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}
	}

}