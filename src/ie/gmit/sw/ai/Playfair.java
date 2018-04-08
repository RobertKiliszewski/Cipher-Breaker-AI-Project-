package ie.gmit.sw.ai;

//
//@Author : Robert Kiliszewski
//



public class Playfair {
	
	private String cipherText;

	//Constructor
	public Playfair(String cipherText) {
		
		super();
		this.cipherText = cipherText;
		
	}
	
	//Decryptin method
	public String decrypt(String decryptionKey) throws Exception {		
		
		char[][] cipherTable = populateTable(decryptionKey);
		
		return cipherCrack(cipherTable, 0, new StringBuilder(), true);
		
	}
	
	///CipherCrack method
	private String cipherCrack(char[][] table, int index, StringBuilder sb, boolean decrypt) {
		
		int modifier = (decrypt) ? 4 : 1;
		
		if(index < (this.cipherText.length() / 2) - 1 ) {
			char a = this.cipherText.charAt(2 * index);
			char b = this.cipherText.charAt(2 * index + 1);
			int r1 = (int) Position.getPos(a, table).getPosX();
			int c1 = (int) Position.getPos(a, table).getPosY();
			int r2 = (int) Position.getPos(b, table).getPosX();
			int c2 = (int) Position.getPos(b, table).getPosY();

			if (r1 == r2) {
				
				c1 = (c1 + modifier) % 5; 
				c2 = (c2 + modifier) % 5;
				
			} else if (c1 == c2) {
				
				r1 = (r1 + modifier) % 5;
				r2 = (r2 + modifier) % 5;
				
			} else {
				
		        int temp = c1;
		        c1 = c2;
		        c2 = temp;
		        
		    }
			
			sb.append(table[r1][c1] +""+ table[r2][c2]);
			
			return cipherCrack(table, 1 + index, sb, decrypt);
			
		}else{
			
			return sb.toString();
		}
		
	}// cipherCrack
	

	public char[][] populateTable(String key){
		
		char[][] cipherTable = new char[5][5];
		int index = 0;
		
		for (int i = 0; i < 5; i++) {
			
			for (int j = 0; j < 5; j++) {
				
				cipherTable[i][j] = key.charAt(index);
				index++;
				
			}
			
		}
		
		return cipherTable;
		
	}
	
	public String getCipherText() {
		
		return cipherText;
	}

	public void setCipherText(String cipherText) {
		
		this.cipherText = cipherText;
	}
}