package fotballproject;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Stadium extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stadium frame = new Stadium();
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
	public Stadium() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogo = new JLabel("New label");

		lblLogo.setBounds(0, 0, 71, 71);
		contentPane.add(lblLogo);
		ImageIcon daicon1 = new ImageIcon("image/mancity5.png");
		Image daimage1 = daicon1.getImage();
		Image daimage3 = daimage1.getScaledInstance(71, 71, Image.SCALE_SMOOTH);
		ImageIcon daicon3 = new ImageIcon(daimage3);
		lblLogo.setIcon(daicon3);

		JPanel panel = new JPanel();
		panel.setBounds(10, 102, 431, 274);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 386, 429, 79);
		contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(453, 102, 95, 363);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(12, 5, 71, 53);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(12, 68, 71, 15);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(12, 87, 71, 53);
		panel_2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setBounds(12, 144, 71, 15);
		panel_2.add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1.setBounds(12, 162, 71, 53);
		panel_2.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1.setBounds(12, 212, 71, 15);
		panel_2.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1_1.setBounds(12, 237, 71, 53);
		panel_2.add(lblNewLabel_1_1_1_1);
	}
}
