package fotballproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class SelectFrame extends JFrame implements ActionListener {

   private JPanel contentPane;
   private JTextField taBackNum;
   private JTextField taPositon;
   private int x;
   private JButton btnSelect;
   private JLabel playerImage;
   private JComboBox comboBox;
   
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

   public SelectFrame() {
	   setTitle("선수 검색");
      setBounds(100, 100, 619, 302);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(255, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);

      playerImage = new JLabel("");
      playerImage.setBounds(401, 12, 192, 240);
      contentPane.add(playerImage);

      String[] name= {"Kyle Walker","Ruben Dias","Kalvin Phillips","John Stones","Nathan Ake","Ilkay Gundogan","Erling Haaland"
            ,"Jack Grealish","Aymeric Laporte","Rodrigo","Kevin De Bruyne","Stefan Ortega","Julian Alvarez","Bernaldo Silva"
            ,"Sergio Gomez","Manuel Akanji","Riyard Mahrez","Ederson Moraes","Maximo Perrone","Scott Carson","Phil Foden"
            ,"Cole Palmer","Rico Lewis"};
      
      comboBox = new JComboBox(name);
      comboBox.setBounds(190, 70, 192, 30);
      contentPane.add(comboBox);
      

      taBackNum = new JTextField();
      taBackNum.setBounds(190, 180, 192, 30);
      contentPane.add(taBackNum);
      taBackNum.setColumns(10);
      

      taPositon = new JTextField();
      taPositon.setColumns(10);
      taPositon.setBounds(190, 125, 192, 30);
      contentPane.add(taPositon);
      
      taBackNum.setFont(new Font("맑은 고딕", Font.BOLD, 14));
      taPositon.setFont(new Font("맑은 고딕", Font.BOLD, 14));

      btnSelect = new JButton("SELECT");
      btnSelect.setForeground(new Color(0, 0, 0));
      btnSelect.setBounds(163, 232, 91, 23);
      contentPane.add(btnSelect);
      btnSelect.addActionListener(this);

      JLabel lblName = new JLabel("NAME");
      lblName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
      lblName.setBounds(80, 76, 50, 15);
      contentPane.add(lblName);

      JLabel lblPositon = new JLabel("POSITION");
      lblPositon.setFont(new Font("맑은 고딕", Font.BOLD, 14));
      lblPositon.setBounds(70, 133, 74, 15);
      contentPane.add(lblPositon);

      JLabel lblBackNum = new JLabel("BACKNUMBER");
      lblBackNum.setFont(new Font("맑은 고딕", Font.BOLD, 14));
      lblBackNum.setBounds(58, 188, 104, 15);
      contentPane.add(lblBackNum);

      JLabel lblLogo = new JLabel("");
      lblLogo.setBounds(5, 5, 68, 68);
      contentPane.add(lblLogo);
      
      ImageIcon daicon1 = new ImageIcon("image/mancity5.png");
      Image daimage1 = daicon1.getImage();
      Image daimage3 = daimage1.getScaledInstance(71, 71, Image.SCALE_SMOOTH);
      ImageIcon daicon3 = new ImageIcon(daimage3);
      lblLogo.setIcon(new ImageIcon(SelectFrame.class.getResource("/fotballproject/MancityLogoSelect.png")));
      
      JLabel linLine = new JLabel("");
      linLine.setBounds(399, 10, 196, 244);
      contentPane.add(linLine);
      TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.BLACK,1));
      linLine.setBorder(titledBorder);

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      x = comboBox.getSelectedIndex();
      if(obj == btnSelect && x == 0) {
         playerImage.setIcon(new ImageIcon("Players/Kyle Walker.jpg"));
         taBackNum.setText("  2");
         taPositon.setText("  DF (수비수)");
      } else if (obj == btnSelect && x == 1) {
         playerImage.setIcon(new ImageIcon("Players/Ruben Dias.png"));
         taBackNum.setText("  3");
         taPositon.setText("  DF (수비수)");
      } else if (obj == btnSelect && x == 2) {
         playerImage.setIcon(new ImageIcon("Players/Kalvin Phillips.jpg"));
         taBackNum.setText("  4");
         taPositon.setText("  MF (미드필더)");
      } else if (obj == btnSelect && x == 3) {
         playerImage.setIcon(new ImageIcon("Players/John Stones.jpg"));
         taBackNum.setText("  5");
         taPositon.setText("  DF (수비수)");
      } else if (obj == btnSelect && x == 4) {
         playerImage.setIcon(new ImageIcon("Players/Nathan Ake.jpg"));
         taBackNum.setText("  6");
         taPositon.setText("  DF (수비수)");
      } else if (obj == btnSelect && x == 5) {
         playerImage.setIcon(new ImageIcon("Players/Ilkay Gundogan.jpg"));
         taBackNum.setText("  8");
         taPositon.setText("  MF (미드필더)");
      } else if (obj == btnSelect && x == 6) {
         playerImage.setIcon(new ImageIcon("Players/Erling Haaland.jpg"));
         taBackNum.setText("  9");
         taPositon.setText("  FW (공격수)");
      } else if (obj == btnSelect && x == 7) {
         playerImage.setIcon(new ImageIcon("Players/Jack Grealish.jpg"));
         taBackNum.setText("  10");
         taPositon.setText("  MF (미드필더)");
      } else if (obj == btnSelect && x == 8) {
         playerImage.setIcon(new ImageIcon("Players/Aymeric Laporte.jpg"));
         taBackNum.setText("  14");
         taPositon.setText("  DF (수비수)");
      } else if (obj == btnSelect && x == 9) {
         playerImage.setIcon(new ImageIcon("Players/Rodrigo.jpg"));
         taBackNum.setText("  16");
         taPositon.setText("  MF (미드필더)");
      } else if (obj == btnSelect && x == 10) {
         playerImage.setIcon(new ImageIcon("Players/Kevin De Bruyne.jpg"));
         taBackNum.setText("  17");
         taPositon.setText("  MF (미드필더)");
      } else if (obj == btnSelect && x == 11) {
         playerImage.setIcon(new ImageIcon("Players/Stefan Ortega Moreno.jpg"));
         taBackNum.setText("  18");
         taPositon.setText("  GK (골키퍼)");
      } else if (obj == btnSelect && x == 12) {
         playerImage.setIcon(new ImageIcon("Players/Julian Alvarez.jpg"));
         taBackNum.setText("  19");
         taPositon.setText("  FW (공격수)");
      } else if (obj == btnSelect && x == 13) {
         playerImage.setIcon(new ImageIcon("Players/Bernaldo Silva.jpg"));
         taBackNum.setText("  20");
         taPositon.setText("  MF (미드필더)");
      } else if (obj == btnSelect && x == 14) {
         playerImage.setIcon(new ImageIcon("Players/Sergio Gomez.jpg"));
         taBackNum.setText("  21");
         taPositon.setText("  DF (수비수)");
      } else if (obj == btnSelect && x == 15) {
         playerImage.setIcon(new ImageIcon("Players/Manuel Akanji.jpg"));
         taBackNum.setText("  25");
         taPositon.setText("  DF (수비수)");
      } else if (obj == btnSelect && x == 16) {
         playerImage.setIcon(new ImageIcon("Players/Riyard Mahrez.jpg"));
         taBackNum.setText("  26");
         taPositon.setText("  FW (공격수)");
      } else if (obj == btnSelect && x == 17) {
         playerImage.setIcon(new ImageIcon("Players/Ederson Moraes.jpg"));
         taBackNum.setText("  31");
         taPositon.setText("  GK (골키퍼)");
      } else if (obj == btnSelect && x == 18) {
         playerImage.setIcon(new ImageIcon("Players/Maximo Perrone.jpg"));
         taBackNum.setText("  32");
         taPositon.setText("  MF (미드필더)");
      } else if (obj == btnSelect && x == 19) {
         playerImage.setIcon(new ImageIcon("Players/Scott Carson.jpg"));
         taBackNum.setText("  33");
         taPositon.setText("  GK (골키퍼)");
      } else if (obj == btnSelect && x == 20) {
         playerImage.setIcon(new ImageIcon("Players/Phil Foden.jpg"));
         taBackNum.setText("  47");
         taPositon.setText("  MF (미드필더)");
      } else if (obj == btnSelect && x == 21) {
         playerImage.setIcon(new ImageIcon("Players/Cole Palmer.jpg"));
         taBackNum.setText("  80");
         taPositon.setText("  MF (미드필더)");
      } else if (obj == btnSelect && x == 22) {
         playerImage.setIcon(new ImageIcon("Players/Rico Lewis.jpg"));
         taBackNum.setText("  82");
         taPositon.setText("  DF (수비수)");
      }
   }
}