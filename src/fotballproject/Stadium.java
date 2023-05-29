package fotballproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
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
   private JButton btnEthihad;
   private JButton btnAnfield;
   private JButton btnTrafford;
   private JButton btnEmirates;
   private JButton btnStamford;

   public Stadium() {
   	getContentPane().setBackground(new Color(255, 255, 255));
      getContentPane().setFont(new Font("맑은 고딕", Font.BOLD, 12));
      setLocation(300,200);
      setSize(631, 592);
      getContentPane().setLayout(null);
      
      int i = 0;
      
      btnBefore = new JButton("이전");
      btnBefore.setBounds(284, 387, 71, 26);
      getContentPane().add(btnBefore);
      btnBefore.addActionListener(this);
      
      btnNext = new JButton("다음");
      btnNext.setBounds(379, 387, 71, 26);
      getContentPane().add(btnNext);
      btnNext.addActionListener(this);
      
      lblstadium = new JLabel("");
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
      lblstadium.setBounds(46, 100, 387, 268);
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
      stadiumName.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      stadiumName.setText(stadiumNameBin[i]);
      stadiumName.setBounds(46, 388, 215, 21);
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
      stadiumInfo.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      stadiumInfo.setText(stadiumInfoBin[i]);
      stadiumInfo.setBounds(46, 450, 387, 79);
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
      
      btnEthihad = new JButton(new ImageIcon(Stadium.class.getResource("/fotballproject/축구장.jpg")));
      btnEthihad.setBorderPainted(false);
      btnEthihad.setBounds(487, 110, 106, 66);
      btnEthihad.setRolloverIcon(new ImageIcon(Stadium.class.getResource("/fotballproject/축구장2.jpg")));
      getContentPane().add(btnEthihad);
      btnEthihad.addActionListener(this);

      JLabel lblNewLabel = new JLabel("에티하드 스타디움");
      lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 11));
      lblNewLabel.setBounds(494, 176, 106, 15);
      getContentPane().add(lblNewLabel);
      
      btnAnfield = new JButton(new ImageIcon(Stadium.class.getResource("/fotballproject/축구장.jpg")));
      btnAnfield.setBounds(487, 197, 106, 66);
      btnAnfield.setBorderPainted(false);
      btnAnfield.setRolloverIcon(new ImageIcon(Stadium.class.getResource("/fotballproject/축구장2.jpg")));
      getContentPane().add(btnAnfield);
      btnAnfield.addActionListener(this);
      
      JLabel lblNewLabel_1 = new JLabel("안필드 스타디움");
      lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 11));
      lblNewLabel_1.setBounds(497, 263, 88, 15);
      getContentPane().add(lblNewLabel_1);
      
      btnEmirates = new JButton(new ImageIcon(Stadium.class.getResource("/fotballproject/축구장.jpg")));
      btnEmirates.setBorderPainted(false);
      btnEmirates.setRolloverIcon(new ImageIcon(Stadium.class.getResource("/fotballproject/축구장2.jpg")));
      btnEmirates.setBounds(487, 284, 106, 66);
      getContentPane().add(btnEmirates);
      btnEmirates.addActionListener(this);
      
      JLabel lblNewLabel_1_1 = new JLabel("에미레이트 스타디움");
      lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 11));
      lblNewLabel_1_1.setBounds(487, 350, 106, 15);
      getContentPane().add(lblNewLabel_1_1);
      
      btnTrafford = new JButton(new ImageIcon(Stadium.class.getResource("/fotballproject/축구장.jpg")));
      btnTrafford.setBorderPainted(false);
      btnTrafford.setRolloverIcon(new ImageIcon(Stadium.class.getResource("/fotballproject/축구장2.jpg")));
      btnTrafford.setBounds(487, 371, 106, 66);
      getContentPane().add(btnTrafford);
      btnTrafford.addActionListener(this);
      
      JLabel lblNewLabel_1_1_1 = new JLabel("올드 트래포드");
      lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 11));
      lblNewLabel_1_1_1.setBounds(506, 437, 81, 15);
      getContentPane().add(lblNewLabel_1_1_1);
      
      btnStamford = new JButton(new ImageIcon(Stadium.class.getResource("/fotballproject/축구장.jpg")));
      btnStamford.setBorderPainted(false);
      btnStamford.setRolloverIcon(new ImageIcon(Stadium.class.getResource("/fotballproject/축구장2.jpg")));
      btnStamford.setBounds(487, 458, 106, 66);
      getContentPane().add(btnStamford);
      btnStamford.addActionListener(this);
      
      JLabel lblNewLabel_1_1_2 = new JLabel("스탬퍼드 브리지");
      lblNewLabel_1_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 11));
      lblNewLabel_1_1_2.setBounds(498, 524, 88, 15);
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
      
      JLabel lineStadium = new JLabel("");
      lineStadium.setBounds(472, 100, 133, 445);
      getContentPane().add(lineStadium);
      TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.BLACK,1));
      titledBorder.setTitleFont(new Font("Decodig", Font.PLAIN, 20));
      lineStadium.setBorder(titledBorder);
      
      JLabel lblInfo = new JLabel("");
      lblInfo.setBounds(36, 427, 424, 118);
      getContentPane().add(lblInfo);
      lblInfo.setBorder(titledBorder);
      
      JLabel lblStadimName = new JLabel("");
      lblStadimName.setBounds(36, 383, 424, 35);
      getContentPane().add(lblStadimName);
      lblStadimName.setBorder(titledBorder);
      
      JLabel lblImageLine = new JLabel("");
      lblImageLine.setBounds(38, 100, 424, 268);
      getContentPane().add(lblImageLine);
      lblImageLine.setBorder(titledBorder);
      
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
         }	else if(obj == btnEthihad) {
        	 lblstadium.setIcon(stadiumImgBin[0]);
             stadiumName.setText(stadiumNameBin[0]);
             stadiumInfo.setText(stadiumInfoBin[0]);
             i = 0;
         }	else if(obj == btnAnfield) {
        	 lblstadium.setIcon(stadiumImgBin[1]);
             stadiumName.setText(stadiumNameBin[1]);
             stadiumInfo.setText(stadiumInfoBin[1]);
             i = 1;
         }	else if(obj == btnEmirates) {
        	 lblstadium.setIcon(stadiumImgBin[2]);
             stadiumName.setText(stadiumNameBin[2]);
             stadiumInfo.setText(stadiumInfoBin[2]);
             i = 2;
         }	else if(obj == btnTrafford) {
        	 lblstadium.setIcon(stadiumImgBin[3]);
             stadiumName.setText(stadiumNameBin[3]);
             stadiumInfo.setText(stadiumInfoBin[3]);
             i = 3;
         }	else if(obj == btnStamford) {
        	 lblstadium.setIcon(stadiumImgBin[4]);
             stadiumName.setText(stadiumNameBin[4]);
             stadiumInfo.setText(stadiumInfoBin[4]);
             i = 4;
         }
     }
}