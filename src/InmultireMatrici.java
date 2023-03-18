import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InmultireMatrici {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// NxM - MxP  - N M -> linii
		//			  - M P   -> coloane
		// NxM * MxP =>   NxP
		System.out.println("Introdu numarul de linii al primei matrice: ");
		int n = input.nextInt();
		System.out.println("Introdu numarul de coloane al primei matrice: ");
		int m = input.nextInt();
		System.out.println("Introdu numarul de linii al a celei de-a doua matrice: ");
		int p = input.nextInt();
		//initializare matrici - sub forma de obiecte pentru a stoca valorile
		Double[][] A = new Double[n][m];
		Double[][] B = new Double[m][p];
		//prima matrice - citire
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				{
				 System.out.println("Introdu elementul A["+i+"]["+j+"] :");
				 A[i][j] = input.nextDouble();
				 }
		//a doua matrice - citire
		for(int i=0;i<m;i++)
			for(int j=0;j<p;j++)
				{
				System.out.println("Introdu elementul B["+i+"]["+j+"] :");	
				B[i][j] = input.nextDouble();
				}
		//initializare matrice in care introducem rezultatul inmultirii celor 2
		Double[][] C = new Double[n][p];
		
		for(int i = 0; i<n; i++)
			for(int j=0; j<p;j++)
			{
				C[i][j]= 0.0;
				for(int k=0;k<m;k++)
					C[i][j] += A[i][k]*B[k][j];
			}
	
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("rezultatInmultireMatrici.txt"));
			System.out.println("Noua matrice este: ");
			for(int i =0; i<n;i++) {
				for(int j=0; j<p; j++) {
					writer.write(C[i][j] + " ");
					System.out.print(C[i][j] + " ");
				}
				writer.write("\n");
				System.out.println();
			}
			writer.close();
			System.out.println("Rezultatul a fost scris in fisier");
		}
		catch(IOException e)
		{
			System.out.println("eroare la scrierea fisierului");
		}
	
	
	}

}
