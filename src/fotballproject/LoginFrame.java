package fotballproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Color;

public class LoginFrame extends JFrame {

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
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(27, 112, 397, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(27, 179, 397, 32);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("접속");
		btnNewButton.setBackground(new Color(153, 204, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(89, 221, 114, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("종료");
		btnNewButton_1.setBackground(new Color(153, 204, 255));
		btnNewButton_1.setBounds(234, 221, 114, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("PW");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel.setBounds(27, 154, 50, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("굴림", Font.BOLD, 14));
		lblId.setBounds(31, 78, 50, 24);
		contentPane.add(lblId);
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(177, 10, 84, 92);
		contentPane.add(lblLogo);
		ImageIcon daicon1 = new ImageIcon("image/mancity5.png");
		Image daimage1 = daicon1.getImage();
		Image daimage3 = daimage1.getScaledInstance(71, 71, Image.SCALE_SMOOTH);
		ImageIcon daicon3 = new ImageIcon(daimage3);
		lblLogo.setIcon(daicon3);
		
	}
}
