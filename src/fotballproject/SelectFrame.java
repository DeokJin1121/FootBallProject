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
	private JTextField textField;
	private JTextField textField_1;

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

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(401, 21, 192, 234);
		contentPane.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(197, 40, 192, 41);
		contentPane.add(comboBox);

		textField = new JTextField();
		textField.setBounds(197, 165, 192, 41);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(197, 105, 192, 41);
		contentPane.add(textField_1);

		JButton btnNewButton = new JButton("SELECT");
		btnNewButton.setBackground(new Color(153, 204, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(163, 232, 91, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1.setBounds(83, 53, 50, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("POSITION");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(68, 118, 84, 15);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("BACKNUMBER");
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(52, 178, 120, 15);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblLogo = new JLabel("New label");
		lblLogo.setBounds(0, 0, 71, 71);
		contentPane.add(lblLogo);
		ImageIcon daicon1 = new ImageIcon("image/mancity5.png");
		Image daimage1 = daicon1.getImage();
		Image daimage3 = daimage1.getScaledInstance(71, 71, Image.SCALE_SMOOTH);
		ImageIcon daicon3 = new ImageIcon(daimage3);
		lblLogo.setIcon(daicon3);
	}
}
