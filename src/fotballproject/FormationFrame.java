package fotballproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FormationFrame extends JFrame implements ActionListener {

   private JPanel contentPane;
   private JButton btnFomation;
   private JLabel lblFormation;
   private JLabel lbl1;
   private JLabel lbl2;
   private JLabel lbl3;
   private JLabel lbl4;
   private JLabel lbl5;
   private JLabel lbl6;
   private JLabel lbl7;
   private JLabel lbl8;
   private JLabel lbl9;
   private JLabel lbl10;
   private JLabel lbl11;
   private JLabel lbl12;
   private JLabel lbl13;
   private JLabel lbl14;
   private JLabel lbl15;
   private JLabel lbl16;
   private JLabel lbl17;
   private JLabel lbl18;
   private JLabel lbl19;
   private JLabel lbl20;
   private JTextField btnFomation2;
   private JButton btnFormation2;
   private JButton btnFomation3;
   private JLabel lbl21;
   private JLabel lbl22;
   private JLabel lbl23;
   private JLabel lbl24;
   private JLabel lbl25;
   private JLabel lbl26;
   private JLabel lbl27;
   private JLabel lbl28;
   private JLabel lbl29;
   private JLabel lbl30;

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
      
      //---------------------------------------------- 4-2-3-1 라벨------------------------------
      lbl1 = new JLabel();
      lblFormation.add(lbl1);
      
      lbl2 = new JLabel();
      lblFormation.add(lbl2);
      
      lbl3 = new JLabel();
      lblFormation.add(lbl3);
      
      lbl4 = new JLabel();
      lblFormation.add(lbl4);
      
      lbl5 = new JLabel();
      lblFormation.add(lbl5);
      
      lbl6 = new JLabel();
      lblFormation.add(lbl6);
      
      lbl7 = new JLabel();
      lblFormation.add(lbl7);
      
      lbl8 = new JLabel();
      lblFormation.add(lbl8);
      
      lbl9 = new JLabel();
      lblFormation.add(lbl9);
      
      lbl10 = new JLabel();
      lblFormation.add(lbl10);
      //----------------------------------------------------4-2-3-1라벨 끝----------------------------
      
      
      //----------------------------------------------------4-1-2-3라벨------------------------------
      lbl11 = new JLabel();
      lblFormation.add(lbl11);
      
      lbl12 = new JLabel();
      lblFormation.add(lbl12);
      
      lbl13 = new JLabel();
      lblFormation.add(lbl13);
      
      lbl14 = new JLabel();
      lblFormation.add(lbl14);
      
      lbl15 = new JLabel();
      lblFormation.add(lbl15);
      
      lbl16 = new JLabel();
      lblFormation.add(lbl16);
      
      lbl17 = new JLabel();
      lblFormation.add(lbl17);
      
      lbl18 = new JLabel();
      lblFormation.add(lbl18);
      
      lbl19 = new JLabel();
      lblFormation.add(lbl19);
      
      lbl20 = new JLabel();
      lblFormation.add(lbl20);
      //----------------------------------------------------4-1-2-3라벨 끝----------------------------
      
      //-----------------------------------------------------4-2-2-2라벨-------------------------
      lbl21 = new JLabel();
      lblFormation.add(lbl21);
      
      lbl22 = new JLabel();
      lblFormation.add(lbl22);
      
      lbl23 = new JLabel();
      lblFormation.add(lbl23);
      
      lbl24 = new JLabel();
      lblFormation.add(lbl24);
      
      lbl25 = new JLabel();
      lblFormation.add(lbl25);
      
      lbl26 = new JLabel();
      lblFormation.add(lbl26);
      
      lbl27 = new JLabel();
      lblFormation.add(lbl27);
      
      lbl28 = new JLabel();
      lblFormation.add(lbl28);
      
      lbl29 = new JLabel();
      lblFormation.add(lbl29);
      
      lbl30 = new JLabel();
      lblFormation.add(lbl30);
      //-----------------------------------------------------4-2-2-2라벨 끝-----------------
      
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
      
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if (obj == btnFomation) {
         
//---------------------------------------4         
         lbl1.setBounds(50, 450, 50, 50);
         lbl1.setBackground(Color.red);
         lbl1.setOpaque(true);
                  
         lbl2.setBounds(130, 450, 50, 50);
         lbl2.setBackground(Color.red);
         lbl2.setOpaque(true);
                     
         lbl3.setBounds(210, 450, 50, 50);
         lbl3.setBackground(Color.red);
         lbl3.setOpaque(true);
                  
         lbl4.setBounds(290, 450, 50, 50);
         lbl4.setBackground(Color.red);
         lbl4.setOpaque(true);
//--------------------------------------2                  
         
         lbl5.setBounds(100, 340, 50, 50);
         lbl5.setBackground(Color.red);
         lbl5.setOpaque(true);
                  
         lbl6.setBounds(247, 340, 50, 50);
         lbl6.setBackground(Color.red);
         lbl6.setOpaque(true);
//---------------------------------------------   3            
         
         lbl7.setBounds(60, 230, 50, 50);
         lbl7.setBackground(Color.red);
         lbl7.setOpaque(true);
                  
         lbl8.setBounds(290, 230, 50, 50);
         lbl8.setBackground(Color.red);
         lbl8.setOpaque(true);
                  
         lbl9.setBounds(175, 230, 50, 50);
         lbl9.setBackground(Color.red);
         lbl9.setOpaque(true);
//------------------------------------------------   1            
         
         lbl10.setBounds(175, 140, 50, 50);
         lbl10.setBackground(Color.red);
         lbl10.setOpaque(true);
         
//------------------------------------------------   
         lbl1.setVisible(true);
         lbl2.setVisible(true);
         lbl3.setVisible(true);
         lbl4.setVisible(true);
         lbl5.setVisible(true);
         lbl6.setVisible(true);
         lbl7.setVisible(true);
         lbl8.setVisible(true);
         lbl9.setVisible(true);
         lbl10.setVisible(true);
         
         lbl11.setVisible(false);
         lbl12.setVisible(false);
         lbl13.setVisible(false);
         lbl14.setVisible(false);
         lbl15.setVisible(false);
         lbl16.setVisible(false);
         lbl17.setVisible(false);
         lbl18.setVisible(false);
         lbl19.setVisible(false);
         lbl20.setVisible(false);
         
         lbl21.setVisible(false);
         lbl22.setVisible(false);
         lbl23.setVisible(false);
         lbl24.setVisible(false);
         lbl25.setVisible(false);
         lbl26.setVisible(false);
         lbl27.setVisible(false);
         lbl28.setVisible(false);
         lbl29.setVisible(false);
         lbl30.setVisible(false);
         
      }else if (obj == btnFormation2) {
//------------------------------------4
         
         lbl11.setBounds(50, 450, 50, 50);
         lbl11.setBackground(Color.red);
         lbl11.setOpaque(true);
                  
         lbl12.setBounds(130, 450, 50, 50);
         lbl12.setBackground(Color.red);
         lbl12.setOpaque(true);
                     
         lbl13.setBounds(210, 450, 50, 50);
         lbl13.setBackground(Color.red);
         lbl13.setOpaque(true);
         
         lbl14.setBounds(290, 450, 50, 50);
         lbl14.setBackground(Color.red);
         lbl14.setOpaque(true);
                  
//-------------------------------------   1      
         lbl15.setBounds(175, 340, 50, 50);
         lbl15.setBackground(Color.red);
         lbl15.setOpaque(true);
//---------------------------   2               
         lbl16.setBounds(100, 230, 50, 50);
         lbl16.setBackground(Color.red);
         lbl16.setOpaque(true);
         
         lbl17.setBounds(247, 230, 50, 50);
         lbl17.setBackground(Color.red);
         lbl17.setOpaque(true);
               
//-------------------------------------   3                  
         
         lbl18.setBounds(60, 140, 50, 50);
         lbl18.setBackground(Color.red);
         lbl18.setOpaque(true);
         
         lbl19.setBounds(175, 140, 50, 50);
         lbl19.setBackground(Color.red);
         lbl19.setOpaque(true);
               
         lbl20.setBounds(290, 140, 50, 50);
         lbl20.setBackground(Color.red);
         lbl20.setOpaque(true);
         
         lbl1.setVisible(false);
         lbl2.setVisible(false);
         lbl3.setVisible(false);
         lbl4.setVisible(false);
         lbl5.setVisible(false);
         lbl6.setVisible(false);
         lbl7.setVisible(false);
         lbl8.setVisible(false);
         lbl9.setVisible(false);
         lbl10.setVisible(false);
         
         lbl11.setVisible(true);
         lbl12.setVisible(true);
         lbl13.setVisible(true);
         lbl14.setVisible(true);
         lbl15.setVisible(true);
         lbl16.setVisible(true);
         lbl17.setVisible(true);
         lbl18.setVisible(true);
         lbl19.setVisible(true);
         lbl20.setVisible(true);
         
         lbl21.setVisible(false);
         lbl22.setVisible(false);
         lbl23.setVisible(false);
         lbl24.setVisible(false);
         lbl25.setVisible(false);
         lbl26.setVisible(false);
         lbl27.setVisible(false);
         lbl28.setVisible(false);
         lbl29.setVisible(false);
         lbl30.setVisible(false);
         
      }else if (obj == btnFomation3) {
//---------------------------------------------4         
         lbl21.setBounds(50, 450, 50, 50);
         lbl21.setBackground(Color.red);
         lbl21.setOpaque(true);
                  
         lbl22.setBounds(130, 450, 50, 50);
         lbl22.setBackground(Color.red);
         lbl22.setOpaque(true);
                     
         lbl23.setBounds(210, 450, 50, 50);
         lbl23.setBackground(Color.red);
         lbl23.setOpaque(true);
                  
         lbl24.setBounds(290, 450, 50, 50);
         lbl24.setBackground(Color.red);
         lbl24.setOpaque(true);
//----------------------------------------------2         
         lbl25.setBounds(100, 340, 50, 50);
         lbl25.setBackground(Color.red);
         lbl25.setOpaque(true);
         
         lbl26.setBounds(247, 340, 50, 50);
         lbl26.setBackground(Color.red);
         lbl26.setOpaque(true);
//----------------------------------------------2
         lbl27.setBounds(60, 230, 50, 50);
         lbl27.setBackground(Color.red);
         lbl27.setOpaque(true);
         
         lbl28.setBounds(290, 230, 50, 50);
         lbl28.setBackground(Color.red);
         lbl28.setOpaque(true);
//----------------------------------------------2   
         lbl29.setBounds(100, 140, 50, 50);
         lbl29.setBackground(Color.red);
         lbl29.setOpaque(true);
         
         lbl30.setBounds(247, 140, 50, 50);
         lbl30.setBackground(Color.red);
         lbl30.setOpaque(true);
         
         lbl1.setVisible(false);
         lbl2.setVisible(false);
         lbl3.setVisible(false);
         lbl4.setVisible(false);
         lbl5.setVisible(false);
         lbl6.setVisible(false);
         lbl7.setVisible(false);
         lbl8.setVisible(false);
         lbl9.setVisible(false);
         lbl10.setVisible(false);
         
         lbl11.setVisible(false);
         lbl12.setVisible(false);
         lbl13.setVisible(false);
         lbl14.setVisible(false);
         lbl15.setVisible(false);
         lbl16.setVisible(false);
         lbl17.setVisible(false);
         lbl18.setVisible(false);
         lbl19.setVisible(false);
         lbl20.setVisible(false);
         
         lbl21.setVisible(true);
         lbl22.setVisible(true);
         lbl23.setVisible(true);
         lbl24.setVisible(true);
         lbl25.setVisible(true);
         lbl26.setVisible(true);
         lbl27.setVisible(true);
         lbl28.setVisible(true);
         lbl29.setVisible(true);
         lbl30.setVisible(true);
      }
      
   }
}
