package fotballproject;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.Constants;

import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class InjuredPart extends JFrame implements ActionListener {
	private JButton btnInsert;
	private int x;
	private JComboBox comboBox;
	int selectnum;
	private String sql;

	public static Statement stmt;
	public static Connection conn;

	private ResultSet rs;
	String injuryarea;
	private String PLAYER_ID;
	private String PLAYER_NAME;
	private String PLAYER_AGE;
	private String PLAYER_FROM;
	private String PLAYER_POSITION;
	private String PLAYER_BACKNUMBER;
	private String INJURYPLAYER_ID;
	private String INJURYPLAYER_NAME;
	private String INJURYPLAYER_AGE;
	private String INJURYPLAYER_FROM;
	private String INJURYPLAYER_POSITION;
	private String INJURYPLAYER_BACKNUMBER;
	private Vector<String> data;
	private String INJURYPLAYER_INJUREDPART;
	private JTable injuryPlayerTb;
	private Vector<String> data2;
	private JTable PlayerTb;

	public InjuredPart(int select) {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("부상 부위 선택");
		setSize(350, 250);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		setResizable(false);

		// DB 연결
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/footballprojectdb", "root", "1234");

			stmt = conn.createStatement();

//	         System.out.println("OK");

		} catch (ClassNotFoundException e) {
			System.out.println("해당 드라이버가 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("접속 오류 / SQL 오류");
			e.printStackTrace();
		}

		// 부상자 테이블
		Vector<String> vectorTitle = new Vector<String>(); // 헤더값

		vectorTitle.addElement("선수 코드");
		vectorTitle.addElement("이름");
		vectorTitle.addElement("나이");
		vectorTitle.addElement("포지션");
		vectorTitle.addElement("부상 부위");

		DefaultTableModel model = new DefaultTableModel(vectorTitle, 0) { // 테이블의 데이터 변경하려면 모델 사용
			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};

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

		// 선수 테이블
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 테이블
		PlayerTb = new JTable(model2); // 데이터 변경 시 테이블에 직접 접근하지 않고 변경
		PlayerTb.getTableHeader().setReorderingAllowed(false); // 테이블 컬럼의 이동을 방지
		PlayerTb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 테이블 로우를 한개만 선택 가능

		JLabel lblLine = new JLabel("");
		lblLine.setBounds(12, 86, 312, 117);
		getContentPane().add(lblLine);

		String[] injuryarea = { "햄스트링", "전방 십자인대", "후방 십자인대", "발목인대", "발가락", "정강이", "어깨", "허리", "기타" };

		comboBox = new JComboBox(injuryarea);
		comboBox.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		comboBox.setBounds(105, 137, 111, 23);
		getContentPane().add(comboBox);

		JLabel lblText = new JLabel("부상 부위를 선택하세요.");
		lblText.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblText.setBounds(87, 104, 163, 23);
		getContentPane().add(lblText);

		btnInsert = new JButton("입력");
		btnInsert.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnInsert.setBounds(116, 170, 91, 23);
		getContentPane().add(btnInsert);
		btnInsert.addActionListener(this);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(InjuredPart.class.getResource("/fotballproject/MancityLogo.png")));
		lblLogo.setBounds(121, 4, 80, 80);
		getContentPane().add(lblLogo);

		TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.BLACK, 1));
		lblLine.setBorder(titledBorder);

		setVisible(true);
		selectnum = select; // select 변수에 담긴 값을 사용하기 위해 selectnum에 저장
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		String MainID = null;
		String MainName = null;
		String MainAge = null;
		String MainFrom = null;
		String MainPosition = null;
		String MainBackNumber = null;
		String injuryarea = null;

		// 부상 선수 추가
		if (obj == btnInsert) {
			try {
				rs = stmt.executeQuery("SELECT * FROM player_tb");
				for (int i = 0; i < selectnum + 1; i++) {

					rs.next();
					MainID = rs.getString("PLAYER_ID");
					MainName = rs.getString("PLAYER_NAME");
					MainAge = rs.getString("PLAYER_AGE");
					MainFrom = rs.getString("PLAYER_FROM");
					MainPosition = rs.getString("PLAYER_POSITION");
					MainBackNumber = rs.getString("PLAYER_BACKNUMBER");
				}

				injuryarea = comboBox.getSelectedItem().toString();

				sql = "INSERT INTO injuryplayer_tb\r\n"
						+ "(PLAYER_ID, PLAYER_NAME, PLAYER_AGE, PLAYER_FROM, PLAYER_POSITION, PLAYER_BACKNUMBER, INJURYPLAYER_INJUREDPART)\r\n"
						+ "VALUES(" + MainID + ", '" + MainName + "', " + MainAge + ",  '" + MainFrom + "', '"
						+ MainPosition + "', " + MainBackNumber + ", '" + injuryarea + "')";
				stmt.executeUpdate(sql);

				sql = "DELETE FROM player_tb\r\n" + "WHERE PLAYER_ID = " + MainID + "";
				stmt.executeUpdate(sql);

				// 테이블 새로고침
				DefaultTableModel playerModel = (DefaultTableModel) PlayerTb.getModel();
				playerModel.setRowCount(0); // 기존 행 모두 제거

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
						playerModel.addRow(new Object[] { PLAYER_ID, PLAYER_NAME, PLAYER_AGE, PLAYER_FROM,
								PLAYER_POSITION, PLAYER_BACKNUMBER });

					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

				DefaultTableModel injuryPlayerModel = (DefaultTableModel) injuryPlayerTb.getModel();
				injuryPlayerModel.setRowCount(0); // 기존 행 모두 제거

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
						INJURYPLAYER_INJUREDPART = rs.getString(7);
						injuryPlayerModel.addRow(
								new Object[] { INJURYPLAYER_ID, INJURYPLAYER_NAME, INJURYPLAYER_AGE, INJURYPLAYER_FROM,
										INJURYPLAYER_POSITION, INJURYPLAYER_BACKNUMBER, INJURYPLAYER_INJUREDPART });
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

				JOptionPane.showMessageDialog(this, "부상 선수가 추가 되었습니다.\n(새로고침 버튼을 눌러주세요)");

				dispose();

				new InjuryFrame();

			} catch (SQLException e1) {
				System.out.println("접속 오류 / SQL 오류");
				e1.printStackTrace();
			}
		}
	}
}