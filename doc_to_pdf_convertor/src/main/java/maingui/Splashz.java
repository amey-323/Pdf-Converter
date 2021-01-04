package maingui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Cursor;

public class Splashz extends JFrame {
	public JPanel contentPane;
	static JLabel jlabel1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splashz frame = new Splashz();
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
	Splashz() {
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 541, 387);
		contentPane.add(panel);
		panel.setLayout(null);
		
		jlabel1 = new JLabel("jlabel1");
		jlabel1.setBackground(Color.WHITE);
		jlabel1.setForeground(Color.CYAN);
		jlabel1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jlabel1.setHorizontalTextPosition(SwingConstants.CENTER);
		jlabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jlabel1.setBounds(210, 304, 100, 25);
		panel.add(jlabel1);
		
		lblNewLabel = new JLabel("Pdf Converter");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(163, 44, 170, 37);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Splashz.class.getResource("/images/spl.gif")));
		lblNewLabel_1.setBounds(0, 0, 541, 387);
		panel.add(lblNewLabel_1);
	}
}
