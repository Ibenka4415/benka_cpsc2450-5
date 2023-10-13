import java.io.File;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;


public class textanalyzer {
	

	private static String fileName;

	public static void printWelcome() {
		System.out.println("*************************************************************");
		System.out.println("              Welcome to Text Analyzer V1.0");
		System.out.println("*************************************************************");
		System.out.println("");
		
	}
	public static String  readFile(String fileName) {

	        StringBuilder content = new StringBuilder();

	        try {
	            Scanner fsc = new Scanner(new File("C:\\Users\\isaac\\OneDrive\\Desktop\\" + fileName));
	            while (fsc.hasNextLine()) {
	                String line = fsc.nextLine().toUpperCase();
	                content.append(line).append("\n");
	            }
	            fsc.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            System.out.println("This file does not exist");
	        }

	        return content.toString();
		
	}
	
	public static int countVowels(String fileContent) {
		
		int vowelCount = 0;
        fileContent = fileContent.toLowerCase();

        for (int i = 0; i < fileContent.length(); i++) {
            char currentChar = fileContent.charAt(i);
            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' ||
                currentChar == 'o' || currentChar == 'u') {
                vowelCount++;
            }
        }
        
        return vowelCount;
		
	}
	
	public static int countConsonants(String fileContent) {
		int consonatsCount = 0;
		fileContent = fileContent.toLowerCase();

	    for (int i = 0; i < fileContent.length(); i++) {
	        char consonant = fileContent.charAt(i);
	            
	        if (consonant >= 'a' && consonant <= 'z' && consonant != 'a' &&
	        	consonant !='e' && consonant != 'i' && consonant != 'o' && consonant != 'u') {
	        	consonatsCount++;
	        }
	    }
	    return consonatsCount;  
	}
	
	public static void  writeSummaryToFile (String fileContent,double vowels,double word,double consonants) {
		System.out.print("Enter the name of the file to write the summary:");
		Scanner sc = new Scanner(System.in);
		String newFile = sc.next();
		try {
		      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(newFile))));
		      pw.write(fileContent);
		      pw.print(vowels);
		      pw.print(word);
		      pw.print(consonants);
		      pw.close();
		      System.out.println("The File has been made");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public static int countWords(String fileContent) {
		
		if (fileContent == null || fileContent.isEmpty())
			return 0;
		String[] wordCount = fileContent.split("\\s+");
		
		return wordCount.length;
	}
	
	public static void printMenu() {
		System.out.println("Here are your options:");
		System.out.println("1. Count the number of vowels.");
		System.out.println("2. Count the number of consonants.");
		System.out.println("3. Count the number of words.");
		System.out.println("4. Print a summary to a file.");
		System.out.println("5. Quit.");
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		printWelcome();
	    System.out.print("Enter the name of the file: ");
	    fileName = sc.nextLine();
	    String choice;
		readFile(fileName);
		String fileContent = readFile(fileName);
		double vowels = countVowels(fileContent);
		double consonants = countConsonants(fileContent);
		double word = countWords(fileContent);
		
		do {
			printMenu();
			System.out.print("Enter the number of your choice:");
			choice = sc.next();
			
			if (choice.equals("1")) {
				System.out.printf("There are %s Vowels\n",vowels);
				
				
			}else if (choice.equals("2")) {
				System.out.printf("There are %s Consonants\n",consonants );
				
				
			}else if (choice.equals("3")) {
				System.out.printf("There are %s Words\n", word);
				
			}else if (choice.equals("4")) {
				writeSummaryToFile(fileContent, vowels,word ,consonants );
				
			}else if (!choice.equals("5"))
				System.out.println("You have to enter the number of your choice. You didn't type a number\n");
				
		}while (!choice.equals("5"));
			System.out.println("Thank you for using this program.");
		sc.close();
			
		
		
		
		
		
		}

		
	}
	
	
		
		
		

	
	

