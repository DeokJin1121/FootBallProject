package fotballproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Color;

public class LoginFrame extends JFrame implements ActionListener {

   private JPanel contentPane;
   private JTextField id;
   private JPasswordField pw;
   private JButton exitbtn;
   private JButton inbtn;
   private LoginFrame LoginFrame;

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

   public LoginFrame() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      setLocationRelativeTo(null);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(255, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      id = new JTextField();
      id.setBounds(27, 112, 397, 32);      
      contentPane.add(id);
      id.setColumns(10);
      
      pw = new JPasswordField();
      pw.setColumns(10);
      pw.setBounds(27, 179, 397, 32);
      pw.setEchoChar('*');
      contentPane.add(pw);
      
      inbtn = new JButton("접속");
      inbtn.addActionListener(this);
      inbtn.setBackground(new Color(153, 204, 255));
      inbtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      
      inbtn.setBounds(89, 221, 114, 34);
      contentPane.add(inbtn);
      
      exitbtn = new JButton("종료");
      exitbtn.addActionListener(this);
      exitbtn.setBackground(new Color(153, 204, 255));
      exitbtn.setBounds(234, 221, 114, 34);
      contentPane.add(exitbtn);
      
      JLabel lblNewLabel = new JLabel("PW");
      lblNewLabel.setFont(new Font("굴림", Font.BOLD, 14));
      lblNewLabel.setBounds(27, 154, 50, 15);
      contentPane.add(lblNewLabel);
      
      JLabel lblId = new JLabel("ID");
      lblId.setFont(new Font("굴림", Font.BOLD, 14));
      lblId.setBounds(31, 78, 50, 24);
      contentPane.add(lblId);
      
      JLabel lblLogo = new JLabel("");
      lblLogo.setBounds(180, 10, 84, 92);
      contentPane.add(lblLogo);
      
      ImageIcon daicon1 = new ImageIcon("image/mancity5.png");
      Image daimage1 = daicon1.getImage();
      Image daimage3 = daimage1.getScaledInstance(71, 71, Image.SCALE_SMOOTH);
      ImageIcon daicon3 = new ImageIcon(daimage3);
      lblLogo.setIcon(daicon3);
      
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if (obj == exitbtn) {
          if(JOptionPane.showConfirmDialog(this, "종료하시겠습니까?", "종료", 
                     JOptionPane.YES_NO_OPTION, 
                     JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION ) {
                  System.exit(0);
               }
      }else if (obj == inbtn) {
         if ("yeonwoonuf".equals(id.getText())&&"jyw092700".equals(pw.getText()) ) {
            MainFrame frame = new MainFrame();
            
         }else if ("deokjin".equals(id.getText())&&"202045099".equals(pw.getText())) {
            MainFrame frame = new MainFrame();
         }else if ("wlals".equals(id.getText())&&"5489".equals(pw.getText())) {
            MainFrame frame = new MainFrame();
            
         }else if("".equals(id.getText())){
            JOptionPane.showMessageDialog(null,"아이디를 입력하세요","",JOptionPane.ERROR_MESSAGE );
            id.setText("");
            pw.setText("");
            id.requestFocus();
         }else if("".equals(pw.getText())){
               JOptionPane.showMessageDialog(null,"비밀번호를 입력하세요","",JOptionPane.ERROR_MESSAGE );
               id.setText("");
               pw.setText("");
               id.requestFocus();
         }else {
            JOptionPane.showMessageDialog(null,"아이디나 비밀번호를 확인하세요","",JOptionPane.ERROR_MESSAGE );
            id.setText("");
            pw.setText("");
            id.requestFocus();
         }
      }
      
   }
}