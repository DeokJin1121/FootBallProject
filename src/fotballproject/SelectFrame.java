package fotballproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;

public class SelectFrame extends JFrame {

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
               SelectFrame frame = new SelectFrame();
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
   public SelectFrame() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 619, 315);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(255, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("New label");
      lblNewLabel.setBounds(401, 21, 192, 234);
      contentPane.add(lblNewLabel);
      
      JComboBox comboBox = new JComboBox();
      comboBox.setBounds(197, 82, 192, 30);
      contentPane.add(comboBox);
      
      textField = new JTextField();
      textField.setBounds(197, 197, 192, 30);
      contentPane.add(textField);
      textField.setColumns(10);
      
      textField_1 = new JTextField();
      textField_1.setColumns(10);
      textField_1.setBounds(197, 139, 192, 30);
      contentPane.add(textField_1);
      
      JButton btnNewButton = new JButton("SELECT");
      btnNewButton.setBackground(new Color(153, 204, 255));
      btnNewButton.setForeground(new Color(0, 0, 0));
      btnNewButton.setBounds(159, 245, 91, 23);
      contentPane.add(btnNewButton);
      
      JLabel lblNewLabel_1 = new JLabel("NAME");
      lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabel_1.setBounds(97, 90, 50, 15);
      contentPane.add(lblNewLabel_1);
      
      JLabel lblNewLabel_1_1 = new JLabel("POSITION");
      lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabel_1_1.setBounds(84, 146, 84, 15);
      contentPane.add(lblNewLabel_1_1);
      
      JLabel lblNewLabel_1_1_1 = new JLabel("BACKNUMBER");
      lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabel_1_1_1.setBounds(65, 204, 120, 15);
      contentPane.add(lblNewLabel_1_1_1);
      
      JLabel lblNewLabel_2 = new JLabel("");
      lblNewLabel_2.setIcon(new ImageIcon(SelectFrame.class.getResource("/fotballproject/mancity4.png")));
      lblNewLabel_2.setBounds(0, -4, 91, 89);
      contentPane.add(lblNewLabel_2);
   }
}
