package fotballproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

public class Stadium extends JFrame implements ActionListener {
   private JButton btnNext;
   private JButton btnBefore;
   private int i;
   private JLabel lblstadium;
   private ImageIcon[] stadiumImgBin;
   private JTextArea stadiumName;
   private String[] stadiumNameBin;
   private JTextArea stadiumInfo;
   private String[] stadiumInfoBin;
//시발
   //sex섹스
   //제발 푸쉬떠줘
   public Stadium() {
   	getContentPane().setBackground(new Color(255, 255, 255));
      getContentPane().setFont(new Font("맑은 고딕", Font.BOLD, 12));
      setLocation(300,200);
      setSize(631, 592);
      getContentPane().setLayout(null);
      
      int i = 0;
      
      btnBefore = new JButton("이전");
      btnBefore.setBounds(381, 437, 71, 35);
      getContentPane().add(btnBefore);
      btnBefore.addActionListener(this);
      
      btnNext = new JButton("다음");
      btnNext.setBounds(381, 482, 71, 35);
      getContentPane().add(btnNext);
      btnNext.addActionListener(this);
      
      lblstadium = new JLabel("경기장사진");
      ImageIcon ethihadImg = new ImageIcon(Stadium.class.getResource("/fotballproject/에티하드.jpg"));
      ImageIcon anfieldImg = new ImageIcon(Stadium.class.getResource("/fotballproject/안필드.jpg"));
      ImageIcon emirateImg = new ImageIcon(Stadium.class.getResource("/fotballproject/에미레이츠.jpg"));
      ImageIcon traffordImg = new ImageIcon(Stadium.class.getResource("/fotballproject/올드트래포드.jpg"));
      ImageIcon stamfordImg = new ImageIcon(Stadium.class.getResource("/fotballproject/스탬포드.jpg"));
      
      stadiumImgBin = new ImageIcon[5];
      stadiumImgBin[0] = ethihadImg;
      stadiumImgBin[1] = anfieldImg;
      stadiumImgBin[2] = emirateImg;
      stadiumImgBin[3] = traffordImg;
      stadiumImgBin[4] = stamfordImg;
      
      lblstadium.setIcon(stadiumImgBin[i]);
      lblstadium.setBounds(26, 100, 407, 283);
      getContentPane().add(lblstadium);
      
      String ethihadName = "  [에티하드 스타디움]";
      String anfieldName = "  [안필드 스타디움]";
      String emirateName = "  [에미레이츠 스타디움]";
      String traffordName = "  [올드 트래포드]";
      String stamfordName = "  [스탬포드 브릿지]";

      stadiumNameBin = new String[5];
      stadiumNameBin[0] = ethihadName;
      stadiumNameBin[1] = anfieldName;
      stadiumNameBin[2] = emirateName;
      stadiumNameBin[3] = traffordName;
      stadiumNameBin[4] = stamfordName;
      
      stadiumName = new JTextArea();
      stadiumName.setEditable(false);
      stadiumName.setFont(new Font("Monospaced", Font.BOLD, 18));
      stadiumName.setText(stadiumNameBin[i]);
      stadiumName.setBounds(26, 420, 343, 26);
      getContentPane().add(stadiumName);
      
      String ethihadInfo = "  구단 : 맨체스터 시티\r\n  최대 관중인원 : 53400명\r\n  완공 : 2003년 08월 10일";
      String anfieldInfo = "  구단 : 리버풀\r\n  최대 관중인원 : 61000명\r\n  완공 : 1884년 9월 28일";
      String emirateInfo = "  구단 : 아스널\r\n  최대 관중인원 : 60704명\r\n  완공 : 2006년 7월 22일";
      String traffordInfo = "  구단 : 맨체스터 유나이티드\r\n  최대 관중인원 : 74310명\r\n  완공 : 1910년 2월 19일";
      String stamfordInfo = "  구단 : 첼시\r\n  최대 관중인원 : 40341명\r\n  완공 : 1877년 4월 28일";
      
      stadiumInfoBin = new String[5];
      stadiumInfoBin[0] = ethihadInfo;
      stadiumInfoBin[1] = anfieldInfo;
      stadiumInfoBin[2] = emirateInfo;
      stadiumInfoBin[3] = traffordInfo;
      stadiumInfoBin[4] = stamfordInfo;
      
      stadiumInfo = new JTextArea();
      stadiumInfo.setEditable(false);
      stadiumInfo.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
      stadiumInfo.setText(stadiumInfoBin[i]);
      stadiumInfo.setBounds(26, 453, 343, 79);
      getContentPane().add(stadiumInfo);
      
      JLabel lblNewLabel_4_4 = new JLabel("스탬퍼드");
      lblNewLabel_4_4.setBounds(701, 731, 148, 79);
      getContentPane().add(lblNewLabel_4_4);
      
      JLabel lblNewLabel_3 = new JLabel("에티하드 스타디움");
      lblNewLabel_3.setBounds(701, 695, 148, 26);
      getContentPane().add(lblNewLabel_3);
      
      JLabel lblNewLabel_5 = new JLabel("에티하드 스타디움");
      lblNewLabel_5.setBounds(701, 820, 148, 26);
      getContentPane().add(lblNewLabel_5);
      
      JLabel lblNewLabel_4 = new JLabel("에티하드");
      lblNewLabel_4.setIcon(new ImageIcon(Stadium.class.getResource("/fotballproject/축구장.jpg")));
      lblNewLabel_4.setBackground(new Color(0, 128, 0));
      lblNewLabel_4.setBounds(487, 58, 106, 66);
      getContentPane().add(lblNewLabel_4);

      JLabel lblNewLabel = new JLabel("에티하드 스타디움");
      lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 11));
      lblNewLabel.setBounds(494, 125, 106, 15);
      getContentPane().add(lblNewLabel);
      
      JLabel lblNewLabel_4_1 = new JLabel("안필드");
      lblNewLabel_4_1.setIcon(new ImageIcon(Stadium.class.getResource("/fotballproject/축구장.jpg")));
      lblNewLabel_4_1.setForeground(Color.BLACK);
      lblNewLabel_4_1.setBackground(new Color(0, 128, 0));
      lblNewLabel_4_1.setBounds(487, 150, 106, 66);
      getContentPane().add(lblNewLabel_4_1);
      
      JLabel lblNewLabel_1 = new JLabel("안필드 스타디움");
      lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 11));
      lblNewLabel_1.setBounds(497, 217, 88, 15);
      getContentPane().add(lblNewLabel_1);
      
      JLabel lblNewLabel_4_1_1 = new JLabel("에미레이트");
      lblNewLabel_4_1_1.setIcon(new ImageIcon(Stadium.class.getResource("/fotballproject/축구장.jpg")));
      lblNewLabel_4_1_1.setForeground(Color.BLACK);
      lblNewLabel_4_1_1.setBounds(487, 242, 106, 66);
      getContentPane().add(lblNewLabel_4_1_1);
      
      JLabel lblNewLabel_1_1 = new JLabel("에미레이트 스타디움");
      lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 11));
      lblNewLabel_1_1.setBounds(487, 312, 106, 15);
      getContentPane().add(lblNewLabel_1_1);
      
      JLabel lblNewLabel_4_1_1_1 = new JLabel("트래포드");
      lblNewLabel_4_1_1_1.setIcon(new ImageIcon(Stadium.class.getResource("/fotballproject/축구장.jpg")));
      lblNewLabel_4_1_1_1.setForeground(Color.BLACK);
      lblNewLabel_4_1_1_1.setBounds(487, 334, 106, 66);
      getContentPane().add(lblNewLabel_4_1_1_1);
      
      JLabel lblNewLabel_1_1_1 = new JLabel("올드 트래포드");
      lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 11));
      lblNewLabel_1_1_1.setBounds(506, 399, 81, 15);
      getContentPane().add(lblNewLabel_1_1_1);
      
      JLabel lblNewLabel_4_1_1_2 = new JLabel("스탬퍼드");
      lblNewLabel_4_1_1_2.setIcon(new ImageIcon(Stadium.class.getResource("/fotballproject/축구장.jpg")));
      lblNewLabel_4_1_1_2.setForeground(Color.BLACK);
      lblNewLabel_4_1_1_2.setBounds(487, 426, 106, 66);
      getContentPane().add(lblNewLabel_4_1_1_2);
      
      JLabel lblNewLabel_1_1_2 = new JLabel("스탬퍼드 브리지");
      lblNewLabel_1_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 11));
      lblNewLabel_1_1_2.setBounds(498, 496, 88, 15);
      getContentPane().add(lblNewLabel_1_1_2);
      
      JLabel lblNewLabel_2 = new JLabel("New label");
      lblNewLabel_2.setIcon(new ImageIcon(Stadium.class.getResource("/fotballproject/MancityLogo.png")));
      lblNewLabel_2.setBounds(26, 10, 81, 80);
      getContentPane().add(lblNewLabel_2);
      
      JLabel lblNewLabel_6 = new JLabel("MANCHESTER CITY");
      lblNewLabel_6.setFont(new Font("Goudy Stout", Font.PLAIN, 12));
      lblNewLabel_6.setBounds(136, 30, 215, 15);
      getContentPane().add(lblNewLabel_6);
      
      JLabel lblNewLabel_6_1 = new JLabel("PLAYER MANAGEMENT");
      lblNewLabel_6_1.setFont(new Font("Goudy Stout", Font.PLAIN, 12));
      lblNewLabel_6_1.setBounds(119, 43, 268, 15);
      getContentPane().add(lblNewLabel_6_1);
      
      JLabel lblNewLabel_6_2 = new JLabel("PROGRAM");
      lblNewLabel_6_2.setFont(new Font("Goudy Stout", Font.PLAIN, 12));
      lblNewLabel_6_2.setBounds(189, 56, 120, 15);
      getContentPane().add(lblNewLabel_6_2);
      
      setVisible(true);
   }
   
      public static void main(String[] args) {
         new Stadium();
   }
      
      @Override
      public void actionPerformed(ActionEvent e) {
         Object obj = e.getSource();
         if (obj == btnBefore && i>0) {
            i--;
            lblstadium.setIcon(stadiumImgBin[i]);
            stadiumName.setText(stadiumNameBin[i]);
            stadiumInfo.setText(stadiumInfoBin[i]);
         } else if(obj == btnNext && i<4) {
            i++;
            lblstadium.setIcon(stadiumImgBin[i]);
            stadiumName.setText(stadiumNameBin[i]);
            stadiumInfo.setText(stadiumInfoBin[i]);
         }
      }
}