package ie.gmit.sw.ai;

//
//@Author : Robert Kiliszewski
//


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileHandler {

	public FileHandler() {
	}

	public String readFile(String fileName) throws Throwable {
		
		InputStream is = new FileInputStream(fileName);

		ByteArrayOutputStream result = new ByteArrayOutputStream();
		
		byte[] buffer = new byte[1024];
		int length;
		
		while ((length = is.read(buffer)) != -1) {
			
			result.write(buffer, 0, length);
			
		}
		
		is.close();
		
		return primeText((result.toString().length() > 750) ? result.toString().substring(0, 750) : result.toString());
	}

	//Write to file
	public void writeFile(String text, String fileName) throws Throwable {
		
		FileOutputStream fos = new FileOutputStream(fileName);
		
		fos.write(text.getBytes());
		fos.close();
		
	}

	
	public String primeText(String s) {

		s = (s.length() % 2 == 0) ? s.toUpperCase().replaceAll("\\W", "").replaceAll("[0-9]", "").replace("J", "")		
				: s.toUpperCase().replaceAll("\\W", "").replaceAll("[0-9]", "").replace("J", "") + "X";

		return removeRecurringChars(s);
	}


	//Method to remove duplicates and replace them with x 
	public String removeRecurringChars(String str) {
		
		char[] newLine = str.toCharArray();

		for (int i = 0; i < newLine.length; i++) {
			
			if (i != newLine.length - 1){
				
				newLine[i + 1] = (newLine[i] == newLine[i + 1]) ? 'X' : newLine[i + 1];
				
			}//if 
			
		} // for
		
		return new String(newLine);
		
	}// purge duplicates

}