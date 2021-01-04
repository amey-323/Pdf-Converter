package doc_to_pdf_convertor;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

public class Succesmessage  {
	private static JDialog d;
	Succesmessage(){
	JFrame f=new JFrame();
	d= new JDialog(f , "Success", true);  
	d.setTitle("Success\r\n\r\n");
    d.getContentPane().setLayout( new FlowLayout() );  
    JButton b = new JButton ("OK");  
    b.setHorizontalTextPosition(SwingConstants.CENTER);
    b.setAlignmentX(Component.CENTER_ALIGNMENT);
    b.addActionListener ( new ActionListener()  
    {  
        public void actionPerformed( ActionEvent e )  
        {  
        	Succesmessage.d.setVisible(false);  
        }  
    });  
    JLabel label = new JLabel ("Successfully Created !!");
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
    new Succesmessage();  
}
}

