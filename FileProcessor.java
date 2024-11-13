import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class FileProcessor {

	private String fileName;
	protected int stringLength;
	private ArrayList<String> stringList;
	
	
	public FileProcessor(String fileName, int stringLength) {
	    setFileName(fileName);
	    setStringLength(stringLength);
	    stringList = new ArrayList<>();
	}
	

	public int getArrayListSize() {
        return stringList.size();
    }
	
	public int getStringLength() {
		return stringLength;
	}
	
	private void setStringLength(int length) {
		length = fileName.length();
		if (length < 5) {
            this.stringLength = 5;
        } else {
            this.stringLength = length;
            System.out.println(stringLength);
            System.out.println(fileName);
        }
    }
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	public void processFile() {

        try (Scanner scnr = new Scanner(new File(fileName))) {
            while (scnr.hasNextLine()) {
                String line = scnr.nextLine();
                if (line.length() > stringLength) {
                	throw new StringTooLongException("String is too long: " + line);
                }
                stringList.add(line);
                }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (StringTooLongException e) {
            System.out.println(e.getMessage());
        }
    }//end processFile
}//end class