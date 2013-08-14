import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		
		File inFile = new File("/Users/sebastiandemian/Documents/Workspace/BankAccount/bin/bankaccounts.txt");
        FileReader fileReader = new FileReader(inFile);
        BufferedReader bufReader = new BufferedReader(fileReader);
        
        String n = bufReader.readLine();
        System.out.println(n);
        bufReader.close();

	}

}
