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

public class StarterFrame extends JFrame  {

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
	
	public static void main(String[] args) {
		
	}

	public StarterFrame() {
		
	}
}
