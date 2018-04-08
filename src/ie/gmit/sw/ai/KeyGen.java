package ie.gmit.sw.ai;

//
//@Author : Robert Kiliszewski
//

import java.security.SecureRandom;
import java.util.Random;

public class KeyGen  {

	private static KeyGen instance;

	//Default Constructor
	private KeyGen() {
		
	}

	//Create new object if it doesn't exist
	public static KeyGen getInstance() {
		
		return (instance == null) ? new KeyGen() : instance;
		
	}

	//Generate Key Method
	public String generateKey() {
		
		//CipherKey
		String cipherKey = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
		char[] key = cipherKey.toCharArray();
		int index;
		
		Random random = new SecureRandom();
		
		for (int i = key.length - 1; i > 0; i--) {
			
			index = random.nextInt(i + 1);
			
			if (index != i) {
				
				key[index] ^= key[i];
				key[i] ^= key[index];
				key[index] ^= key[i];
				
			}
		}
		return new String(key);
		
	}

	//Key Shuffle method
	public String shuffleKey(String originalKey) {
		
		//Create a new SecureRandom
		Random r = new SecureRandom();
		
		//Random int
		int x = r.nextInt(100);

		if (x >= 0 && x < 2) {
			
			return swapRows(originalKey, r.nextInt(4), r.nextInt(4));
			
		} else if (x >= 2 && x < 4) {
			
			return swapCols(originalKey, r.nextInt(4), r.nextInt(4));
			
		} else if (x >= 4 && x < 6) {
			
			return flipRows(originalKey);
			
		} else if (x >= 6 && x < 8) {
			
			return flipCols(originalKey);
			
		} else if (x >= 8 && x < 10) {
			
			return new StringBuffer(originalKey).reverse().toString();
			
		} else {
			
			int a = r.nextInt(originalKey.length() - 1);
			int b = r.nextInt(originalKey.length() - 1);
			b = (a == b) ? (b == originalKey.length() - 1) ? b - 1 : b + 1 : r.nextInt(originalKey.length() - 1);

			char[] res = originalKey.toCharArray();
			char tmp = res[a];
			res[a] = res[b];
			res[b] = tmp;
			return new String(res);
			
		} 
	}

	private String flipRows(String key) {
		
		String[] res = new String[5];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 5; i++) {
			
			res[i] = key.substring(i * 5, i * 5 + 5);
			res[i] = new StringBuffer(res[i]).reverse().toString();
			sb.append(res[i]);
			
		}
		
		return sb.toString();
		
	}

	private String flipCols(String key) {
		
		char[] columns = key.toCharArray();
		int l = key.length() - (key.length() / 5);

		for (int i = 0; i < key.length() / 5; i++) {
			
			for (int j = 0; j < key.length() / 5; j++) {
				
				char tmp = key.charAt(i * 5 + j);
				columns[(i * 5) + j] = key.charAt(l + j);
				columns[l + j] = tmp;
				
			}
			
			l -= 5;
		}
		return new String(columns);
	}

	//Swap Rows
	private String swapRows(String key, int r1, int r2) {
		
		return (r1 == r2) ? swapRows(key, new SecureRandom().nextInt(4), new SecureRandom().nextInt(4))
				
				: permutate(key, r1, r2, true);
	}


	//Swap Columns
	private String swapCols(String key, int c1, int c2) {
		
		return (c1 == c2) ? swapCols(key, new SecureRandom().nextInt(4), new SecureRandom().nextInt(4)): permutate(key, c1, c2, false);
		
	}


	//Key Permutation
	private String permutate(String key, int a, int b, boolean rows) {
		
		char[] newKey = key.toCharArray();
		
		if (rows) {
			
			a *= 5;
			b *= 5;
			
		}
		for (int i = 0; i < key.length() / 5; i++) {
			
			int index = (rows) ? i : i * 5;
			char tmp = newKey[(index + a)];
			
			newKey[(index + a)] = newKey[(index + b)];
			newKey[(index + b)] = tmp;
			
		} 
		
		return new String(newKey);
	}

}