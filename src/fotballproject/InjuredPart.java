package fotballproject;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class InjuredPart extends JFrame implements ActionListener {
	private JButton btnInsert;
	private int x;
	private JComboBox comboBox;
	
	public InjuredPart(String title) {
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 250);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblLine = new JLabel("");
		lblLine.setBounds(12, 86, 312, 117);
		getContentPane().add(lblLine);
		
		String[] part = {"햄스트링","전방 십자인대","후방 십자인대","발목인대","발가락","정강이","어깨","허리","기타"};
		
		comboBox = new JComboBox(part);
		comboBox.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		comboBox.setBounds(105, 137, 111, 23);
		getContentPane().add(comboBox);
		
		JLabel lblText = new JLabel("부상 부위를 선택하세요.");
		lblText.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblText.setBounds(87, 104, 163, 23);
		getContentPane().add(lblText);
		
		btnInsert = new JButton("입력");
		btnInsert.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnInsert.setBounds(116, 170, 91, 23);
		getContentPane().add(btnInsert);
		btnInsert.addActionListener(this);
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(InjuredPart.class.getResource("/fotballproject/MancityLogo.png")));
		lblLogo.setBounds(121, 4, 80, 80);
		getContentPane().add(lblLogo);
		
		TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.BLACK,1));
		lblLine.setBorder(titledBorder);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new InjuredPart("부상 부위 선택");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		x = comboBox.getSelectedIndex();
		if(obj == btnInsert && x == 0) {
			
		} else if(obj == btnInsert && x == 1) {
			
		} else if(obj == btnInsert && x == 2) {
			
		} else if(obj == btnInsert && x == 3) {
			
		} else if(obj == btnInsert && x == 4) {
			
		} else if(obj == btnInsert && x == 5) {
			
		} else if(obj == btnInsert && x == 6) {
			
		} else if(obj == btnInsert && x == 7) {
			
		} else if(obj == btnInsert && x == 8) {
			JOptionPane aa = new JOptionPane();
			String injuredEtc = aa.showInputDialog("부상 부위를 입력하세요.");
		}	
	}	
}
