package fotballproject;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;

public class StarterFrame extends JFrame {

	private JPanel contentPane;

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

	public StarterFrame() {
		setTitle("선발/후보 선수 관리");
		setBounds(100, 100, 967, 830);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 로고 -------------------------------------------------------------------------- 
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setBounds(0, 2, 135, 125);
		contentPane.add(lblLogo);
		
		ImageIcon daicon = new ImageIcon("image/mancity6.png");
		Image daimage = daicon.getImage();
		Image daimage2 = daimage.getScaledInstance(100 ,90, Image.SCALE_SMOOTH);
		lblLogo.setIcon(daicon);
		// 로고 -------------------------------------------------------------------------- 
		
		// 로고2 ------------------------------------------------------------------------- 
		JLabel lblLogo2 = new JLabel("<html><body><center>MANCHESTER CITY<br>PLAYER MANAGEMENT<br>PROGRAM</center></body></html>");
		lblLogo2.setFont(new Font("Goudy Stout", Font.PLAIN, 16));
		lblLogo2.setBounds(155, 20, 342, 103);
		contentPane.add(lblLogo2);
		// 로고2 ------------------------------------------------------------------------- 
		
		// 선발 선수 패널 ----------------------------------------------------------------
		JPanel starterPanel = new JPanel();
		TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.BLACK,1), "선발 선수");
		titledBorder.setTitleFont(new Font("Decodig", Font.PLAIN, 20));
		starterPanel.setBackground(new Color(255, 255, 255));
		starterPanel.setBounds(28, 133, 429, 600);
		starterPanel.setBorder(titledBorder);
		
		contentPane.add(starterPanel);
		
		DB db = new DB();
		
		
		
		// 후보 선수 패널 ----------------------------------------------------------------
		JPanel subPanel = new JPanel();
		TitledBorder titledBorder2 = new TitledBorder(new LineBorder(Color.BLACK,1), "후보 선수");
		titledBorder2.setTitleFont(new Font("Decodig", Font.PLAIN, 20));
		subPanel.setBackground(Color.WHITE);
		subPanel.setBounds(485, 133, 429, 600);
		subPanel.setBorder(titledBorder2);
		
		contentPane.add(subPanel);
		
		JButton btnNewButton = new JButton("교체");
		btnNewButton.setBounds(414, 743, 112, 40);
		contentPane.add(btnNewButton);
		
	}
}
