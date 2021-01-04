package doc_to_pdf_convertor;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.aspose.pdf.DocSaveOptions;
import com.aspose.pdf.Document;
import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
public class PdfDoc {
	public static String doctopdf(String filename) {
		File inputWord = new File(filename);
		
		String out= filename.split("\\.", 2)[0];
	    File outputFile = new File(out+".pdf");
	    try  {
	        InputStream docxInputStream = new FileInputStream(inputWord);
	        OutputStream outputStream = new FileOutputStream(outputFile);
	        IConverter converter = LocalConverter.builder().build();         
	        converter.convert(docxInputStream).as(DocumentType.DOCX).to(outputStream).as(DocumentType.PDF).execute();
	        outputStream.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    new Filedisplay(out);
	   return "Success";
	}
	static String pdftodoc(String filename) throws IOException 
	{
		String out= filename.split("\\.", 2)[0];
		Document doc = new Document(filename);

		// Instantiate DocSaveOptions instance
		DocSaveOptions saveOptions = new DocSaveOptions();

		// Set output format
		saveOptions.setFormat(DocSaveOptions.DocFormat.DocX);

		// Set the recognition mode as Flow
		saveOptions.setMode(DocSaveOptions.RecognitionMode.Flow);

		// Set the horizontal proximity as 2.5
		saveOptions.setRelativeHorizontalProximity(2.5f);

		// Enable bullets recognition during conversion process
		saveOptions.setRecognizeBullets(true);

		// Save resultant DOCX file
		doc.save(out+".docx", saveOptions);
		try  
        {  
	    File fileexist = new File(out+".docx");   
        if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
        {  
        System.out.println("not supported");  
        return null;  
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
