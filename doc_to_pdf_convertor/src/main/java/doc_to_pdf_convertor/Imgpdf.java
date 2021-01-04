package doc_to_pdf_convertor;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class Imgpdf {

	public static String imgtopdf(String filename) throws BadElementException, MalformedURLException, DocumentException, IOException {
		//String extension="png";
		String out= filename.split("\\.", 2)[0];
		Document document = new Document();
	    String input = filename;
	    String output = out+".pdf";
	    FileOutputStream fos = new FileOutputStream(output);
	    PdfWriter writer = PdfWriter.getInstance(document, fos);
	    writer.open();
	    document.open();
	    Image img = Image.getInstance(input);
	    img.scalePercent(50);
	    document.add(img);
	    document.close();
	    writer.close();
	    new Filedisplay(out);
		return "Success";
	}
	String pdftoimg(String filename,String extension) throws IOException {
		String out= filename.split("\\.", 2)[0];
		PDDocument document = PDDocument.load(new File(filename));
	    PDFRenderer pdfRenderer = new PDFRenderer(document);
	    for (int page = 0; page < document.getNumberOfPages(); ++page) {
	        BufferedImage bim = pdfRenderer.renderImageWithDPI(
	          page, 300, ImageType.RGB);
	        ImageIOUtil.writeImage(
	          bim, String.format(out+"-%d.%s", page + 1, extension), 300);
	    }
	    document.close();
	    try  
        {  
	    File fileexist = new File(out+"."+extension);   
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
