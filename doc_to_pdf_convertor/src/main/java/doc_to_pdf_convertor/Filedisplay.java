package doc_to_pdf_convertor;

import java.awt.Desktop;
import java.io.File;

public class Filedisplay {
	Filedisplay(String out){
		try  
        {  
	    File fileexist = new File(out+".pdf");   
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
}
