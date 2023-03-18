import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Interval {
	private int leftLimit;
	private int rightLimit;
	private double testedNumbers;
	private double containedNumbers;
	
	public Interval(int leftLimit, int rightLimit) {
		this.leftLimit = leftLimit;
		this.rightLimit = rightLimit;
		this.testedNumbers = 0;
		this.containedNumbers = 0;
	}
	
	public void testMethod(Double x) {
		this.testedNumbers++; //actualizarea corespunzatoare a campului 
		if(x >= this.leftLimit && x<=this.rightLimit)
			this.containedNumbers++;
	}
	
	public void writeMethod() {
		Double percentage;
		percentage = (this.containedNumbers/this.testedNumbers)*100;
		System.out.println("contained numbers "+ this.containedNumbers);
		System.out.println("tested numbers "+this.testedNumbers);
		System.out.println("The interval is: ["+this.leftLimit+" "+this.rightLimit+"]");
		System.out.println("The percentage is: "+ percentage+"%");
	}
}


public class ProcenteNumereReale {
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(System.in);
			BufferedReader reader = new BufferedReader(new FileReader("intervale.dat.txt"));
			String line = reader.readLine();
			int noNumbers = input.nextInt();
			
			//introducem numerele din fisier intr-un tablou 
			Double[] Array = new Double[noNumbers];
			int i = 0;
			while(line != null)
			{
//				System.out.println(line);
				try {
					Array[i] = Double.parseDouble(line);
					
				}
				catch(NumberFormatException e) {
					System.out.println("String-ul nu poate fi convertit" + e);
				}
				
				if(noNumbers <= i)
					noNumbers = i;
				i++;
				line = reader.readLine();
			}
			reader.close();
			for(int j = 0; j< noNumbers; j++)
				{
				System.out.print(Array[j]+ " ");	
				}
			System.out.println();
			//introducem intervalul
			System.out.println("Introdu n ");
			int n = input.nextInt();
			System.out.println("Introdu m ");
			int m = input.nextInt();
			
			//testam numerele pentru a vedea daca sunt in intervalul dorit
			Interval interval = new Interval(n,m);
			for(int j = 0; j < noNumbers; j++)
			{
				interval.testMethod(Array[j]);
			}
			interval.writeMethod();
			input.close();
//			System.out.println(5/10);
		}
		catch(IOException e) {
			System.out.println(e);
		}
//		catch(FileNotFoundException e) {
//			System.out.println("Fisierul nu este creat: "+e);
//		}
		
	}

}



















//try {
//	Scanner input = new Scanner(System.in);
//	int length = input.nextInt();
//	
//	Double[] Array = new Double[length];
//	
//	BufferedReader reader = new BufferedReader(new FileReader("intervale.dat.txt"));
//	String line = reader.readLine();
//	int i = 0;
//	while(line != null) {
//		System.out.println(line);
//		try {
//			Array[i] = Double.parseDouble(line);
//		}
//		catch(NumberFormatException e) {
//			System.out.println("String-ul nu poate fi convertit" + e);
//		}
//		i++;
//		line = reader.readLine();
//	}
//	input.close();
//	reader.close();
//	int contorNumereReale = 0;
//	for(int j = 0; j<i ; j++) {
//		System.out.print(Array[j]+ " ");
//		if(!Double.isNaN(Array[j]))
//			contorNumereReale++;
//	}
//		
//	BufferedWriter writer = new BufferedWriter(new FileWriter("rezultatProcenteReale.txt"));
//	writer.write("Sunt "+contorNumereReale+" numere reale in fisier.");
//	Integer statistica ;
//	statistica = (contorNumereReale/i)*100;
//	
//	writer.write("\n" + statistica);
//	writer.close();
//}
//catch(FileNotFoundException e) {
//	System.out.println(e);
//}
//catch(IOException e) {
//	System.out.println(e);
//}
