package maingui;

import doc_to_pdf_convertor.Gui;

public class Splashscreen {
	public static void main(String[] args) {
		Splashz splash=new Splashz();
		splash.setVisible(true);
		try {
			for(int i=0;i<=100;i++) {
				Thread.sleep(10);
				Splashz.jlabel1.setText(""+i+"%");
				if(i==100) {
					splash.setVisible(false);
					Gui n=new Gui();
					n.stain();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
