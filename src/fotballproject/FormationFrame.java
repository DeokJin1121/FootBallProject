package fotballproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class FormationFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public FormationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 1100, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(12, 10, 143, 136);
		contentPane.add(lblLogo);
		
		ImageIcon daicon1 = new ImageIcon("image/mancity6.png");
		Image daimage1 = daicon1.getImage();
		Image daimage3 = daimage1.getScaledInstance(130,120 , Image.SCALE_SMOOTH);
		ImageIcon daicon3 = new ImageIcon(daimage3);
		lblLogo.setIcon(daicon3);
		
		JLabel lblNewLabel_1 = new JLabel("<html><body><center>MANCHESTER CITY<br>PLAYER MANAGEMENT<br>PROGRAM</center></body></html>");
		lblNewLabel_1.setFont(new Font("Goudy Stout", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(167, 25, 397, 104);
		contentPane.add(lblNewLabel_1);
		
		JLabel labelFomation = new JLabel("");
		labelFomation.setBounds(22, 146, 527, 707);
		contentPane.add(labelFomation);
		
		ImageIcon daicon = new ImageIcon("image/fomation2.png");
		Image daimage = daicon.getImage();
		Image daimage2 = daimage.getScaledInstance(440 ,707, Image.SCALE_SMOOTH);
		ImageIcon daicon2 = new ImageIcon(daimage2);
		labelFomation.setIcon(daicon2);
	}
}
