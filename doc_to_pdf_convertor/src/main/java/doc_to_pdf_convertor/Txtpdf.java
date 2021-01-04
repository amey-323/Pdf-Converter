package doc_to_pdf_convertor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import com.itextpdf.text.Font;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.*;
import com.lowagie.text.pdf.*;
public class Txtpdf {
		static String txttopdf(String filename) throws DocumentException, IOException {
			String out= filename.split("\\.", 2)[0];
			Document pdfDoc = new Document(PageSize.A4);
			PdfWriter.getInstance(pdfDoc, new FileOutputStream(out+".pdf"))
			  .setPdfVersion(PdfWriter.PDF_VERSION_1_7);
			pdfDoc.open();
			Font myfont = new Font();
			myfont.setStyle(Font.NORMAL);
			myfont.setSize(11);
			pdfDoc.add(new Paragraph("\n"));
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String strLine;
			while ((strLine = br.readLine()) != null) {
			    Paragraph para = new Paragraph(strLine + "\n");
			    para.setAlignment(Element.ALIGN_JUSTIFIED);
			    pdfDoc.add(para);
			}	
			pdfDoc.close();
			br.close();
			new Filedisplay(out);
			return "Done";
		}
		static String pdftotxt(String filename) throws FileNotFoundException, IOException {
			try {String out= filename.split("\\.", 2)[0];
			      Document document = new Document();
			      document.open();
			      PdfReader reader = new PdfReader(filename);
			      PdfDictionary dictionary = reader.getPageN(1);
			      PRIndirectReference reference = (PRIndirectReference) 
			                dictionary.get(PdfName.CONTENTS);
			                        PRStream stream = (PRStream) PdfReader.getPdfObject(reference);
			                        byte[] bytes = PdfReader.getStreamBytes(stream);
			                        PRTokeniser tokenizer = new PRTokeniser(bytes);
			                        FileOutputStream fos=new FileOutputStream(out+".txt");
			                        StringBuffer buffer = new StringBuffer();
			                        while (tokenizer.nextToken()) {
			                        if (tokenizer.getTokenType() == PRTokeniser.TK_STRING) {
			                                        buffer.append(tokenizer.getStringValue());
			                                        }
			                        }
			                String test=buffer.toString();
			                StringReader stReader = new StringReader(test);
			                int t;
			                while((t=stReader.read())>0)
			                fos.write(t);
			                document.add(new Paragraph(".."));
			                document.close();
			                try  
			    	        {  
			    		    File fileexist = new File(out+".txt");   
			    	        if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
			    	        {  
			    	        System.out.println("not supported"); 
			    	        }  
			    	        Desktop desktop = Desktop.getDesktop();  
			    	        if(fileexist.exists())         //checks file exists or not  
			    	        desktop.open(fileexist);              //opens the specified file  
			    	        }  
			    	        catch(Exception e)  
			    	        {  
			    	        e.printStackTrace();  
			    	        }
			      }
			         catch (Exception e) {
			        	 e.printStackTrace();
			         }
			
			return "Done";
		}

}
