package doc_to_pdf_convertor;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.aspose.pdf.Document;
import com.aspose.pdf.PptxSaveOptions;
import com.aspose.pdf.SaveFormat;
import com.aspose.slides.Presentation;
public class Pptpdf {
	static String pdftoppt(String filename) {
		String out= filename.split("\\.", 2)[0];
		// Load PDF document
		Document pdfDocument = new Document(filename);
		// Set PPTX save options
		PptxSaveOptions pptxOptions = new PptxSaveOptions();
		pptxOptions.setSlidesAsImages(true);
		// Save PDF as PPTX
		pdfDocument.save(out+".pptx", pptxOptions);
		try  
        {  
	    File fileexist = new File(out+".pptx");   
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
		return "Success";
		
	}
	
}
