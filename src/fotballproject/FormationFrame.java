package fotballproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;

public class FormationFrame extends JFrame {

	private JPanel contentPane;

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
		setBounds(300, 50, 967, 830);
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
		Image daimage3 = daimage1.getScaledInstance(130,120 , Image.SCALE_SMOOTH);
		ImageIcon daicon3 = new ImageIcon(daimage3);
		lblLogo.setIcon(daicon3);
		
		JLabel lblLogo2 = new JLabel("<html><body><center>MANCHESTER CITY<br>PLAYER MANAGEMENT<br>PROGRAM</center></body></html>");
		lblLogo2.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblLogo2.setBounds(145, 10, 330, 103);
		contentPane.add(lblLogo2);
		
		// 포메이션 패널
		JPanel inputPanel = new JPanel();
		TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.BLACK,1), "포메이션");
		titledBorder.setTitleFont(new Font("Decodig", Font.PLAIN, 20));
		inputPanel.setBackground(new Color(255, 255, 255));
		inputPanel.setBounds(32, 123, 429, 660);
		inputPanel.setBorder(titledBorder);
		
		JLabel lblFormation = new JLabel();
		lblFormation.setBounds(12, 33, 400, 572);
		inputPanel.add(lblFormation);
		
		ImageIcon daicon = new ImageIcon("image/fomation5.jpg");
		Image daimage = daicon.getImage();
		Image daimage2 = daimage.getScaledInstance(480 ,754, Image.SCALE_SMOOTH);
		
		lblFormation.setIcon(daicon);
		
		contentPane.add(inputPanel);
		
		inputPanel.setLayout(null);
		
		JButton btnFomation = new JButton("4-2-3-1");
		btnFomation.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnFomation.setBounds(12, 615, 109, 35);
		inputPanel.add(btnFomation);
		
		JButton btnFormation2 = new JButton("4-1-2-3");
		btnFormation2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnFormation2.setBounds(150, 615, 119, 35);
		inputPanel.add(btnFormation2);
		
		JButton btnFomation3 = new JButton("4-2-2-2");
		btnFomation3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnFomation3.setBounds(297, 615, 119, 35);
		inputPanel.add(btnFomation3);
		
		// 선발 선수 테이블 패널
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(null);
		tablePanel.setBackground(Color.WHITE);
		tablePanel.setBounds(488, 123, 429, 660);
		contentPane.add(tablePanel);
		
		TitledBorder titledBorder2 = new TitledBorder(new LineBorder(Color.BLACK, 1), "선발 선수 테이블");
		titledBorder2.setTitleFont(new Font("Decoding", Font.PLAIN, 20));
		tablePanel.setBorder(titledBorder2);
		
	}
}

