package doc_to_pdf_convertor;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Errormessage {
	private static JDialog d;
	Errormessage(){
	JFrame f=new JFrame();
	d= new JDialog(f , "Error", true);  
	d.setTitle("Error\r\n\r\n");
    d.getContentPane().setLayout( new FlowLayout() );  
    JButton b = new JButton ("OK");  
    b.setHorizontalTextPosition(SwingConstants.CENTER);
    b.setAlignmentX(Component.CENTER_ALIGNMENT);
    b.addActionListener ( new ActionListener()  
    {  
        public void actionPerformed( ActionEvent e )  
        {  
        	Errormessage.d.setVisible(false);  
        }  
    });  
    JLabel label = new JLabel ("Error Wrong file entered!!");
    label.setHorizontalTextPosition(SwingConstants.CENTER);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    d.getContentPane().add( label);  
    d.getContentPane().add(b);   
    d.setLocationRelativeTo(null);
    d.setSize(300,300);
    d.setVisible(true);
}  
public static void main(String args[])  
{  
    new Errormessage();  
}
}
