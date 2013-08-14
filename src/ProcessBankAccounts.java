import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;


public class ProcessBankAccounts {

	private BankAccount[] accounts;
	private int n; //number of elements in array
	private FileWriter error; //for error in data


	public ProcessBankAccounts(){}

	public int getArraySize(){
		return n;
	}
	public BankAccount[] getBankAccounts(){
		ProcessBankAccounts account = new ProcessBankAccounts();
		int n = account.getArraySize();
		BankAccount [] X = new BankAccount[n];
		X = account.getBankAccounts();
		return X;
	}
	public void readArray(String fileName){
		
		try
		{
		 
			File inFile = new File("/Users/sebastiandemian/Documents/Workspace/BankAccount/bin/bankaccounts.txt");
	        FileReader fileReader = new FileReader(inFile);
	        BufferedReader bufReader = new BufferedReader(fileReader);
	        
	        n = bufReader.read(); // read first element of the file
	        
	        accounts  = new BankAccount[n];
	        bufReader.skip(1);
	        
	        
	        for(int i=0;i< n;i++){
	        
	        	StringTokenizer tokenizer;
	        	String line,name;
	        	double openingBalance;

	        	line = bufReader.readLine();
	        	tokenizer = new StringTokenizer(line);
	        	name = tokenizer.nextToken();
	        	
	        	try{
	        	openingBalance = Double.parseDouble(tokenizer.nextToken());
	        	accounts[i] = new BankAccount(name, openingBalance);
	        	
	        	} catch (NoSuchElementException e){
	        		accounts[i] = new BankAccount(name);
	        	}
	        
	        }
	       
	        bufReader.close();
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open file. Check if file exists or path is incorrect.");
		        System.exit(0);
		}
		catch (IOException e){
			System.out.println("IOException");
		}
		
	}
	
	public void printArray(){
		System.out.println("Account Number		Name		Balance");
		
		for (BankAccount b : accounts){
			System.out.println(b.getAccountNumber()+"		"+b.getName()+"		"+b.getBalance());
		}	
	}
	
	
	public void overdrawn(){
		System.out.println("Account Number		Name		Balance");
		
		for (BankAccount b : accounts){
			if(b.getBalance() < 0){
			System.out.println(b.getAccountNumber()+"		"+b.getName()+"		"+"("+b.getBalance()+")");
			}
		}	
	}	
	
	
	public void processArray(String fileName){
		System.out.println();
	}
	
	
	
	
	
	
	public static void main(String[] args){
		//number 1
		ProcessBankAccounts p = new ProcessBankAccounts();
		//number 2
		p.readArray(args[0]);
		//number 3
		System.out.println("The accounts before processing are:");
		p.printArray();
		//number 4
		p.processArray(args[1]);
		//number 5
		System.out.println("The accounts that are overdrawn are:");
		p.overdrawn();
		//number 6
		System.out.println("The accounts are:");
		p.printArray();
		//number 7
		System.out.println("The array size is:");
		System.out.println(p.getArraySize());
		System.out.println("The Bank accounts are:");
		System.out.println(p.getBankAccounts());
		
		//number 8
		System.out.println("The account(s) with the largest balance:");
		System.out.println();
		System.out.println("Account Number		Name		Balance");
		
		BankAccount max  = new BankAccount("");
		
		for (BankAccount b : p.accounts){
			if (b.getBalance() > max.getBalance()){
				max = b;
			}
		}
		//print max
		System.out.println(max.getAccountNumber()+"		"+max.getName()+"		"+"("+max.getBalance()+")");
		//if more than one max, print them as well
		for (BankAccount a : p.accounts){
			if (a.getBalance() == max.getBalance()){
				System.out.println(a.getAccountNumber()+"		"+a.getName()+"		"+"("+a.getBalance()+")");
				}	
		}
		
	
	
	
	
	
	
	
	
	}	
}