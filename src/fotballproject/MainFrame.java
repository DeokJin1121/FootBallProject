package fotballproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.desktop.ScreenSleepEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fotballproject.FillThread;
import fotballproject.LoadingLabel;

public class MainFrame extends JFrame implements ActionListener, Runnable {

	private JPanel contentPane;
	private JButton btnSelect;
	private JButton btnStarter;
	private SelectFrame selectframe;
	private StarterFrame starterframe;
	private JButton btnInjury;
	private InjuryFrame injuryframe;
	private JButton btnFormation;
	private FormationFrame btnformation;
	private JButton btnSchedule;
	private ScheduleFrame scheduleframe;
	private JButton btnStadium;
	private Stadium stadiumframe;
	private int n;
	private JPanel panLoad;
	private LoadingLabel bar;
	private JLabel lblBall;
	private Thread th;
	private JLabel lblLogo1;
	private JLabel Hol;
	private JLabel Deb;

	public MainFrame() {
		setTitle("메인");
		setBounds(550, 200, 610, 580);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		panLoad = new JPanel();
		panLoad.setLayout(null);
		setContentPane(panLoad);
		panLoad.setBackground(Color.WHITE);

//-------------------------------------------------------------------------------------------------      

		bar = new LoadingLabel(100);
		bar.setBackground(new Color(153, 204, 255)); // 라벨의 배경색을 넣어도 안보이는 이유 => 투명도
		bar.setOpaque(true); // setOpaque(true);로 불투명하게 만들어야 함.
		bar.setBounds(57, 395, 480, 20); // 200
		getContentPane().add(bar);

		JLabel lblText = new JLabel("  로딩중입니다... 잠시 기다려 주세요...");
		lblText.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblText.setBounds(145, 450, 292, 39); // 200
		getContentPane().add(lblText);

		FillThread ct = new FillThread(bar); // FillThread 클래스에서 bar을 받을 수 있도록 보내기

		Hol = new JLabel();
		Hol.setIcon(new ImageIcon("Players/홀란슛.png"));
		Hol.setBounds(64, 102, 110, 160);
		getContentPane().add(Hol);

		Deb = new JLabel();
		Deb.setIcon(new ImageIcon("Players/덕배슛.png"));
		Deb.setBounds(400, 102, 110, 160);
		getContentPane().add(Deb);

		lblLogo1 = new JLabel("");
		lblLogo1.setIcon(new ImageIcon(MainFrame.class.getResource("/fotballproject/MancityLogoSelect.png")));
		lblLogo1.setOpaque(true);
		lblLogo1.setBounds(260, 60, 70, 70); // 100
		getContentPane().add(lblLogo1);

		lblBall = new JLabel("");
		lblBall.setIcon(new ImageIcon(MainFrame.class.getResource("/fotballproject/ball.png")));
		lblBall.setOpaque(true);
		lblBall.setBounds(38, 372, 45, 45); // 100
		getContentPane().add(lblBall);

//-------------------------------------------------------------------------------------------------      
		ct.start();

		contentPane.setLayout(null);
		// ----------------------------------------------------------------------------로고
		JLabel lblLogo = new JLabel();
		lblLogo.setBounds(10, 0, 121, 96);
		contentPane.add(lblLogo);
		ImageIcon daicon1 = new ImageIcon("image/mancity5.png");
		Image daimage1 = daicon1.getImage();
		Image daimage3 = daimage1.getScaledInstance(71, 71, Image.SCALE_SMOOTH);
		ImageIcon daicon3 = new ImageIcon(daimage3);
		lblLogo.setIcon(daicon3);

		JLabel lblText1 = new JLabel(
				"<html><body><center>MANCHESTER CITY<br>PLAYER MANAGEMENT<br>PROGRAM</center></body></html>");
		lblText1.setFont(new Font("Goudy Stout", Font.PLAIN, 16));
		lblText1.setBounds(146, 23, 350, 85);
		contentPane.add(lblText1);
		// -------------------------------------------------------------------------------------로고

		// ----------------------------------------------------------------------------------------버튼
		btnSelect = new JButton("선수 검색");
		btnSelect.addActionListener(this);
		btnSelect.setBackground(new Color(153, 204, 255));
		btnSelect.setBounds(95, 126, 415, 43);
		contentPane.add(btnSelect);

		btnStarter = new JButton("선발 선수 관리");
		btnStarter.addActionListener(this);
		btnStarter.setBackground(new Color(153, 204, 255));
		btnStarter.setBounds(95, 194, 415, 43);
		contentPane.add(btnStarter);

		btnInjury = new JButton("부상자 관리");
		btnInjury.addActionListener(this);
		btnInjury.setBackground(new Color(153, 204, 255));
		btnInjury.setBounds(95, 263, 415, 43);
		contentPane.add(btnInjury);

		btnFormation = new JButton("포메이션");
		btnFormation.addActionListener(this);
		btnFormation.setBackground(new Color(153, 204, 255));
		btnFormation.setBounds(95, 332, 415, 43);
		contentPane.add(btnFormation);

		btnSchedule = new JButton("구단 일정");
		btnSchedule.addActionListener(this);
		btnSchedule.setBackground(new Color(153, 204, 255));
		btnSchedule.setBounds(95, 400, 415, 43);
		contentPane.add(btnSchedule);

		btnStadium = new JButton("경기장");
		btnStadium.addActionListener(this);
		btnStadium.setBackground(new Color(153, 204, 255));
		btnStadium.setBounds(95, 467, 415, 43);
		contentPane.add(btnStadium);

		th = new Thread(this); // th 가 run을 수행할 수 있는 start 능력을 가지게 됨
		th.start();

		setVisible(true);
		// --------------------------------------------------------------------------------------
		// 버튼
	}

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
	}

	@Override
	public void run() {
		Random rnd = new Random();
		int n = 0;
		while (true) {
			int x = getX() + rnd.nextInt() % 90 - 285; // 나머지를 구하기 때문에 rnd가 얼마든 -4 ~ 4 의 값이 나옴
			int y = getY() + rnd.nextInt() % 7;
			lblBall.setLocation(x, y);

			n++;
			try {
				Thread.sleep(100); // sleep은 try catch로 묶어줘야 함
			} catch (InterruptedException e) {
				return;
			}
			if (n == 47) {
				setContentPane(contentPane);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == btnSelect) {
			selectframe = new SelectFrame();
			selectframe.setVisible(true);
		} else if (obj == btnStarter) {
			starterframe = new StarterFrame();
			starterframe.setVisible(true);
		} else if (obj == btnInjury) {
			injuryframe = new InjuryFrame();
			injuryframe.setVisible(true);
		} else if (obj == btnFormation) {
			btnformation = new FormationFrame();
			btnformation.setVisible(true);
		} else if (obj == btnSchedule) {
			scheduleframe = new ScheduleFrame(getTitle());
		} else if (obj == btnStadium) {
			stadiumframe = new Stadium();
		}
	}
}