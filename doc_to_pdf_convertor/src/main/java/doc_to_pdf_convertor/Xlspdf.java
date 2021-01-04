package doc_to_pdf_convertor;

import java.awt.Desktop;
import java.io.File;

import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;
import com.aspose.pdf.Document;
import com.aspose.pdf.ExcelSaveOptions;

public class Xlspdf {
	static String xlstopdf(String filename) throws Exception {
		Workbook workbook = new Workbook(filename);
		// Create PDF options
		String out= filename.split("\\.", 2)[0];
		PdfSaveOptions options = new PdfSaveOptions();
		options.setOnePagePerSheet(true);
		// Save the document in PDF format
		workbook.save(out+".pdf", options);
		new Filedisplay(out);
		return "Done";
	}
	static String pdftoxls(String filename) {
		Document doc = new Document(filename);
		// Set Excel options
		String out= filename.split("\\.", 2)[0];
		ExcelSaveOptions options = new ExcelSaveOptions();
		// Set output format
		options.setFormat(ExcelSaveOptions.ExcelFormat.XLSX);
		// Set minimizing option
		options.setMinimizeTheNumberOfWorksheets(true);
		// Convert PDF to Excel XLSX
		doc.save(out+".xlsx", options);
		try  
        {  
	    File fileexist = new File(out+".xlsx");   
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
