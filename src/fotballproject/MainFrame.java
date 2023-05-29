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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {
	
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 610, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-13, 0, 121, 96);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><body><center>MANCHESTER CITY<br>PLAYER MANAGEMENT<br>PROGRAM</center></body></html>");
		lblNewLabel_1.setFont(new Font("Goudy Stout", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(146, 23, 337, 85);
		contentPane.add(lblNewLabel_1);
		
		JButton btnSelect = new JButton("선수 검색");
		btnSelect.setBackground(new Color(153, 204, 255));
		btnSelect.setBounds(95, 126, 415, 43);
		contentPane.add(btnSelect);
		
		JButton btnStarter = new JButton("선발 선수 관리");
		btnStarter.setBackground(new Color(153, 204, 255));
		btnStarter.setBounds(95, 194, 415, 43);
		contentPane.add(btnStarter);
		
		JButton btnInjury = new JButton("부상자 관리");
		btnInjury.setBackground(new Color(153, 204, 255));
		btnInjury.setBounds(95, 263, 415, 43);
		contentPane.add(btnInjury);
		
		JButton btnFormation = new JButton("포메이션");
		btnFormation.setBackground(new Color(153, 204, 255));
		btnFormation.setBounds(95, 332, 415, 43);
		contentPane.add(btnFormation);
		
		JButton btnSchedule = new JButton("구단 일정");
		btnSchedule.setBackground(new Color(153, 204, 255));
		btnSchedule.setBounds(95, 400, 415, 43);
		contentPane.add(btnSchedule);
		
		JButton btnStadium = new JButton("경기장");
		btnStadium.setBackground(new Color(153, 204, 255));
		btnStadium.setBounds(95, 467, 415, 43);
		contentPane.add(btnStadium);
	}
}
