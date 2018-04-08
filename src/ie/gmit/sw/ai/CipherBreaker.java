package ie.gmit.sw.ai;

//
//@Author : Robert Kiliszewski
//


import java.util.Scanner;

public class CipherBreaker {

	public static void main(String[] args) throws Exception, Throwable {
		Scanner console = new Scanner(System.in);
		
		System.out.println("--------------------------------2018-------------------------------------------");
		System.out.println("---------------------------Text Decryption-------------------------------------");
		System.out.println("--------------------------Robert Kiliszewski-----------------------------------");
		System.out.println("-------------------------Artificial Inteligence--------------------------------");
		
		int choice = 0;
		boolean exit = false;
		String fileName = "";

		do {
			System.out.println("---------MENU---------");
			System.out.println("Decrypt File..........1");
			System.out.println("Decrypt Text..........2");
			System.out.println("Exit..................3");
			System.out.println("Choice: ");
			choice = console.nextInt();

			switch (choice) {
			
			case 1:
				System.out.println("Enter the file name you want to decrypt: ");
				fileName = console.next();
				fileName += ".txt";

				String cipherText = new FileHandler().readFile(fileName);
				System.out.println("Lenght of the Text To be Decrypted: " + cipherText.length());
				
				System.out.println("Decryption Began");
				long startTime = System.currentTimeMillis();
				SimulatedAnnealing sa = new SimulatedAnnealing(20, cipherText);
				sa.simulatedAnnealing();
				long estimatedTime = System.currentTimeMillis() - startTime;
				
				System.out.println("Executed in: " + estimatedTime / 1000 + " Seconds");
				System.out.println("Enter The name for the file you want to save: ");
				fileName = "";
				fileName = console.next();
				fileName += ".txt";
				
				new FileHandler().writeFile("Executed in: " + estimatedTime / 1000 + " Seconds \n" + sa.getStatistics(),fileName);
				break;
				
			case 2: 
				System.out.println("Enter the text you want to decrypt: ");
				String CipheredText = console.next();
				
				startTime = System.currentTimeMillis();
				sa = new SimulatedAnnealing(20, CipheredText);
				sa.simulatedAnnealing();
				estimatedTime = System.currentTimeMillis() - startTime;
				
				System.out.println("Executed in: " + estimatedTime / 1000 + " Seconds");
				System.out.println("Enter The name for the file you want to save: ");
				fileName = "";
				fileName = console.next();
				fileName += ".txt";
				
				new FileHandler().writeFile("Time Elapsed: " + estimatedTime / 1000 + "  Seconds \n " + sa.getStatistics(),fileName);
				break;
				
			case 3:
				exit = true;
				break;
				
			}// switch
		} while (!exit);
		
		console.close();

		System.out.println("Exiting");
		
	}

}
