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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame implements ActionListener {
	
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
	

	

	public MainFrame() {
		setBounds(550, 200, 610, 580);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
        //----------------------------------------------------------------------------로고		
		JLabel lblLogo = new JLabel();
		lblLogo.setBounds(10, 0, 121, 96);
		contentPane.add(lblLogo);
		ImageIcon daicon1 = new ImageIcon("image/mancity5.png");
		Image daimage1 = daicon1.getImage();
		Image daimage3 = daimage1.getScaledInstance(71, 71, Image.SCALE_SMOOTH);
		ImageIcon daicon3 = new ImageIcon(daimage3);
		lblLogo.setIcon(daicon3);
		
		JLabel lblNewLabel_1 = new JLabel("<html><body><center>MANCHESTER CITY<br>PLAYER MANAGEMENT<br>PROGRAM</center></body></html>");
		lblNewLabel_1.setFont(new Font("Goudy Stout", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(146, 23, 350, 85);
		contentPane.add(lblNewLabel_1);
		//-------------------------------------------------------------------------------------로고
		
		//----------------------------------------------------------------------------------------버튼
		btnSelect = new JButton("선수 검색");
		btnSelect.addActionListener(this);
		btnSelect.setBackground(new Color(153, 204, 255));
		btnSelect.setBounds(95, 126, 415, 43);
		contentPane.add(btnSelect);
		
		btnStarter = new JButton("선발 선수 관리");
		btnStarter .addActionListener(this);
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
		
		setVisible(true);
		//-------------------------------------------------------------------------------------- 버튼
	}
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		
		if (obj == btnSelect) {
			 selectframe = new SelectFrame();
			 selectframe.setVisible(true);
		}else if (obj == btnStarter) {
			 starterframe = new StarterFrame();
			 starterframe.setVisible(true);
		}else if (obj == btnInjury ) {
			injuryframe = new InjuryFrame();
			injuryframe.setVisible(true);
		}else if (obj == btnFormation) {
			btnformation = new FormationFrame();
			btnformation.setVisible(true);
		}else if (obj == btnSchedule ) {
			scheduleframe = new ScheduleFrame(getTitle());
		}else if (obj == btnStadium) {
			stadiumframe = new Stadium();
		}
		
	}
}
