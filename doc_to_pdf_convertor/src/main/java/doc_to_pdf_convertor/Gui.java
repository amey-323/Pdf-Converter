package doc_to_pdf_convertor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.itextpdf.text.BadElementException;
import com.lowagie.text.DocumentException;

import javax.swing.SwingConstants;
import javax.xml.parsers.ParserConfigurationException;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
public class Gui {
	 /**
	  * @wbp.parser.entryPoint
	  */
	 public static void stain() {
		 final JFileChooser fileChooser = new JFileChooser();
		 fileChooser.setPreferredSize(new Dimension(600,400));
		final JFrame f=new JFrame("Pdf Converter");  
		f.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 13));
		f.setForeground(Color.BLACK);
		f.setBackground(Color.WHITE);
		f.getContentPane().setBackground(Color.WHITE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    final JButton b=new JButton("Convert");  
	    b.setBackground(new Color(0, 0, 51));
	    b.setForeground(new Color(0, 255, 0));
	    b.setFont(new Font("Times New Roman", Font.BOLD, 26));
	    b.setAlignmentX(Component.CENTER_ALIGNMENT);
	    b.setHorizontalTextPosition(SwingConstants.CENTER);
	    final JButton bn=new JButton(".pdf to docx");  
	    bn.setForeground(new Color(0, 255, 51));
	    bn.setBackground(new Color(0, 0, 51));
	    bn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
	    bn.setBounds(229, 293, 168, 48);
	    b.setBounds(744,92,139,48);  
	    b.addActionListener(new ActionListener(){  
	public void actionPerformed(ActionEvent e){ 
	    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	    int result = fileChooser.showOpenDialog(fileChooser);
	    if (result == JFileChooser.APPROVE_OPTION) {
	        File selectedFile = fileChooser.getSelectedFile();
	        String filepath=selectedFile.getAbsolutePath();
	        String n="null";
	        int ind=filepath.lastIndexOf('.');
	        String extension=filepath.substring(ind+1).toLowerCase();
	        if(extension.equals("doc")||extension.equals("docx")) {
	        PdfDoc a=new PdfDoc();
	        n=a.doctopdf(filepath);
	        if(n.length()!=0) {
				new Succesmessage();
			}
	        }else if(extension.equals("txt")) {
	        	Txtpdf t=new Txtpdf();
	        	try {
					n=t.txttopdf(filepath);
					if(n.length()!=0) {
						new Succesmessage();
					}
				} catch (DocumentException e1) {
					e1.printStackTrace();
				}catch (IOException e1) {
					e1.printStackTrace();
				}
	        }else if(extension.equals("htm")||extension.equals("html")) {
	        	Htmlpdf h=new Htmlpdf();
	        	try {
					n=h.htmtopdf(filepath);
					if(n.length()!=0) {
						new Succesmessage();
					}
				} catch (com.itextpdf.text.DocumentException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	        	
	        }else if(extension.equals("jpg")||extension.equals("png")||extension.equals("jpeg")||extension.equals("gif")||extension.equals("tiff")) {
	        	Imgpdf i=new Imgpdf();
	        	try {
					n=i.imgtopdf(filepath);
					if(n.length()!=0) {
						new Succesmessage();
					}
				} catch (BadElementException e1) {
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (com.itextpdf.text.DocumentException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	        }else if(extension.equals("xls")||extension.equals("xlsx")) {
	        	Xlspdf x=new Xlspdf();
	        	try {
					n=x.xlstopdf(filepath);
					if(n.length()!=0) {
						new Succesmessage();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
	        else {
	        	new Errormessage();
	        }
	    }
	    }  
	    });  
	    bn.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){ 
	    		fileChooser.setPreferredSize(new Dimension(600,400));
	    	    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	    	    int result = fileChooser.showOpenDialog(fileChooser);
	    	    if (result == JFileChooser.APPROVE_OPTION) {
	    	        File selectedFile = fileChooser.getSelectedFile();
	    	        String filepath=selectedFile.getAbsolutePath();
	    	        String n="null";
	    	        int ind=filepath.lastIndexOf('.');
	    	        String extension=filepath.substring(ind+1).toLowerCase();
	    	        if(extension.equals("pdf")) {
	    	        PdfDoc a=new PdfDoc();
	    	        try {
						n=a.pdftodoc(filepath);
						if(n.length()!=0) {
							new Succesmessage();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    	        }else {
	    	        	new Errormessage(); 
	    	        }
	    	}
	    	}});
	    f.getContentPane().add(b);f.getContentPane().add(bn);
	    f.setSize(400,400);  
	    f.getContentPane().setLayout(null);  
	    
	    JButton btnNewButton = new JButton(".pdf to html");
	    btnNewButton.setForeground(new Color(0, 255, 51));
	    btnNewButton.setBackground(new Color(0, 0, 51));
	    btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
	    btnNewButton.setBounds(747, 293, 168, 48);
	    f.getContentPane().add(btnNewButton);
	    btnNewButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){ 
	    		fileChooser.setPreferredSize(new Dimension(600,400));
	    	    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	    	    int result = fileChooser.showOpenDialog(fileChooser);
	    	    if (result == JFileChooser.APPROVE_OPTION) {
	    	        File selectedFile = fileChooser.getSelectedFile();
	    	        String filepath=selectedFile.getAbsolutePath();
	    	        String n="null";
	    	        int ind=filepath.lastIndexOf('.');
	    	        String extension=filepath.substring(ind+1).toLowerCase();
	    	        if(extension.equals("pdf")) {
	    	        Htmlpdf a=new Htmlpdf();
	    	        try {
						n=a.pdftohtml(filepath);
						if(n.length()!=0) {
							new Succesmessage();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    	        }else {
	    	        	new Errormessage();   
	    	        }
	    	}
	    	}});
	    
	    JButton btnNewButton_1 = new JButton(".pdf to txt");
	    btnNewButton_1.setForeground(new Color(0, 255, 51));
	    btnNewButton_1.setBackground(new Color(0, 0, 51));
	    btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
	    btnNewButton_1.setBounds(1204, 293, 168, 48);
	    f.getContentPane().add(btnNewButton_1);
	    btnNewButton_1.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){ 
	    		fileChooser.setPreferredSize(new Dimension(600,400));
	    	    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	    	    int result = fileChooser.showOpenDialog(fileChooser);
	    	    if (result == JFileChooser.APPROVE_OPTION) {
	    	        File selectedFile = fileChooser.getSelectedFile();
	    	        String filepath=selectedFile.getAbsolutePath();
	    	        String n="null";
	    	        int ind=filepath.lastIndexOf('.');
	    	        String extension=filepath.substring(ind+1).toLowerCase();
	    	        if(extension.equals("pdf")) {
	    	        Txtpdf a=new Txtpdf();
	    	        try {
						n=a.pdftotxt(filepath);
						if(n.length()!=0) {
							new Succesmessage();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    	        }else {
	    	        	new Errormessage();   
	    	        }
	    	}
	    	}});
	    JButton btnNewButton_2 = new JButton(".pdf to image");
	    btnNewButton_2.setForeground(new Color(0, 255, 51));
	    btnNewButton_2.setBackground(new Color(0, 0, 51));
	    btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
	    btnNewButton_2.setBounds(229, 468, 168, 48);
	    f.getContentPane().add(btnNewButton_2);
	    btnNewButton_2.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){ 
	    		fileChooser.setPreferredSize(new Dimension(600,400));
	    	    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	    	    int result = fileChooser.showOpenDialog(fileChooser);
	    	    if (result == JFileChooser.APPROVE_OPTION) {
	    	    	File selectedFile = fileChooser.getSelectedFile();
	    	        String filepath=selectedFile.getAbsolutePath();
	    	        String n="null";
	    	        int ind=filepath.lastIndexOf('.');
	    	        String extension=filepath.substring(ind+1).toLowerCase();
	    	        Imgpdf a=new Imgpdf();
	    	        try {
						n=a.pdftoimg(filepath,"png");
						if(n.length()!=0) {
							new Succesmessage();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    	        }
	    	        else {
	    	        	new Errormessage();   
	    	        }
	    	}
	    	});
	    
	    JButton btnNewButton_3 = new JButton(".pdf to ppt");
	    btnNewButton_3.setBackground(new Color(0, 0, 51));
	    btnNewButton_3.setForeground(new Color(0, 255, 51));
	    btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
	    btnNewButton_3.setBounds(747, 468, 168, 48);
	    f.getContentPane().add(btnNewButton_3);
	    btnNewButton_3.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){ 
	    		fileChooser.setPreferredSize(new Dimension(600,400));
	    	    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	    	    int result = fileChooser.showOpenDialog(fileChooser);
	    	    if (result == JFileChooser.APPROVE_OPTION) {
	    	        File selectedFile = fileChooser.getSelectedFile();
	    	        String filepath=selectedFile.getAbsolutePath();
	    	        String n="null";
	    	        int ind=filepath.lastIndexOf('.');
	    	        String extension=filepath.substring(ind+1).toLowerCase();
	    	        if(extension.equals("pdf")) {
	    	        Pptpdf a=new Pptpdf();
	    	        n=a.pdftoppt(filepath);
	    	        if(n.length()!=0) {
						new Succesmessage();
					}
	    	        }else {
	    	        	new Errormessage();   
	    	        }
	    	}
	    	}});
	    JButton btnNewButton_4 = new JButton(".pdf to xls");
	    btnNewButton_4.setBackground(new Color(0, 0, 51));
	    btnNewButton_4.setForeground(new Color(0, 255, 51));
	    btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
	    btnNewButton_4.setBounds(1204, 468, 168, 48);
	    f.getContentPane().add(btnNewButton_4);
	    
	    JLabel lblNewLabel = new JLabel("Conversion to .pdf file");
	    lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setBounds(665, 40, 274, 39);
	    f.getContentPane().add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Convert .pdf to other formats");
	    lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
	    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_1.setBounds(685, 212, 297, 35);
	    f.getContentPane().add(lblNewLabel_1);
	    btnNewButton_4.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){ 
	    		fileChooser.setPreferredSize(new Dimension(600,400));
	    	    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	    	    int result = fileChooser.showOpenDialog(fileChooser);
	    	    if (result == JFileChooser.APPROVE_OPTION) {
	    	        File selectedFile = fileChooser.getSelectedFile();
	    	        String filepath=selectedFile.getAbsolutePath();
	    	        String n="null";
	    	        int ind=filepath.lastIndexOf('.');
	    	        String extension=filepath.substring(ind+1).toLowerCase();
	    	        if(extension.equals("pdf")) {
	    	        Xlspdf a=new Xlspdf();
	    	        n=a.pdftoxls(filepath);
	    	        if(n.length()!=0) {
						new Succesmessage();
					}
	    	        }else {
	    	        	new Errormessage();  
	    	        }
	    	}
	    	}});
	    f.setVisible(true);   
	    
	}
}
