
public class BadFileName extends BadString{

public static void main(String[] args){
  
  FileProcessor fp = new FileProcessor("apple.txt", 5);
		fp.processFile();
}//end main

}//end class