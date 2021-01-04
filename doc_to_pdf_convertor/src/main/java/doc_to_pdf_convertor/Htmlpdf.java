package doc_to_pdf_convertor;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class Htmlpdf {

	public static String htmtopdf(String filename) throws DocumentException, IOException {
		String out= filename.split("\\.", 2)[0];
		Document document = new Document();
	    PdfWriter writer = PdfWriter.getInstance(document,
	      new FileOutputStream(out+".pdf"));
	    document.open();
	    XMLWorkerHelper.getInstance().parseXHtml(writer, document,
	      new FileInputStream(filename));
	    document.close();
	    new Filedisplay(out);
	    return  "Success";
	}
	String pdftohtml(String filename) throws IOException, ParserConfigurationException {
		PDDocument pdf = PDDocument.load(new File(filename));
		String out= filename.split("\\.", 2)[0];
	    Writer output = new PrintWriter(out+".html", "utf-8");
	    new PDFDomTree().writeText(pdf, output);
	    output.close();
	    try  
        {  
	    File fileexist = new File(out+".html");   
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
		return "Done";
	}
}
