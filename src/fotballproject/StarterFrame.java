package fotballproject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StarterFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton[] buttons;
	private JPanel panel2;
	private String[] dotw;
	private JLabel memoday;
	private JTextField tf;
	private JButton memosave;
	private JButton memodelete;
	private Calendar calendar;
	private int year;
	private int month;
	private JButton day;
	private JButton beforeButton;
	private JButton afterButton;
	private JButton clickday;
	private JPanel Edgepanel2;
	private JPanel panCenter;
	private JPanel Edgepanel;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public StarterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setBackground(new Color(0xEDEDED));
			panel2.add(buttons[i]);
			buttons[i].addActionListener(this);

			if (i < 7) 
			{
				buttons[i].setText(dotw[i]);
				buttons[i].setFont(new Font("monospaced", Font.BOLD, 16));
				panel2.add(buttons[i]);

				if (buttons[i] == buttons[0]) {
					buttons[i].setForeground(Color.RED); // '일요일'의 색을 빨간색으로 지정
				}

				if (buttons[i] == buttons[6]) {
					buttons[i].setForeground(Color.BLUE); // '토요일'의 색을 파란색으로 지정
				}
			} 
			
			else 
			{
				buttons[i].setFont(new Font("monospaced", Font.PLAIN, 14));

				if (i % 7 == 6) // 토요일
				{
					buttons[i].setForeground(Color.BLUE);

				}
				else if (i % 7 == 0) // 일요일
				{
					buttons[i].setForeground(Color.RED);

				}
			}
		}
		
		calSet();
			
		for (int i = 0; i < buttons.length; i++) {
			if ( buttons[i].getText().equals("")) {
				buttons[i].setEnabled(false);
			} else
				buttons[i].setEnabled(true);
		}
		
		Edgepanel.add(panel2);
		add(panCenter);
//메모장 버튼 및 레이블 ---------------------------------------------------		
		memoday = new JLabel();
		memoday.setBounds(10, 10, 200, 30);
		Edgepanel2.add(memoday);
				
		tf = new JTextField();
		tf.setBounds(10, 50, 415, 270);
		Edgepanel2.add(tf);			
			
		memosave = new JButton("메모 저장");
		memosave.setBounds(110, 360, 90, 30);
		memosave.addActionListener(this);
		memosave.setBackground(Color.LIGHT_GRAY);
		Edgepanel2.add(memosave);	
		
		memodelete = new JButton("메모 삭제");
		memodelete.setBounds(240, 360, 90, 30);
		memodelete.addActionListener(this);
		memodelete.setBackground(Color.LIGHT_GRAY);
		Edgepanel2.add(memodelete);	
			
		setVisible(true);
	}

	
	// 달력 값을 관리하는 기본 메소드
	private void calManage() {
		calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
	}

	// 달력의 값을 변경하는 메소드
	private void calUpdate() {
		for (int i = 7; i < buttons.length; i++) // 요일의 값은 그대로 두고 일자의 값만 바꿔야 하기 때문에 초기값을 7로 설정
		{
			buttons[i].setText(""); // 달력의 값을 지움
		}

		calSet(); // 달력의 값을 다시 등록
		day.setText("  " + year + "년 " + month + "월 구단 일정  ");
	}

	// 달력의 연도를 바꾸는 메소드
	private void calChange() {
		if (month <= 0)
		{
			month = 12;
			year--;
		} 
		else if (month >= 13) 
		{
			month = 1;
			year++;
		}
	}

	// 달력에 날짜를 등록하는 메소드
	private void calSet() {
		calendar.set(year, month - 1, 1);
		int firstDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		for (int i = 1; i <= calendar.getActualMaximum(Calendar.DATE); i++) { // getActualMaximum = 그 달의 값을 얻어옴				
			{
				buttons[6 + firstDay + i].setText(Integer.toString(i));
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
				
		if (obj == beforeButton) {
			month -= 1;
			calChange();
			calUpdate();
			for (int i = 0; i < buttons.length; i++) {
				if ( buttons[i].getText().equals("")) {
					buttons[i].setEnabled(false);
				} else
					buttons[i].setEnabled(true);
			}

		}
		if (obj == afterButton) {
			month += 1;
			calChange();
			calUpdate();
			for (int i = 0; i < buttons.length; i++) {
				if ( buttons[i].getText().equals("")) {
					buttons[i].setEnabled(false);
				} else
					buttons[i].setEnabled(true);
			}
		} 
        
 //메모 바탕화면에 저장 ------------------------------------------------				
		if ( obj == memosave) {
				//날짜 선택 안할 경우
				if( clickday == null) {
					JOptionPane.showMessageDialog(this, "날짜를 선택해주세요.");
					return;
				//메모장이 빈 칸일 경우
				} else if (tf.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "메모를 입력해주세요.");
					return;
				}
			
				String text = ""+tf.getText()+"";
				String fileNm = "C:\\Users\\mycom\\Desktop\\" + month +"월"+ clickday +"일 일정.txt";
				
				
				FileWriter fileWrite;
				try {
					File file = new File(fileNm);
					fileWrite = new FileWriter(file);
										
					fileWrite.write(text);
					fileWrite.flush(); 
					fileWrite.close();
					JOptionPane.showMessageDialog(this, "메모가 저장되었습니다.");
					fileWrite.close();
				} catch (IOException e1) {
					System.out.println("오류");
					e1.printStackTrace();
				}

			} else if ( obj == memodelete) {
				//날짜 선택 안할 경우
				if( clickday == null) {
					JOptionPane.showMessageDialog(this, "날짜를 선택해주세요.");
					return;																
				}
				
				String fileNm = "C:\\Users\\mycom\\Desktop\\" + month +"월"+ clickday +"일 일정.txt";
				File file = new File(fileNm);
				
				if( file.exists() ){ //파일존재여부확인	    			
		    		if(file.delete()){
		    			if(JOptionPane.showConfirmDialog(this, "메모를 삭제하시겠습니까?", "삭제", 
		    					JOptionPane.YES_NO_OPTION, 
		    					JOptionPane.WARNING_MESSAGE)== JOptionPane.YES_OPTION ) {
		    				JOptionPane.showMessageDialog(this, "메모가 삭제되었습니다.");
		    			}
		    			tf.setText("");
		    		}else{
		    			System.out.println("파일삭제 실패");
		    		}	    		
		    	} else{
		    		JOptionPane.showMessageDialog(this, "저장된 메모가 없습니다.");
		    	}
				
			}
	}
	}


