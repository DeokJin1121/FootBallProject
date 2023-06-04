package fotballproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class FormationFrame extends JFrame implements ActionListener {

   private JPanel contentPane;
   private JButton btnFomation;
   private JLabel lblFormation;
   private JTextField btnFomation2;
   private JButton btnFormation2;
   private JButton btnFomation3;
   
   JLabel[] lbl = new JLabel[34];
   JLabel[] lblname = new JLabel[34];
   JLabel[] lblnumber = new JLabel[34];

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
      
      lblFormation = new JLabel();
      lblFormation.setBounds(12, 33, 400, 572);
      inputPanel.add(lblFormation);
      
      ImageIcon daicon = new ImageIcon("image/fomation5.jpg");
      Image daimage = daicon.getImage();
      Image daimage2 = daimage.getScaledInstance(480 ,754, Image.SCALE_SMOOTH);
      
      lblFormation.setIcon(daicon);
      
      for (int i = 1; i <= 33; i++) {
            lbl[i] = new JLabel();
            lblFormation.add(lbl[i]);
      };
      for (int i = 1; i <= 33; i++) {
            lblname[i] = new JLabel();
            lblFormation.add(lblname[i]);
      };
      for (int i = 1; i <= 33; i++) {
            lblnumber[i] = new JLabel();
            lblFormation.add(lblnumber[i]);
      };
      
      
               

      
      contentPane.add(inputPanel);
      
      inputPanel.setLayout(null);
      
      btnFomation = new JButton("4-2-3-1");
      btnFomation.addActionListener(this);
      btnFomation.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
      btnFomation.setBounds(12, 615, 109, 35);
      inputPanel.add(btnFomation);
      
      btnFormation2 = new JButton("4-1-2-3");
      btnFormation2.addActionListener(this);
      btnFormation2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
      btnFormation2.setBounds(150, 615, 119, 35);
      inputPanel.add(btnFormation2);
      
      btnFomation3 = new JButton("4-2-2-2");
      btnFomation3.addActionListener(this);
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
      
      String[] str = {"1","2","3","4","5","6","7","8","9","10","11"};
      JComboBox<String> combo = new JComboBox<String>(str);
      combo.setBounds(150, 400, 60, 30);
      tablePanel.add(combo);
      JButton btninsert = new JButton("넣기");
      btninsert.setBounds(220, 400, 60, 30);
      tablePanel.add(btninsert);
      
      
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if (obj == btnFomation) {
         for (int i = 1; i <=11; i++) {
            lbl[i].setBackground(Color.red);
            lbl[i].setOpaque(true);
         }
         for (int i = 1; i <=11; i++) {
            lblname[i].setBackground(Color.yellow);
            lblname[i].setOpaque(true);
         }
         for (int i = 1; i <=11; i++) {
            
            lblnumber[i].setOpaque(false);
         }
//----------------------------------골키퍼 위치 ------------
         
         lbl[1].setBounds(175, 510, 50, 50);
         lblname[1].setBounds(152, 560, 90, 15);
         lblnumber[1].setBounds(196, 495, 15, 15);
         lblnumber[1].setText("1");
         
         
//------------------------------------------------4   
         lbl[2].setBounds(30, 430, 50, 50);
         lblname[2].setBounds(9, 480, 90, 15);
         lblnumber[2].setBounds(51, 415, 15, 15);
         lblnumber[2].setText("2");
         
                  
         lbl[3].setBounds(130, 430, 50, 50);
         lblname[3].setBounds(106, 480, 90, 15);
         lblnumber[3].setBounds(150, 415, 15, 15);
         lblnumber[3].setText("3");
         
                     
         lbl[4].setBounds(220, 430, 50, 50);
         lblname[4].setBounds(200, 480, 90, 15);
         lblnumber[4].setBounds(244, 415, 15, 15);
         lblnumber[4].setText("4");
         
                  
         lbl[5].setBounds(320, 430, 50, 50);
         lblname[5].setBounds(300, 480, 90, 15);
         lblnumber[5].setBounds(344, 415, 15, 15);
         lblnumber[5].setText("5");
//------------------------------------------------2                  
         lbl[6].setBounds(100, 340, 50, 50);
         lblname[6].setBounds(80, 390, 90, 15);
         lblnumber[6].setBounds(119, 325, 15, 15);
         lblnumber[6].setText("6");
         
         lbl[7].setBounds(247, 340, 50, 50);
         lblname[7].setBounds(227, 390, 90, 15);
         lblnumber[7].setBounds(266, 325, 15, 15);
         lblnumber[7].setText("7");
//-----------------------------------------------3            
         lbl[8].setBounds(60, 230, 50, 50);
         lblname[8].setBounds(40, 280, 90, 15);
         lblnumber[8].setBounds(79, 215, 15, 15);
         lblnumber[8].setText("8");
         
         lbl[9].setBounds(290, 230, 50, 50);
         lblname[9].setBounds(270, 280, 90, 15);
         lblnumber[9].setBounds(309, 215, 15, 15);
         lblnumber[9].setText("9");
         
         lbl[10].setBounds(175, 230, 50, 50);
         lblname[10].setBounds(155, 280, 90, 15);
         lblnumber[10].setBounds(194, 215, 15, 15);
         lblnumber[10].setText("10");
//------------------------------------------------1            
         lbl[11].setBounds(175, 140, 50, 50);
         lblname[11].setBounds(155, 190, 90, 15);
         lblnumber[11].setBounds(194, 125, 15, 15);
         lblnumber[11].setText("11");
         
         
//------------------------------------------------   
         
         for(int i = 1;i<=11;i++) {
            lbl[i].setVisible(true);
         }
         for(int i = 12;i<=23;i++) {
            lbl[i].setVisible(false);
         }
         for(int i = 24;i<=33;i++) {
            lbl[i].setVisible(false);
         }
//         ------------------------------------------
         for(int i = 1;i<=11;i++) {
            lblname[i].setVisible(true);
         }
         for(int i = 12;i<=23;i++) {
            lblname[i].setVisible(false);
         }
         for(int i = 24;i<=33;i++) {
            lblname[i].setVisible(false);
            
         }
         for(int i = 1;i<=11;i++) {
            lblnumber[i].setVisible(true);
         }
         for(int i = 12;i<=23;i++) {
            lblnumber[i].setVisible(false);
         }
         for(int i = 24;i<=33;i++) {
            lblnumber[i].setVisible(false);
         }
         
      }else if (obj == btnFormation2) {
            for (int i = 11; i <=22; i++) {
               lbl[i].setBackground(Color.red);
               lbl[i].setOpaque(true);
            }
            for (int i = 11; i <=22; i++) {
               lblname[i].setBackground(Color.yellow);
               lblname[i].setOpaque(true);
            }
            for (int i = 11; i <=22; i++) {
               lblnumber[i].setOpaque(false);
            }
            
         lbl[12].setBounds(175, 510, 50, 50);
         lblname[12].setBounds(152, 560, 90, 15);
         lblnumber[12].setBounds(196, 495, 15, 15);
         lblnumber[12].setText("1");
//-----------------------------------------------4
         lbl[13].setBounds(30, 430, 50, 50);
         lblname[13].setBounds(9, 480, 90, 15);
         lblnumber[13].setBounds(51, 415, 15, 15);
         lblnumber[13].setText("2");
         
         lbl[14].setBounds(130, 430, 50, 50);
         lblname[14].setBounds(106, 480, 90, 15);
         lblnumber[14].setBounds(150, 415, 15, 15);
         lblnumber[14].setText("3");
         
         lbl[15].setBounds(220, 430, 50, 50);
         lblname[15].setBounds(200, 480, 90, 15);
         lblnumber[15].setBounds(244, 415, 15, 15);
         lblnumber[15].setText("4");
         
         lbl[16].setBounds(320, 430, 50, 50);
         lblname[16].setBounds(300, 480, 90, 15);
         lblnumber[16].setBounds(344, 415, 15, 15);
         lblnumber[16].setText("5");
         
//-----------------------------------------------1      
         lbl[17].setBounds(175, 340, 50, 50);
         lblname[17].setBounds(155, 390, 90, 15);
         lblnumber[17].setBounds(199, 325, 15, 15);
         lblnumber[17].setText("6");
//---------------------------   2               
         lbl[18].setBounds(100, 230, 50, 50);
         lblname[18].setBounds(80, 280, 90, 15);
         lblnumber[18].setBounds(124, 215, 15, 15);
         lblnumber[18].setText("7");
         
         lbl[19].setBounds(247, 230, 50, 50);
         lblname[19].setBounds(227, 280, 90, 15);
         lblnumber[19].setBounds(271, 215, 15, 15);
         lblnumber[19].setText("8");
//-----------------------------------------------3                  
         lbl[20].setBounds(60, 140, 50, 50);
         lblname[20].setBounds(40, 190, 90, 15);
         lblnumber[20].setBounds(84, 125, 15, 15);
         lblnumber[20].setText("9");
         
         lbl[21].setBounds(175, 140, 50, 50);
         lblname[21].setBounds(155, 190, 90, 15);
         lblnumber[21].setBounds(194, 125, 15, 15);
         lblnumber[21].setText("10");
                     
         lbl[22].setBounds(290, 140, 50, 50);
         lblname[22].setBounds(270, 190, 90, 15);
         lblnumber[22].setBounds(309, 125, 15, 15);
         lblnumber[22].setText("11");
         
         for(int i = 1;i<=11;i++) {
            lbl[i].setVisible(false);
         }
         for(int i = 12;i<=22;i++) {
            lbl[i].setVisible(true);
         }
         for(int i = 24 ;i<=33;i++) {
            lbl[i].setVisible(false);
         }
//----------------------------------------------
         for(int i = 1;i<=11;i++) {
            lblname[i].setVisible(false);
         }
         for(int i = 12;i<=23;i++) {
            lblname[i].setVisible(true);
         }
         for(int i = 24;i<=33;i++) {
            lblname[i].setVisible(false);
         }
         //-------------------------------------
         for(int i = 1;i<=11;i++) {
            lblnumber[i].setVisible(false);
         }
         for(int i = 12;i<=22;i++) {
            lblnumber[i].setVisible(true);
         }
         for(int i = 23;i<=33;i++) {
            lblnumber[i].setVisible(false);
         }
      
         
      }else if (obj == btnFomation3) {
         for (int i = 23; i <=33; i++) {
            lbl[i].setBackground(Color.red);
            lbl[i].setOpaque(true);
         }
         for (int i = 23; i <=33; i++) {
            lblname[i].setBackground(Color.yellow);
            lblname[i].setOpaque(true);
         }
         
         for (int i = 23; i <=33; i++) {
            lblnumber[i].setOpaque(false);
         }
         
         lbl[23].setBounds(175, 510, 50, 50);
         lblname[23].setBounds(152, 560, 90, 15);
         lblnumber[23].setBounds(196, 495, 15, 15);
         lblnumber[23].setText("1");
//---------------------------------------------4         
         lbl[24].setBounds(30, 430, 50, 50);
         lblname[24].setBounds(9, 480, 90, 15);
         lblnumber[24].setBounds(51, 415, 15, 15);
         lblnumber[24].setText("2");

         lbl[25].setBounds(130, 430, 50, 50);
         lblname[25].setBounds(106, 480, 90, 15);
         lblnumber[25].setBounds(150, 415, 15, 15);
         lblnumber[25].setText("3");

         lbl[26].setBounds(220, 430, 50, 50);
         lblname[26].setBounds(200, 480, 90, 15);
         lblnumber[26].setBounds(244, 415, 15, 15);
         lblnumber[26].setText("4");
   
         lbl[27].setBounds(320, 430, 50, 50);
         lblname[27].setBounds(300, 480, 90, 15);
         lblnumber[27].setBounds(344, 415, 15, 15);
         lblnumber[27].setText("5");
      
//----------------------------------------------2         
         lbl[28].setBounds(100, 340, 50, 50);
         lblname[28].setBounds(80, 390, 90, 15);
         lblnumber[28].setBounds(121, 325, 15, 15);
         lblnumber[28].setText("6");
         
         lbl[29].setBounds(247, 340, 50, 50);
         lblname[29].setBounds(227, 390, 90, 15);
         lblnumber[29].setBounds(268, 325, 15, 15);
         lblnumber[29].setText("7");
//----------------------------------------------2
         lbl[30].setBounds(60, 230, 50, 50);
         lblname[30].setBounds(40, 280, 90, 15);
         lblnumber[30].setBounds(81, 215, 15, 15);
         lblnumber[30].setText("8");
         
         lbl[31].setBounds(290, 230, 50, 50);
         lblname[31].setBounds(270, 280, 90, 15);
         lblnumber[31].setBounds(311, 215, 15, 15);
         lblnumber[31].setText("9");
//----------------------------------------------2   
         lbl[32].setBounds(100, 140, 50, 50);
         lblname[32].setBounds(80, 190, 90, 15);
         lblnumber[32].setBounds(119, 125, 15, 15);
         lblnumber[32].setText("10");
         
         lbl[33].setBounds(247, 140, 50, 50);
         lblname[33].setBounds(227, 190, 90, 15);
         lblnumber[33].setBounds(266, 125, 15, 15);
         lblnumber[33].setText("11");
         
         
         for(int i = 1;i<=11;i++) {
            lbl[i].setVisible(false);
         }
         for(int i = 12;i<=22;i++) {
            lbl[i].setVisible(false);
         }
         for(int i = 23;i<=33;i++) {
            lbl[i].setVisible(true);
         }
//-------------------------------------------         
         for(int i = 1;i<=11;i++) {
            lblname[i].setVisible(false);
         }
         for(int i = 12;i<=22;i++) {
            lblname[i].setVisible(false);
         }
         for(int i = 23;i<=33;i++) {
            lblname[i].setVisible(true);
         }
         
         for(int i = 1;i<=11;i++) {
            lblnumber[i].setVisible(false);
         }
         for(int i = 12;i<=22;i++) {
            lblnumber[i].setVisible(false);
         }
         for(int i = 23;i<=33;i++) {
            lblnumber[i].setVisible(true);
         }
         
      }
      
   }
}

