
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class NumarDeLinii {
	
	public static void writeTextToFile(String text, String fileName) {
		try {
			File file = new File(fileName);
			if(!file.exists())
				file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)));
			
			bw.write(text + "\n");
			bw.write(text + "\n");
			bw.write(text + "\n");
			bw.write(text + "\n");
			bw.write(text + "\n");
			bw.write(text + "\n");
			
			bw.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	
	public static void readTextFromFile( String textUser, String fileName) {
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader readFile = new BufferedReader(file);
			int contor = 0;
			String line = readFile.readLine();
			while(line!=null) {
				if(line.equals(textUser))
					contor++;
				line = readFile.readLine();
			}
			if(contor == 0)
			 {
				System.out.println("Textul introdus de dvs nu apare in fisier.");
			 }
			else
				System.out.println(contor);
			readFile.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string to be written in the file: ");
		String inputStringFile = input.nextLine();
		
		System.out.println("Enter the name of the file: ");
		String inputFileName = input.nextLine();
		
		System.out.println("Enter a string: ");
		String inputString = input.nextLine();

		writeTextToFile(inputStringFile, inputFileName);
		readTextFromFile(inputString, inputFileName);
		
		input.close();
	}

}
