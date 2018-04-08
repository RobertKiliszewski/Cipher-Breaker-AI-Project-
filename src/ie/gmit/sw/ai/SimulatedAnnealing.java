package ie.gmit.sw.ai;

//
//@Author : Robert Kiliszewski
//


import java.security.SecureRandom;

public class SimulatedAnnealing {

	private SecureRandom r;
	private Playfair pf;
	private Grams g;
	private KeyGen key;
	private int temparture;

	private String bestKey;
	private String bestTxt;
	private String statistics;
	
	
	//Constructor
	public SimulatedAnnealing(int temperature, String cipherText) {
		
		super();
		this.r = new SecureRandom();
		this.pf = new Playfair(cipherText);
		this.g = Grams.getInstance("4grams.txt");
		this.key = KeyGen.getInstance();
		this.statistics = "";
		this.temparture = temperature;
		
	}//Constructor

	//SimulatedAnnealing Method
	public void simulatedAnnealing() throws Throwable {
		
		//Load Grams
		g.loadGrams();
		
		//Generate Key
		String parent = key.generateKey();
		
		//Decrypt Text using generated Key
		String decryptedText = pf.decrypt(parent);
		
		//Score Decrypted Text
		double parentScore = g.scoreText(decryptedText);
		
		//Save best score in parentscore
		double bestScore = parentScore;
		
		//save initial score for comparing purpose 
		double initScore = bestScore;
		
		System.out.println("Initial score: " + initScore + "Key: " + parent);

		//Loop each temparture
		for (int temp = temparture; temp > 0; temp--) {
		
			//loop for each transition
			for (int transition = 45000; transition > 0; transition--) {
				
				//Shuffle the parent key in order to get a slightly different result each time we loop
				String child = key.shuffleKey(parent);
				
				//Decrypt text using child key
				decryptedText = pf.decrypt(child);
				
				//Score for the decryption using the child key
				double childScore = g.scoreText(decryptedText);
				
				//Delta Measuring
				double delta = childScore - parentScore;
				
				//If the delta is higher than 0, then chhild key is better than parent key, therefore update parent
				if (delta > 0) {
					
					//Update parent key to child key
					parent = child;
					
					//Update New Score
					parentScore = childScore;
					
				} else {
					
					//If probability is higher than a random value between 0 and 1 
					if ((Math.exp((delta / temp))) > r.nextDouble()) {
						
						//update the key
						parent = child;
						
						//Update Score
						parentScore = childScore;
						
					} 
					
				} 
				//If the parent score is better than the best score, print the result to the screen 
				if (parentScore > bestScore) {
					
					bestScore = parentScore;
					
					this.bestKey = parent;
					this.bestTxt = decryptedText;
					
					System.out.printf("\nTransition: %d "
										+ "\nTemp: %d"
										+ "\nBest Score: %.2f"
										+ "\nKey: %s"
										+ "\nDecrypted message: %s\n",
										transition, temp, bestScore, bestKey, bestTxt);
				} 
				
			} 
			
			System.out.println("temp: " + temp);
			
			if (bestScore > (initScore / 1.5)) {
				
				break;
				
			} 
		}
		
		setStatistics("\nBest Score: " + bestScore + 
						"\n Best key: " + this.bestKey + 
						"\n Deciphered message: " + this.bestTxt);
	}

	public void setStatistics(String statistics) {
		this.statistics = statistics;
	}

	public String getStatistics() {
		return this.statistics;
	}

}
