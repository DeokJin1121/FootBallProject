package fotballproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

public class SelectFrame extends JFrame {

	private JPanel contentPane;
	private JTextField taBackNum;
	private JTextField taPositon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectFrame frame = new SelectFrame();
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
	public SelectFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 302);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel playerImage = new JLabel("");
		playerImage.setBounds(401, 12, 192, 240);
		contentPane.add(playerImage);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(190, 40, 192, 41);
		contentPane.add(comboBox);

		taBackNum = new JTextField();
		taBackNum.setBounds(190, 165, 192, 41);
		contentPane.add(taBackNum);
		taBackNum.setColumns(10);

		taPositon = new JTextField();
		taPositon.setColumns(10);
		taPositon.setBounds(190, 105, 192, 41);
		contentPane.add(taPositon);

		JButton btnSelect = new JButton("SELECT");
		btnSelect.setBackground(new Color(153, 204, 255));
		btnSelect.setForeground(new Color(0, 0, 0));
		btnSelect.setBounds(163, 232, 91, 23);
		contentPane.add(btnSelect);

		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblName.setBounds(83, 53, 50, 15);
		contentPane.add(lblName);

		JLabel lblPositon = new JLabel("POSITION");
		lblPositon.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPositon.setBounds(68, 118, 84, 15);
		contentPane.add(lblPositon);

		JLabel lblBackNum = new JLabel("BACKNUMBER");
		lblBackNum.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblBackNum.setBounds(52, 178, 120, 15);
		contentPane.add(lblBackNum);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 0, 68, 68);
		contentPane.add(lblLogo);
		
		ImageIcon daicon1 = new ImageIcon("image/mancity5.png");
		Image daimage1 = daicon1.getImage();
		Image daimage3 = daimage1.getScaledInstance(71, 71, Image.SCALE_SMOOTH);
		ImageIcon daicon3 = new ImageIcon(daimage3);
		lblLogo.setIcon(new ImageIcon(SelectFrame.class.getResource("/fotballproject/MancityLogoSelect.png")));
	}
}
